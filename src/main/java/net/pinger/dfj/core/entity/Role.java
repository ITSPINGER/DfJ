package net.pinger.dfj.core.entity;

import net.pinger.dfj.core.Client;
import net.pinger.dfj.core.utils.Snowflake;
import net.pinger.dfj.core.utils.iface.Mentionable;
import net.pinger.dfj.rest.Promise;

import java.awt.Color;
import java.util.List;

public interface Role extends Mentionable, Comparable<Role> {

	Snowflake getId();

	int getPosition();

	List<Promise<Permission>> getPermissions();

	long getPermissionsRaw();

	String getName();

	boolean isMentionable();

	Color getColor();

	long getColorRaw();

	Client getClient();

}
