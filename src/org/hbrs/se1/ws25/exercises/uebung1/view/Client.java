package org.hbrs.se1.ws25.exercises.uebung1.view;

import org.hbrs.se1.ws25.exercises.uebung1.control.Translator;
import org.hbrs.se1.ws25.exercises.uebung1.control.TranslatorFactory;

public class Client {

	/**
	 * Methode zur Ausgabe einer Zahl auf der Console
	 * (auch bezeichnet als CLI, Terminal)
	 *
	 */
	void display( int aNumber ){
		// In dieser Methode soll die Methode translateNumber
		// mit dem übergegebenen Wert der Variable aNumber
		// aufgerufen werden.
		//
		// Strenge Implementierung (nur) gegen das Interface Translator gewuenscht!

		//GermanTranslator translator = new GermanTranslator();
		Translator translator = TranslatorFactory.createGermanTranslator();
		String result = translator.translateNumber(aNumber);

		System.out.println("Das Ergebnis der Berechnung: " + result);
	}

	public static void main(String[] args) {
		Client client = new Client();

		// Testfälle
		client.display(5);   // gültig → "fünf"
		client.display(10);  // gültig → "zehn"
		client.display(-3);   // ungültig → Fehlermeldung
		client.display(13);  // ungültig → Fehlermeldung
	}
}


