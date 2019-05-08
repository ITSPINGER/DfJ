package net.pinger.dfj.core.entity.impl;

import net.pinger.dfj.core.Client;
import net.pinger.dfj.core.entity.Member;
import net.pinger.dfj.core.entity.User;
import net.pinger.dfj.core.utils.Snowflake;
import net.pinger.dfj.rest.Promise;

import java.util.Objects;

public class UserImpl implements User {

	private final Snowflake id;
	private Member member;
	private final Client client;

	private String discriminator;
	private String name;

	public UserImpl(Snowflake id, Client client) {
		this.id = id;
		this.client = client;
	}

	@Override
	public Promise<Member> getMember() {
		Objects.requireNonNull(member);

		return Promise.of(this.member);
	}

	@Override
	public String getDiscriminator() {
		return this.discriminator;
	}

	@Override
	public Snowflake getId() {
		return id;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public Client getClient() {
		return client;
	}

	public UserImpl setMember(Member member) {
		this.member = member;
		return this;
	}

	public UserImpl setDiscriminator(String discriminator) {
		this.discriminator = discriminator;
		return this;
	}

	public UserImpl setName(String name) {
		this.name = name;
		return this;
	}
}
