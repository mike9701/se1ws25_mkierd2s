package org.hbrs.se1.ws25.exercises.uebung4.aufgabe2.model;

public class ContainerException extends Exception{
    public ContainerException(Integer id) {
        super("Das UserStory-Objekt mit der ID " + id + " ist bereits vorhanden!");
    }
}
