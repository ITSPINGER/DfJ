package net.pinger.dfj.rest;


import net.pinger.dfj.core.entity.User;
import net.pinger.dfj.core.entity.impl.UserImpl;

public class Request {

	public static void main(String[] args) {
		Promise<Integer> promise = Promise.of(1);

		UserImpl user = new UserImpl(1);


		promise.then(System.out::println).thenAsync(System.out::print).then(integer -> System.out.println(integer + 51)).thenAsync(integer -> System.out.println(integer + 2)).complete();
	}

}
