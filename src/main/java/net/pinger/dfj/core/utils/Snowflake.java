package net.pinger.dfj.core.utils;

import java.time.Instant;

public class Snowflake {

	private final long id;

	private Snowflake(final long id) {
		this.id = id;
	}

	private Snowflake(String id) {
		this.id = Long.valueOf(id);
	}

	public static Snowflake of(final long id) {
		return new Snowflake(id);
	}

	public static Snowflake of(final String id) {
		return new Snowflake(id);
	}

	public Instant getCreationTime() {
		return Instant.ofEpochMilli((id >>> 22) + DiscordUtil.DISCORD_EPOCH);
	}

	public long getIdLong() {
		return id;
	}

	public String getId() {
		return Long.toUnsignedString(id);
	}


}
