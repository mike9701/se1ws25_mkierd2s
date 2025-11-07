package org.hbrs.se1.ws25.exercises.uebung4.aufgabe2.model;

import org.hbrs.se1.ws25.exercises.uebung3.persistence.PersistenceException;
import org.hbrs.se1.ws25.exercises.uebung3.persistence.PersistenceStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Container {
    // Statische Referenz auf das einzige Objekt
    private static Container instance = null;

    // Privater Konstruktor verhindert direkte Instanziierung
    private Container() {
    }

    // Öffentliche statische Zugriffsmethode
    public static Container getInstance() {
        if (instance == null) {
            instance = new Container();
        }
        return instance;
    }

    private PersistenceStrategy<UserStory> persistenceStrategy;

    public void setPersistenceStrategy(PersistenceStrategy<UserStory> persistenceStrategy) {
        this.persistenceStrategy = persistenceStrategy;
    }

    public void store() throws PersistenceException {
        if (persistenceStrategy == null) {
            throw new PersistenceException(
                    PersistenceException.ExceptionType.NoStrategyIsSet,
                    "Keine Persistenzstrategie gesetzt!"
            );
        }
        persistenceStrategy.save(userstories);
    }

    public void load() throws PersistenceException {
        if (persistenceStrategy == null) {
            throw new PersistenceException(
                    PersistenceException.ExceptionType.NoStrategyIsSet,
                    "Keine Persistenzstrategie gesetzt!"
            );
        }

        List<UserStory> loaded = persistenceStrategy.load();
        userstories.clear();
        userstories.addAll(loaded);
    }

    private List<UserStory> userstories = new ArrayList<>();

    public void addUserStory(UserStory userstory) throws ContainerException {
        if (userstory == null) {
            throw new IllegalArgumentException("UserStory darf nicht null sein!");
        }

        for (UserStory u : userstories) {
            if (u.getID().equals(userstory.getID())) {
                throw new ContainerException(userstory.getID());
            }
        }
        userstories.add(userstory);
    }

    public String deleteUserStory(Integer id) {
        for (UserStory u : userstories) {
            if (u.getID().equals(id)) {
                userstories.remove(u);
                return "UserStory mit ID " + id + " wurde gelöscht.";
            }
        }
        return "UserStory mit ID " + id + " nicht gefunden.";
    }

    public int size() {
        return userstories.size();
    }

    public List<UserStory> getCurrentAllUserStories() {
        // Wir geben eine "unveränderliche" Sicht zurück,
        // damit niemand von außen direkt die Liste manipulieren kann
        return Collections.unmodifiableList(userstories);
    }

    public void deleteAllUserStories() {
        userstories.clear();
    }
}
