package net.pinger.dfj.core.entity;

public enum Permission implements Comparable<Permission> {

	IDK(0),

	UNKNOWN(-1);

	private final int id;

	Permission(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

}
