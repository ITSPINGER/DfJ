package net.pinger.dfj.core.entity.impl;

import net.pinger.dfj.core.Client;
import net.pinger.dfj.core.entity.ChannelType;
import net.pinger.dfj.core.entity.TextChannel;

public class TextChannelImpl implements TextChannel {

	private final String name;
	private final Client client;

	public TextChannelImpl(Client client, String name) {
		this.client = client;
		this.name = name;
	}

	@Override
	public Client getClient() {
		return client;
	}

	@Override
	public ChannelType getType() {
		return ChannelType.TEXT_CHANNEL;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Object getMentionedObject() {
		return this;
	}

	@Override
	public String getMention() {
		return "#" + this.name;
	}
}
