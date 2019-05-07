package net.pinger.dfj.core.entity.impl;

import net.pinger.dfj.core.Client;
import net.pinger.dfj.core.utils.Activity;

public class ClientImpl implements Client {

	private Activity activity;
	private String token;

	public ClientImpl(Activity activity, String token) {
		this.activity = activity;
		this.token = token;
	}

	@Override
	public Activity getActivity() {
		return activity;
	}

	@Override
	public void setToken(String token) {
		this.token = token;
	}
}
