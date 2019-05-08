package net.pinger.dfj.core.entity;

import lombok.NonNull;
import net.pinger.dfj.core.Client;
import net.pinger.dfj.core.utils.Snowflake;
import net.pinger.dfj.core.utils.iface.Mentionable;
import net.pinger.dfj.rest.Promise;

import javax.annotation.Nullable;
import java.time.Instant;

public interface Member extends Mentionable {

	Promise<User> getUser();

	Snowflake getId();

	@NonNull String getName();

	boolean hasNickname();

	@Nullable String getNickname();

	default Long getIdLong() {
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
