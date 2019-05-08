package net.pinger.dfj.core.entity;

import net.pinger.dfj.core.Client;
import net.pinger.dfj.core.utils.Snowflake;
import net.pinger.dfj.rest.Promise;

import java.time.Instant;

public interface User {

	Promise<Member> getMember();

	String getDiscriminator();

	Snowflake getId();

	String getName();

	default long getIdLong() {
		return getId().getIdLong();
	}

	default String getIdString() {
		return Long.toUnsignedString(getIdLong());
	}

	default Instant getCreationTime() {
		return getId().getCreationTime();
	}

	Client getClient();

}
