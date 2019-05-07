package net.pinger.dfj.core.entity;

import net.pinger.dfj.core.utils.Snowflake;
import net.pinger.dfj.rest.Promise;

import java.time.Instant;

public interface Member {

	Promise<User> getUser();

	Snowflake getId();

	default Long getIdLong() {
		return getId().getIdLong();
	}

	default String getIdString() {
		return Long.toUnsignedString(getIdLong());
	}

	default Instant getCreationTime() {
		return getId().getCreationTime();
	}



}
