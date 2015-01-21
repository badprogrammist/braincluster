package ru.braincluster.project;

/**
 * Created by Ильдар on 20.01.2015.
 */
public enum UserProjectRole {

    OWNER("Владелец"),
    HELPER("Помощник");

    private String title;

    UserProjectRole(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
