package net.pinger.dfj.core;

public interface Client {

	static ClientBuilder Builder() {
		return new ClientBuilder();
	}

}
