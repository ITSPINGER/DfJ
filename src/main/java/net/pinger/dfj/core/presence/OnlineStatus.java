package net.pinger.dfj.core.presence;

public enum OnlineStatus {

	OFFLINE("Offline", 0, "offline"),
	DO_NOT_DISTURB("Do not Disturb", 1, "dnd"),
	IDLE("Idle", 2, "idle"),
	ONLINE("Online", 3, "online"),

	UNKNOWN("Unknown", -1, "");

	private final String name;
	private final long id;
	private final String key;

	OnlineStatus(String name, long id, String key) {
		this.name = name;
		this.id = id;
		this.key = key;
	}

	public String getName() {
		return name;
	}

	public long getId() {
		return id;
	}

	public String getKey() {
		return key;
	}

	/**
	 * This method will return an {@link net.pinger.dfj.core.presence.OnlineStatus} from a specified name.
	 * <b>Returns a {@link net.pinger.dfj.core.presence.OnlineStatus#UNKNOWN} status if the specified name doesn't match any status.</b>
	 *
	 * @param name The name used to retrieve an {@link net.pinger.dfj.core.presence.OnlineStatus}.
	 * @return {@link net.pinger.dfj.core.presence.OnlineStatus}
	 */

	public static OnlineStatus getFromName(final String name) {
		for (OnlineStatus status : values()) {
			if (status.getName().equalsIgnoreCase(name)) {
				return status;
			}
		}

		return OnlineStatus.UNKNOWN;
	}

	/**
	 * This method will return an {@link net.pinger.dfj.core.presence.OnlineStatus} from a specified id.
	 * <b>Returns a {@link net.pinger.dfj.core.presence.OnlineStatus#UNKNOWN} status if the specified id doesn't match any status.</b>
	 *
	 * @param id The key used to retrieve an {@link net.pinger.dfj.core.presence.OnlineStatus}.
	 * @return {@link net.pinger.dfj.core.presence.OnlineStatus}
	 */

	public static OnlineStatus getFromId(final long id) {
		for (OnlineStatus status : values()) {
			if (status.id == id) {
				return status;
			}
		}

		return OnlineStatus.UNKNOWN;
	}

	/**
	 * This method will return an {@link net.pinger.dfj.core.presence.OnlineStatus} from a specified key related to discord.
	 * <b>Returns a {@link net.pinger.dfj.core.presence.OnlineStatus#UNKNOWN} status if the specified key doesn't match any status.</b>
	 *
	 * @param key The key used to retrieve an {@link net.pinger.dfj.core.presence.OnlineStatus}.
	 * @return {@link net.pinger.dfj.core.presence.OnlineStatus}
	 */

	public static OnlineStatus getFromKey(final String key) {
		for (OnlineStatus status : values()) {
			if (status.key.equalsIgnoreCase(key)) {
				return status;
			}
		}

		return OnlineStatus.UNKNOWN;
	}



}
