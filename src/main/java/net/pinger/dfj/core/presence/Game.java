package net.pinger.dfj.core.presence;

public enum Game {

	PLAYING(0),
	STREAMING(1),
	LISTENING(2);

	private final long id;

	Game(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}
}
