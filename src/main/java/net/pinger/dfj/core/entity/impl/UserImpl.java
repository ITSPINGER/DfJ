package net.pinger.dfj.core.entity.impl;

import net.pinger.dfj.core.entity.Member;
import net.pinger.dfj.core.entity.User;
import net.pinger.dfj.core.utils.Snowflake;
import net.pinger.dfj.rest.Promise;

import java.util.Objects;

public class UserImpl implements User {

	private final Snowflake id;
	private Member member;

	public UserImpl(Snowflake id) {
		this.id = id;
	}

	@Override
	public Promise<Member> getMember() {
		Objects.requireNonNull(member);

		return Promise.of(this.member);
	}

	@Override
	public String getDiscriminator() {
		return null;
	}

	@Override
	public Snowflake getId() {
		return id;
	}

	public UserImpl setMember(Member member) {
		this.member = member;
		return this;
	}
}
