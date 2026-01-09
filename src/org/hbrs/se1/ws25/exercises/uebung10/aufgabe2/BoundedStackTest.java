package org.hbrs.se1.ws25.exercises.uebung10.aufgabe2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

public class BoundedStackTest {
    private BoundedStack<String> stack;

    @BeforeEach
    void setUp() {
        stack = new BoundedStack<>(4); // n = 4
    }

    @Test
    void testInitialStateEmpty() {
        // Zustand: EMPTY
        assertTrue(stack.empty());
        assertEquals(0, stack.size());
        assertFalse(stack.isFull());
    }

    @Test
    void testPushTransitionsUpToFullAndPopBackToEmpty() {
        // EMPTY -> 1 -> 2 -> 3 -> FULL (4)

        stack.push("A");
        assertEquals(1, stack.size());
        assertFalse(stack.empty());
        assertFalse(stack.isFull());

        stack.push("B");
        assertEquals(2, stack.size());
        assertFalse(stack.isFull());

        stack.push("C");
        assertEquals(3, stack.size());
        assertFalse(stack.isFull());

        stack.push("D");
        assertEquals(4, stack.size());
        assertTrue(stack.isFull());
        assertFalse(stack.empty());

        // FULL -> 3 -> 2 -> 1 -> EMPTY (per pop, LIFO prüfen)
        assertEquals("D", stack.pop());
        assertEquals(3, stack.size());
        assertFalse(stack.isFull());

        assertEquals("C", stack.pop());
        assertEquals(2, stack.size());

        assertEquals("B", stack.pop());
        assertEquals(1, stack.size());

        assertEquals("A", stack.pop());
        assertEquals(0, stack.size());
        assertTrue(stack.empty());
    }

    @Test
    void testOverflowWhenPushingIntoFullStack() {
        // Zustand: FULL + Transition: push -> OVERFLOW (nicht erlaubt)

        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");
        assertTrue(stack.isFull());

        assertThrows(IllegalStateException.class, () -> stack.push("E"));
        // Zustand bleibt FULL
        assertEquals(4, stack.size());
        assertTrue(stack.isFull());
        assertEquals("D", stack.peek()); // Top unverändert
    }

    @Test
    void testUnderflowWhenPoppingEmptyStack() {
        // Zustand: EMPTY + Transition: pop -> UNDERFLOW
        assertTrue(stack.empty());
        assertThrows(EmptyStackException.class, () -> stack.pop());
        // Zustand bleibt EMPTY
        assertEquals(0, stack.size());
        assertTrue(stack.empty());
    }

    @Test
    void testPeekDoesNotChangeState() {
        // Transition: peek verändert Zustand nicht (bei nicht-leer)
        stack.push("A");
        stack.push("B");

        assertEquals("B", stack.peek());
        assertEquals(2, stack.size());     // size bleibt gleich
        assertEquals("B", stack.peek());   // wiederholbar
    }
}
