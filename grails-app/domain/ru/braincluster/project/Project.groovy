package ru.braincluster.project

class Project {

    String title
    String description
    ProjectStatus status = ProjectStatus.VOTING;
    Date dateCreated;
    Date lastUpdated;

    static hasMany = [
        users:UserProject
    ]

    static constraints = {
    }

    static mapping = {
        description(type: "text")
        status(enumType: "string", sqlType: "char(64)")
    }
}
