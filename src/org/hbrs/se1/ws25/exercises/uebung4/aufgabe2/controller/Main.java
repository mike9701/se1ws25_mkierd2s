package org.hbrs.se1.ws25.exercises.uebung4.aufgabe2.controller;

import org.hbrs.se1.ws25.exercises.uebung4.aufgabe2.model.Container;
import org.hbrs.se1.ws25.exercises.uebung4.aufgabe2.view.UserStoryView;

public class Main {
    public static void main(String[] args) {
        Container container = Container.getInstance();
        UserStoryView view = new UserStoryView();
        InputDialog cli = new InputDialog(container, view);
        cli.run();
    }
}
