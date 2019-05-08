package net.pinger.dfj.core;

import net.pinger.dfj.core.entity.impl.ClientImpl;
import net.pinger.dfj.core.utils.Activity;

public class ClientBuilder {

	private String token;
	private Activity activity;

	public ClientBuilder setToken(String token) {
		this.token = token;
		return this;
	}

	public ClientBuilder setActivity(Activity activity) {
		this.activity = activity;
		return this;
	}

	public Client build() {
		Client client = new ClientImpl(activity, token);
		((ClientImpl) client).login();
		return client;
	}

}
