package net.pinger.dfj.rest;


import net.pinger.dfj.core.Client;
import net.pinger.dfj.core.entity.User;
import net.pinger.dfj.core.entity.impl.UserImpl;
import net.pinger.dfj.core.presence.Game;
import net.pinger.dfj.core.utils.Activity;

public class Request {

	public static void main(String[] args) {
		Promise<Integer> promise = Promise.of(1);

		Client client = Client.Builder().setActivity(Activity.of(Game.PLAYING, "Pinger is gay")).setToken("MzA4NTUxNzE2NTYyMDEwMTEz.XNK3nA.3VoRysxWXVXTZ3s8Ua9LywWF_YQ").build();

	}

}
