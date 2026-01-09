package org.hbrs.se1.ws25.tests.uebung10;

import org.hbrs.se1.ws25.exercises.uebung10.aufgabe1.BoundingBoxFactory;
import org.hbrs.se1.ws25.exercises.uebung10.aufgabe1.MyPoint;
import org.hbrs.se1.ws25.exercises.uebung10.aufgabe1.MyPrettyRectangle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyPrettyRectangleTest {

	private MyPrettyRectangle left;
	private MyPrettyRectangle middle;
	private MyPrettyRectangle right;
	private MyPrettyRectangle somewhere;

	/*
	 * Set-Up Methode ("BeforeEach"), die fuer alle Test-Methoden die Rechtecke gemaeß der Skizze definiert.
	 * Wird vor jeder Test-Methode ausgefuehrt.
	 *
	 */
	//
	@BeforeEach
	public void setUp() throws Exception {
		//
		//     +-----------+   +---+
		//     |         r |   | s |
		// +---+---+---+   |   |   |
		// | l |   | m |   |   |   |
		// |   |   +---+   |   |   |
		// |   |       |   |   |   |
		// +---+-------+   |   +---+
		//     |           |
		//     +-----------+
		//
		// Annahme: 1 Einheit = 1cm
		// MyPrettyRectangle-Konstruktor: MyPrettyRectangle(x1,y1,x2,y2)
		// x1,y1: Punkt links unten
		// x2,y2: Punkt rechts oben

		left = new MyPrettyRectangle(0.0, 1.0, 3.0, 3.0); // l
		middle = new MyPrettyRectangle(2.0, 2.0, 3.0, 3.0); // m
		right = new MyPrettyRectangle(1.0, 0.0, 4.0, 4.0);  // r
		somewhere = new MyPrettyRectangle(5.0, 1.0, 6.0, 4.0); // s

	}

	/*
	 * Methode zum Testen einer Methode der Klasse MyPrettyRectangle, welche prueft, ob ein Rechteck
	 * ein anderes Rechteck vollstaendig enthaelt. Bitte geben Sie einen vollständigen Test an!
	 * (Ergebnis: boolean Wert)
	 *
	 */
	@Test
	public void testContains() {
		// Erste Tests, um die Korrektheit der Methode contains() zu ueberpruefen
        assertTrue(  right.contains(middle) );
        assertTrue(  right.contains(right) );

		// Weitere Assertions angeben, um den Test vollständig durchzuführen:

		// left enthält middle vollständig (middle liegt komplett in left, obere/rechte Kante berühren sich)
		assertTrue( left.contains(middle) );
		assertTrue( left.contains(left) );          // Identität / enthält sich selbst

		// right enthält left NICHT (left ragt links über right hinaus: x1=0 < 1)
		assertFalse( right.contains(left) );

		// left enthält right NICHT (right ist größer und ragt nach unten/oben/rechts hinaus)
		assertFalse( left.contains(right) );

		// middle ist klein: enthält weder left noch right, aber sich selbst
		assertFalse( middle.contains(left) );
		assertFalse( middle.contains(right) );
		assertTrue(  middle.contains(middle) );

		// irgendwo (somewhere) ist getrennt: enthält nichts von den anderen, aber sich selbst
		assertFalse( somewhere.contains(left) );
		assertFalse( somewhere.contains(middle) );
		assertFalse( somewhere.contains(right) );
		assertTrue(  somewhere.contains(somewhere) );

		// umgekehrt: right enthält somewhere nicht (keine Überlappung / zu weit rechts)
		assertFalse( right.contains(somewhere) );
	}

	/*
	 * Methode zum Testen einer Methode der Kasse MyPrettyRectangle, welche den Mittelpunkt eines Rechtecks berechnet
	 * (Ergebnis: ein Punkt in einem Koordinatensystem)
	 *
	 */
	@Test
	public void testGetCenter(){
		// Erster Test, um die Korrektheit der Methode getCenter() zu ueberpruefen
		assertEquals( new MyPoint(1.5, 2.0), left.getCenter() );

		// Hier sollten sie die weiteren Tests einfuegen, welche die errechneten Mittelpunkte der Rechtecke
		// right, middle und somewhere mit den tatsaechlichen Mittelpunkten vergleicht.
		// Die dazugehoerige Methode der Klasse MyPrettyRectangle sollten sie selbst implementieren.
		// Fuer einen korrekten Vergleich der MyPoint-Objekte sollten sie die Methode equals entsprechend ueberrschreiben
		// (siehe dazu auch Hinweise in Kapitel 7).

		assertEquals(new MyPoint(2.5, 2.5), middle.getCenter());
		assertEquals(new MyPoint(2.5, 2.0), right.getCenter());
		assertEquals(new MyPoint(5.5, 2.5), somewhere.getCenter());

    }

	/*
	 * Methode zum Testen einer Methode der Klasse MyPrettyRectangle, welche die Flaeche eines Rechtecks berechnet
	 * (Ergebnis: Wert in Quadratzentimeter, cm2)
	 *
	 */

	@Test
	public void testGetArea(){
		assertEquals( 6.0, left.getArea() , 0.0001);

		// Hier sollten sie weitere Tests einfuegen, welche die errechneten Flaechen der Rechtecke
		// mit den tatsaechlichen Werten vergleicht.
		// Die Methode zur Berechnung der Flaeche sollten sie selbst definieren und implementieren.
		// Bitte beruecksichtigen sie auch das erlaubte Delta zwischen expected und actual values.
		// Weitere Infos: http://stackoverflow.com/questions/7554281/junit-assertions-make-the-assertion-between-floats

		assertEquals(1.0, middle.getArea(), 0.0001);
		assertEquals(12.0, right.getArea(), 0.0001);
		assertEquals(3.0, somewhere.getArea(), 0.0001);

	}



	/*
	 * Methode zum Testen einer Methode der Klasse MyPrettyRectangle, welche den Umfang eines Rechtecks berechnet
	 * (Ergebnis: Wert in Zentimeter, cm)
	 *
	 */
	@Test
	public void testGetPerimeter(){
		assertEquals( 10.0, left.getPerimeter() , 0.0001 );

		// Hier sollten sie weitere Tests einfuegen, welche die errechneten Umfaenge der beiden Rechtecke
		// mit den tatsaechlichen Werten vergleicht.
		// Die Methode sollten sie zudem selbst definieren und implementieren.
		// Bitte beruecksichtigen sie auch das erlaubte Delta zwischen expected und actual values.
		// Weitere Infos: http://stackoverflow.com/questions/7554281/junit-assertions-make-the-assertion-between-floats

		assertEquals(4.0, middle.getPerimeter(), 0.0001);
		assertEquals(14.0, right.getPerimeter(), 0.0001);
		assertEquals(8.0, somewhere.getPerimeter(), 0.0001);

	}

	/*
	 * Methode zum Testen der Objekt-Identitaet zwischen den MyPrettyRectangle-Objekten
	 *
	 */
	@Test
	public void testSameIdentity() {
		MyPrettyRectangle other = left;

		// Hier sollten sie fuenf Tests einfuegen, welche die Objekt-Identitaet des linken Rechtecks ('left')
		// mit den anderen Rechtecken (inklusive dem neuen Rechteck 'other') ueberprueft. Bitte nur assertSame oder assertNotSame
		// verwenden!

		// Gleiches Objekt (gleiche Referenz)
		assertSame(left, other);

		// Unterschiedliche Objekte
		assertNotSame(left, middle);
		assertNotSame(left, right);
		assertNotSame(left, somewhere);

		// left ist auch nicht identisch mit einem neu erzeugten, inhaltsgleichen Objekt
		assertNotSame(left, new MyPrettyRectangle(0.0, 1.0, 3.0, 3.0));


		// Bitte drei Assertions hinzufuegen, um die Gleichheit von Rechteck-Objekten
		// zu ueberpruefen.
        // Bitte nur die Assertion assertTrue verwenden:

		// Gleiches Objekt → equals muss true liefern
		assertTrue(left.equals(left));

		// Gleiches Objekt über andere Referenz
		MyPrettyRectangle other2 = left;
		assertTrue(left.equals(other2));

		// Unterschiedliche Objekte mit gleichen Koordinaten
		MyPrettyRectangle sameAsLeft =
				new MyPrettyRectangle(0.0, 1.0, 3.0, 3.0);
		assertTrue(left.equals(sameAsLeft));


		// Bitte drei weitere Assertions hinzufuegen, welche die Objekt-Identitaet des Rechtecks 'left' mit allen anderen
		// Rechtecken ueberprueft (inklusive other). Bitte hier nur die Assertions assertTrue und assertFalse verwenden.

		// Identisch: gleiche Referenz
		assertTrue(left == other);

		// Nicht identisch: unterschiedliche Objekte
		assertFalse(left == middle);
		assertFalse(left == right);


	}

	/*
	 * Methode zum Testen einer statischen Methode einer weiteren Klasse BoundingBoxFactory, die auf Basis eines Arrays von
	 * Rechtecken eine Bounding Box berechnet und zurueckliefert.
	 *
	 * Definition Bounding Box: Eine Bounding Box (deutsch: minimal umgebendes Rechteck, MUR) bezeichnet das
	 * kleinstmoegliche achsenparallele Rechteck, das eine vorgegebene Menge von Rechtecken umschliesst.
	 *
	 */
	@Test
	public void testGetBoundingBox( ) {
		MyPrettyRectangle[] rect = { middle, right, somewhere }; // hmm, vielleicht doch in die SetUp-Methode auslagern?

		// Hier sollten sie einen Test einfuegen, der zunaechst mit der Klasse BoundingBoxFactory auf
		// Basis des o.g. Array die Bounding Box berechnet.
		// Testen sie die so erhaltene Bounding Box anhand eines SOLL / IST Vergleichs.
		// Die Methode der Klasse BoundingBoxFactory sollten sie selbst definieren und implementieren.

		MyPrettyRectangle ziel = new MyPrettyRectangle(1.0, 0.0, 6.0, 4.0);
        MyPrettyRectangle box = BoundingBoxFactory.createBoundingBox(rect);

		assertEquals(ziel, box);

		// Testen sie zudem, ob ueberhaupt ein Objekt zurueckgegeben wird,
        // d.h. der Rueckgabe-Wert ungleich NULL ist
		//
		// [ihr Code in einer separaten Test-Methode]


		// Test, ob ein leeres Array ein "Null-Rectangle" (vier mal die Koordinaten 0) zurueckliefert:
		//
		// [ihr Code in einer separaten Test-Methode]


		// Test, ob die Übergabe eines NULL-Werts erfolgreich abgefangen wurde (Rueckgabe == NULL!)
		//
		// [ihr Code in einer separaten Test-Methode]

	}

	@Test
	public void testGetBoundingBoxNotNull() {
		MyPrettyRectangle[] rect = { middle, right, somewhere };

		MyPrettyRectangle box = BoundingBoxFactory.createBoundingBox(rect);

		assertNotNull(box);
	}

	@Test
	public void testGetBoundingBoxEmptyArrayReturnsNullRectangle() {
		MyPrettyRectangle[] rect = { };

		MyPrettyRectangle box = BoundingBoxFactory.createBoundingBox(rect);

		assertEquals(new MyPrettyRectangle(0.0, 0.0, 0.0, 0.0), box);
	}

	@Test
	public void testGetBoundingBoxNullInputReturnsNull() {
		assertNull(BoundingBoxFactory.createBoundingBox(null));
	}

	@Test
	public void testBoundingBoxWithTenNonOverlappingRectangles() {
		// Testen Sie die Erzeugung einer Bounding Box mit 10 nicht-überlappenden (non overlapping) Rechtecken
		// Generieren Sie die Tests mit einem CoPilot-Tool in Ihrer IDE.
		// Notieren Sie den Prompt und das Setup (Tool-Name, LLM-Name und -Version)

		// Prompt: Generiere einen Test, der die Erzeugung einer Bounding Box mit 10 nicht-überlappenden Rechtecken testet
		// Setup: IDE: IntelliJ IDEA, Tool: GitHub Copilot, LLM: GPT-5 mini

		MyPrettyRectangle[] rects = new MyPrettyRectangle[] {
			new MyPrettyRectangle(0.0, 0.0, 1.0, 1.0),
			new MyPrettyRectangle(2.0, 1.0, 3.0, 2.0),
			new MyPrettyRectangle(4.0, 2.0, 5.0, 3.0),
			new MyPrettyRectangle(6.0, 3.0, 7.0, 4.0),
			new MyPrettyRectangle(8.0, 0.0, 9.0, 1.0),
			new MyPrettyRectangle(10.0, 1.0, 11.0, 2.0),
			new MyPrettyRectangle(12.0, 2.0, 13.0, 3.0),
			new MyPrettyRectangle(14.0, 3.0, 15.0, 4.0),
			new MyPrettyRectangle(16.0, 0.0, 17.0, 1.0),
			new MyPrettyRectangle(18.0, 1.0, 19.0, 2.0)
		};

		MyPrettyRectangle box = BoundingBoxFactory.createBoundingBox(rects);

		assertNotNull(box);

		MyPrettyRectangle expected = new MyPrettyRectangle(0.0, 0.0, 19.0, 4.0);
		assertEquals(expected, box);

		for (MyPrettyRectangle r : rects) {
			assertTrue(box.contains(r));
		}
	}

}
