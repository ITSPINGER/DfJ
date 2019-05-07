package net.pinger.dfj.core;

import net.pinger.dfj.core.entity.impl.ClientImpl;
import net.pinger.dfj.core.utils.Activity;

public class ClientBuilder {

	private String token;
	private Activity activity;

	public void setToken(String token) {
		this.token = token;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public Client build() {
		Client client = new ClientImpl(activity, token);
		return client;
	}

}
