package org.hbrs.se1.ws25.exercises.uebung3.persistence;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PersistenceStrategyStream<E> implements PersistenceStrategy<E> {

    // URL of file, in which the objects are stored
    private String location = "objects.ser";

    // Backdoor method used only for testing purposes, if the location should be changed in a Unit-Test
    // Example: Location is a directory (Streams do not like directories, so try this out ;-)!
    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    /**
     * Method for saving a list of Member-objects to a disk (HDD)
     * Look-up in Google for further help! Good source:
     * https://www.digitalocean.com/community/tutorials/objectoutputstream-java-write-object-file
     * (Last Access: Oct, 13th 2025)
     */
    public void save(List<E> member) throws PersistenceException  {
        File file = new File(location);
        if (file.isDirectory()) {
            throw new PersistenceException(
                    PersistenceException.ExceptionType.ConnectionNotAvailable,
                    "Location ist ein Verzeichnis: " + location
            );
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(location))) {
            oos.writeObject(member);
        } catch (IOException e) {
            throw new PersistenceException(
                    PersistenceException.ExceptionType.ConnectionNotAvailable,
                    "Fehler beim Speichern: " + e.getMessage()
            );
        }
    }

    @Override
    /**
     * Method for loading a list of Member-objects from a disk (HDD)
     * Some coding examples come for free :-)
     * Take also a look at the import statements above ;-!
     */
    public List<E> load() throws PersistenceException  {
        // Some Coding hints ;-)

        // ObjectInputStream ois = null;
        // FileInputStream fis = null;
        // List<...> newListe =  null;
        //
        // Initiating the Stream (can also be moved to method openConnection()... ;-)
        // fis = new FileInputStream( " a location to a file" );

        // Tipp: Use a directory (ends with "/") to implement a negative test case ;-)
        // ois = new ObjectInputStream(fis);

        // Reading and extracting the list (try .. catch ommitted here)
        // Object obj = ois.readObject();

        // if (obj instanceof List<?>) {
        //       newListe = (List) obj;
        // return newListe

        // and finally close the streams

        ObjectInputStream ois = null;
        FileInputStream fis = null;
        List<E> newList = new ArrayList<>();

        try {
            File file = new File(location);

            // Testfall: Wenn Location ein Directory ist → Exception
            if (file.isDirectory()) {
                throw new PersistenceException(
                        PersistenceException.ExceptionType.ConnectionNotAvailable,
                        "Location ist ein Verzeichnis: " + location
                );
            }

            // Falls Datei nicht existiert: gib einfach leere Liste zurück
            if (!file.exists()) {
                return newList;
            }

            // Stream öffnen
            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);

            // Objekt lesen
            Object obj = ois.readObject();

            // Typ prüfen und casten
            if (obj instanceof List<?>) {
                newList = (List<E>) obj;
            } else {
                throw new PersistenceException(
                        PersistenceException.ExceptionType.ConnectionNotAvailable,
                        "Gespeichertes Objekt ist keine gültige Liste!"
                );
            }

        } catch (IOException | ClassNotFoundException e) {
            throw new PersistenceException(
                    PersistenceException.ExceptionType.ConnectionNotAvailable,
                    "Fehler beim Laden: " + e.getMessage()
            );
        } finally {
            // Streams schließen (sicher)
            try {
                if (ois != null) ois.close();
                if (fis != null) fis.close();
            } catch (IOException e) {
                System.err.println("Warnung: Fehler beim Schließen des Streams: " + e.getMessage());
            }
        }

        return newList;
    }
}
