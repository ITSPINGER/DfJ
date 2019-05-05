package net.pinger.dfj.core.utils;

import lombok.NonNull;
import lombok.experimental.NonFinal;
import net.pinger.dfj.core.presence.Game;

import javax.annotation.Nullable;

public class Activity {

	@NonNull
	private final String name;

	@NonNull
	private final Game game;

	@NonFinal @Nullable
	private String key;

	private Activity(Game game, String name) {
		this.name = name;
		this.game = game;
	}

	private Activity(String name, String key) {
		this.name = name;
		this.game = Game.STREAMING;
		this.key = key;
	}



	public static Activity of(Game game, String name) {
		return new Activity(game, name);
	}

	/**
	 * Returns a new instance of {@link net.pinger.dfj.core.utils.Activity} while the {@link net.pinger.dfj.core.presence.Game} is equal to  {@link net.pinger.dfj.core.presence.Game#STREAMING}.
	 *  See the <a href = "https://discordapp.com/developers/docs/topics/gateway#activity-object">Discord Activity Object</a>
	 *
	 * @throws IllegalArgumentException if the key doesn't start with a <a href = "https://www.twitch.tv/">Twitch</a> prefix.
	 *
	 * @param name The name displayed as a Game playing on Discord displayed as {@link net.pinger.dfj.core.presence.Game#STREAMING} <h3>"Streaming {name}"</h3>
	 * @param key The key which returns a <a href = "https://www.twitch.tv/">Twitch</a> url.
	 * @return Returns a new {@link net.pinger.dfj.core.utils.Activity} instance.
	 */

	public static Activity streaming(String name, String key) {
		if (!key.startsWith("https://www.twitch.tv/"))
			throw new IllegalArgumentException("Key must start with ``https://www.twitch.tv/``!");

		return new Activity(name, key);
	}



}
