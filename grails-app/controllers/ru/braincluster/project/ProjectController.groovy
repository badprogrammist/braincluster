package ru.braincluster.project

import grails.plugin.springsecurity.annotation.Secured
import ru.braincluster.security.SecurityService


class ProjectController {

    def ProjectService projectService;
    def SecurityService securityService;

    def index() { }

    @Secured(['ROLE_USER'])
    def create() {

    }

    @Secured(['ROLE_USER'])
    def save() {
        projectService.createProject(params.title,params.description,securityService.currentUser);
        redirect(action: "my");
    }

    @Secured(['ROLE_USER'])
    def my() {
        Set<UserProject> userProjects = projectService.getUserProjects(securityService.currentUser)
        return [userProjects: userProjects]
    }

    @Secured(['permitAll'])
    def all() {
        Set<Project> projects = Project.findAll();
        return [projects: projects]
    }

    @Secured(['ROLE_USER'])
    def view() {
        Long id = new Long(params.id);
        if(id) {
            def project = Project.get(id);
            def isPossibleToJoin = projectService.isPossibleToJoin(securityService.currentUser, project)
            return [projectItem:project, isPossibleToJoin:isPossibleToJoin];
        }
    }

    @Secured(['ROLE_USER'])
    def join() {
        def projectId = params.id;
        if(projectId) {
            def project = Project.get(projectId);
            if(project) {
                projectService.join(securityService.currentUser, project);
            }
            redirect(action: "view",id:projectId);
        }
    }



}
