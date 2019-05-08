package net.pinger.dfj.core.entity;

import net.pinger.dfj.core.utils.Snowflake;
import net.pinger.dfj.rest.Promise;

import java.util.List;

public interface Guild {

	Snowflake getId();

	List<Promise<User>> getUsers();

	Promise<User> getUserById(long id);

	default Promise<User> getUserById(String id) {
		return getUserById(Long.parseUnsignedLong(id));
	}

	List<Promise<Member>> getMembers();

	Promise<Member> getMemberById(long id);

	default Promise<Member> getMemberById(String id) {
		return getMemberById(Long.parseUnsignedLong(id));
	}

	List<Promise<TextChannel>> getTextChannels();

	List<Promise<TextChannel>> getChannelsByName(String name, boolean ignore);

	Promise<TextChannel> getTextChannelById(long id);

	default Promise<TextChannel> getTextChannelById(String id) {
		return getTextChannelById(Long.parseUnsignedLong(id));
	}

	List<Promise<Role>> getRoles();

	Promise<Role> getRolesById(long id);

	default Promise<Role> getRolesById(String id) {
		return getRolesById(Long.parseUnsignedLong(id));
	}

}
