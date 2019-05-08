package net.pinger.dfj.core.entity.impl;

import net.pinger.dfj.core.Client;
import net.pinger.dfj.core.entity.Member;
import net.pinger.dfj.core.entity.User;
import net.pinger.dfj.core.utils.Snowflake;
import net.pinger.dfj.rest.Promise;

import javax.annotation.Nullable;
import java.util.Objects;

public class MemberImpl implements Member {

	private final User user;
	private final Snowflake id;
	private final Client client;

	private String name;
	private String nickname;

	public MemberImpl(User user, Snowflake id, Client client) {
		this.user = user;
		this.id = id;
		this.client = client;
	}

	@Override
	public Promise<User> getUser() {
		Objects.requireNonNull(user, "User may not be null!");

		return Promise.of(this.user);
	}

	@Override
	public Snowflake getId() {
		return this.id;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public boolean hasNickname() {
		return false;
	}

	@Nullable
	@Override
	public String getNickname() {
		return this.nickname;
	}

	@Override
	public Client getClient() {
		return this.client;
	}

	@Override
	public Object getMentionedObject() {
		return this;
	}

	@Override
	public String getMention() {
		return "<@" + name + ">";
	}

	private class MemberBuilder {

		private String name;
		private String nickname;

		private final MemberImpl impl = MemberImpl.this;

		private MemberBuilder() {}

		public MemberBuilder setName(String name) {
			this.name = name;
			return this;
		}

		public MemberBuilder setNickname(String nickname) {
			this.nickname = nickname;
			return this;
		}

		public Member build() {
			this.impl.name = this.name;
			this.impl.nickname = this.nickname;
			return impl;
		}

	}
}
