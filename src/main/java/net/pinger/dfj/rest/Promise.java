package net.pinger.dfj.rest;

import javax.annotation.CheckReturnValue;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;

@SuppressWarnings("unchecked")
public class Promise<T> {

	private final Object object;

	private final Set<Consumer<? super T>> asyncTasks = new HashSet<>();
	private final Set<Consumer<? super T>> syncTasks = new HashSet<>();

	private boolean executed = false;
	private boolean called = false;

	private Promise(T object) {
		this.object = object;
	}

	public static <R> Promise<R> of(R object) {
		return new Promise<>(object);
	}

	@CheckReturnValue
	public Promise<T> then(Consumer<? super T> consumer) {
		// If already executed, just create another instance forehead.
		if (executed || called) return this;

		syncTasks.add(consumer);
		return this;
	}

	@CheckReturnValue
	public Promise<T> thenAsync(Consumer<? super T> consumer) {
		// If already executed, just create another instance forehead.
		if (executed || called) return this;

		asyncTasks.add(consumer);
		return this;
	}

	@CheckReturnValue
	public Promise<T> thenIf(Predicate<? super T> predicate, Consumer<? super T> consumer) {
		if (executed || called) return this;

		boolean can = predicate.test((T) object);
		if (can) syncTasks.add(consumer);

		return this;
	}

	@CheckReturnValue
	public Promise<T> thenIfAsync(Predicate<? super T> predicate, Consumer<? super T> consumer) {
		if (executed || called) return this;

		boolean can = predicate.test((T) object);
		if (can) asyncTasks.add(consumer);

		return this;
	}

	private void setExecuted() {
		this.executed = true;
	}

	public T get() {
		return (T) object;
	}

	public void run() {
		if (executed) return;

		this.called = true;

		for (Consumer<? super T> consumer : syncTasks) {
			consumer.accept((T) object);
		}

		setExecuted();
	}

	public void runAsync() {
		if (executed) return;

		this.called = true;

		for (Consumer<? super T> consumer : asyncTasks) {
			new Thread(() -> {
				consumer.accept((T) object);
			}).start();
		}

		setExecuted();
	}

	public T complete() {
		if (executed) return (T) object;

		this.called = true;

		for (Consumer<? super T> consumer : syncTasks) {
			consumer.accept((T) object);
		}

		for (Consumer<? super T> consumer : asyncTasks) {
			new Thread(() -> {
				consumer.accept((T) object);
			}).start();
		}

		setExecuted();
		return (T) object;
	}

}
