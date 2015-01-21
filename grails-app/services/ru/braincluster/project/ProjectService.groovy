package ru.braincluster.project

import grails.transaction.Transactional
import ru.braincluster.user.User

@Transactional
class ProjectService {

    def void join(User user, Project project) {
        project.addToUsers(new UserProject(user:user, project:project,role: UserProjectRole.HELPER));
        project.save();
    }

    def Long createProject(String title, String description, User owner) {
        if(title && description && owner) {
            Project project = new Project(title: title, description: description);
            project.addToUsers(new UserProject(user: owner,project: project));
            project.save();
            return project.id
        } else {
            return -1;
        }
    }

    def Boolean isPossibleToJoin(User user, Project project) {
        def userProject = UserProject.findAllByUserAndProject(user, project)
        if(userProject) {
            return false;
        }
        return true;
    }

    def Boolean isOwner(User user, Project project) {
        def userProject = UserProject.findAllByUserAndProject(user, project)
        if(userProject) {
            if(!userProject.isEmpty()){
                return userProject.role.get(0) == UserProjectRole.OWNER;
            }
        }
        return false;
    }

    def Set<UserProject> getUserProjects(User user) {
        if(user != null) {
            return UserProject.findAllByUser(user);
        } else {
            return Collections.EMPTY_SET;
        }
    }


}
