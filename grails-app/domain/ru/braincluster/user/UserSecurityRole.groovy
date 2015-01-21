package ru.braincluster.user

import org.apache.commons.lang.builder.HashCodeBuilder

class UserSecurityRole implements Serializable {

	private static final long serialVersionUID = 1

	User user
	SecurityRole securityRole

	boolean equals(other) {
		if (!(other instanceof UserSecurityRole)) {
			return false
		}

		other.user?.id == user?.id &&
		other.securityRole?.id == securityRole?.id
	}

	int hashCode() {
		def builder = new HashCodeBuilder()
		if (user) builder.append(user.id)
		if (securityRole) builder.append(securityRole.id)
		builder.toHashCode()
	}

	static UserSecurityRole get(long userId, long securityRoleId) {
		UserSecurityRole.where {
			user == User.load(userId) &&
			securityRole == SecurityRole.load(securityRoleId)
		}.get()
	}

	static boolean exists(long userId, long securityRoleId) {
		UserSecurityRole.where {
			user == User.load(userId) &&
			securityRole == SecurityRole.load(securityRoleId)
		}.count() > 0
	}

	static UserSecurityRole create(User user, SecurityRole securityRole, boolean flush = false) {
		def instance = new UserSecurityRole(user: user, securityRole: securityRole)
		instance.save(flush: flush, insert: true)
		instance
	}

	static boolean remove(User u, SecurityRole r, boolean flush = false) {
		if (u == null || r == null) return false

		int rowCount = UserSecurityRole.where {
			user == User.load(u.id) &&
			securityRole == SecurityRole.load(r.id)
		}.deleteAll()

		if (flush) { UserSecurityRole.withSession { it.flush() } }

		rowCount > 0
	}

	static void removeAll(User u, boolean flush = false) {
		if (u == null) return

		UserSecurityRole.where {
			user == User.load(u.id)
		}.deleteAll()

		if (flush) { UserSecurityRole.withSession { it.flush() } }
	}

	static void removeAll(SecurityRole r, boolean flush = false) {
		if (r == null) return

		UserSecurityRole.where {
			securityRole == SecurityRole.load(r.id)
		}.deleteAll()

		if (flush) { UserSecurityRole.withSession { it.flush() } }
	}

	static constraints = {
		securityRole validator: { SecurityRole r, UserSecurityRole ur ->
			if (ur.user == null) return
			boolean existing = false
			UserSecurityRole.withNewSession {
				existing = UserSecurityRole.exists(ur.user.id, r.id)
			}
			if (existing) {
				return 'userRole.exists'
			}
		}
	}

	static mapping = {
		id composite: ['securityRole', 'user']
		version false
	}
}
