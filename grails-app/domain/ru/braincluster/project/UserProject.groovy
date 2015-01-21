package ru.braincluster.project

import ru.braincluster.user.User

class UserProject {

    UserProjectRole role = UserProjectRole.OWNER;

    static belongsTo = [
        user:User,
        project:Project
    ]

    static constraints = {
    }

    static mapping = {
        role(enumType: "string", sqlType: "char(64)")
    }
}
