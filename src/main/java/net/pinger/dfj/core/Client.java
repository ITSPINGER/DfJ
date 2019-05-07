package net.pinger.dfj.core;

import net.pinger.dfj.core.entity.Guild;
import net.pinger.dfj.core.entity.Role;
import net.pinger.dfj.core.utils.Activity;
import net.pinger.dfj.rest.Promise;

import java.util.List;

public interface Client {

	Activity getActivity();

	List<Guild> getGuilds();

	Promise<Guild> getGuildById(long id);

	List<Role> getRoles();

	Promise<Role> getRolesById(long id);

	default int getConnectedGuilds() {
		return getGuilds().size();
	}

	void setToken(String token);

	static ClientBuilder Builder() {
		return new ClientBuilder();
	}
}
