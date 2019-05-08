package net.pinger.dfj.core.entity.impl;

import net.pinger.dfj.core.Client;
import net.pinger.dfj.core.entity.Guild;
import net.pinger.dfj.core.entity.Role;
import net.pinger.dfj.core.utils.Activity;
import net.pinger.dfj.rest.Promise;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ClientImpl implements Client {

	public final static Logger CLIENT_LOGGER = LoggerFactory.getLogger(ClientImpl.class);

	private Activity activity;
	private String token;

	private List<Guild> guilds = new ArrayList<>();

	public ClientImpl(Activity activity, String token) {
		this.activity = activity;
		this.token = token;
	}

	@Override
	public Activity getActivity() {
		return activity;
	}

	@Override
	public List<Guild> getGuilds() {
		return guilds;
	}

	@Override
	public Promise<Guild> getGuildById(long id) {
		Objects.requireNonNull(guilds, "Guilds must not be null.");

		for (Guild guild : guilds) {
			if (guild.getId().getIdLong() == id) {
				return Promise.of(guild);
			}
		}

		return Promise.of(null);
	}

	@Override
	public List<Role> getRoles() {
		return null;
	}

	@Override
	public Promise<Role> getRolesById(long id) {
		return null;
	}

	@Override
	public void setToken(String token) {
		this.token = token;
	}

	public void login() {
		OkHttpClient ok = new OkHttpClient();
		Request request = new Request.Builder().url("https://discordapp.com/api/users/169202582957457410").addHeader("Authorization", "Bot " + this.token).build();
		try {
			Response response = ok.newCall(request).execute();
			System.out.println(response.body());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
