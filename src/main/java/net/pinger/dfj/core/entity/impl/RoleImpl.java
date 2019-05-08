package net.pinger.dfj.core.entity.impl;

import net.pinger.dfj.core.Client;
import net.pinger.dfj.core.entity.Permission;
import net.pinger.dfj.core.entity.Role;
import net.pinger.dfj.core.utils.Snowflake;
import net.pinger.dfj.rest.Promise;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RoleImpl implements Role {

	private final List<Permission> permissions;
	private final Client client;

	private String name;

	public RoleImpl(List<Permission> permissions, Client client) {
		this.permissions = permissions;
		this.client = client;
	}

	@Override
	public Snowflake getId() {
		return null;
	}

	@Override
	public int getPosition() {
		return 0;
	}

	@Override
	public List<Promise<Permission>> getPermissions() {
		List<Promise<Permission>> permissions = new ArrayList<>();
		for (Permission permission : this.permissions) {
			permissions.add(Promise.of(permission));
		}

		return Collections.unmodifiableList(permissions);
	}

	@Override
	public long getPermissionsRaw() {
		return 0;
	}

	@Override
	public Client getClient() {
		return client;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public boolean isMentionable() {
		return false;
	}

	@Override
	public Color getColor() {
		return null;
	}

	@Override
	public long getColorRaw() {
		return 0;
	}

	/**
	 * todo
	 * @param o
	 * @return
	 */

	@Override
	public int compareTo(Role o) {
		List<Permission> permissions = new ArrayList<>();
		Permission first = this.permissions.stream().max(Comparator.comparingInt(Permission::getId)).orElse(Permission.UNKNOWN);
		return -1;
	}

	@Override
	public Object getMentionedObject() {
		return this;
	}

	@Override
	public String getMention() {
		return "@" + name;
	}

	public RoleBuilder Builder() {
		return new RoleBuilder();
	}

	private final class RoleBuilder {

		private String name;
		private final RoleImpl impl = RoleImpl.this;

		private RoleBuilder() {}

		public RoleBuilder setName(String name) {
			this.name = name;
			return this;
		}

		public RoleImpl build() {
			RoleImpl.this.name = this.name;
			return impl;
		}



	}
}
