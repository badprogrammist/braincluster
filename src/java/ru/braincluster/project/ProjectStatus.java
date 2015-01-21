package ru.braincluster.project;

/**
 * Created by Ильдар on 20.01.2015.
 */
public enum ProjectStatus {

    VOTING("Голосование"),
    IN_WORK("В работе"),
    FINISH("Завершен");

    private String title;

    ProjectStatus(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
