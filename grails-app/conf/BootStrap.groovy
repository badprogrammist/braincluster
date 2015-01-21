import ru.braincluster.user.UserSecurityRole
import ru.braincluster.user.SecurityRole
import ru.braincluster.user.User

class BootStrap {

    def init = { servletContext ->
        def adminRole = new SecurityRole(authority: 'ROLE_ADMIN').save()
        def userRole = new SecurityRole(authority: 'ROLE_USER').save()

        def adminUser = new User(username: 'admin', enabled: true, password: 'admin')
        adminUser.save()
        def userUser = new User(username: 'user', enabled: true, password: 'user')
        userUser.save()
        def user2 = new User(username: 'user2', enabled: true, password: 'user2')
        user2.save()

        UserSecurityRole.create(adminUser, adminRole, false)
        UserSecurityRole.create(userUser, userRole, false)
        UserSecurityRole.create(user2, userRole, false)
    }
    def destroy = {
    }
}
