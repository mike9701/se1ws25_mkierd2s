package org.hbrs.se1.ws25.exercises.uebung1.control;

public class TranslatorFactory {
    public static Translator createGermanTranslator(){
        GermanTranslator translator = new GermanTranslator();
        translator.setDate("Okt/2025");
        return translator;
    }
}
