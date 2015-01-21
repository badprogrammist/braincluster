package ru.braincluster.security

import grails.plugin.springsecurity.SpringSecurityService
import grails.transaction.Transactional
import ru.braincluster.user.User

@Transactional
class SecurityService {

    def SpringSecurityService springSecurityService;

    def User getCurrentUser() {
        return springSecurityService.currentUser;
    }
}
