package org.hbrs.se1.ws25.exercises.uebung3;

import java.sql.SQLOutput;

public class TestSingleton {
    public static void main(String[] args) {
        Container c1 = Container.getInstance();
        Container c2 = Container.getInstance();

        System.out.println(c1 == c2);
    }
}
