package net.pinger.dfj.core.entity;

import net.pinger.dfj.core.Client;
import net.pinger.dfj.core.utils.iface.Mentionable;

public interface Channel extends Mentionable {

	Client getClient();

	ChannelType getType();

	String getName();



}
