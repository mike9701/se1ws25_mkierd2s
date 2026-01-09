package org.hbrs.se1.ws25.exercises.uebung10.aufgabe2;


import java.util.Stack;

/**
 * Stack mit fester maximaler Kapazität.
 */
public class BoundedStack<E> extends Stack<E> {

    private final int maxSize;

    public BoundedStack(int maxSize) {
        if (maxSize <= 0) throw new IllegalArgumentException("maxSize must be > 0");
        this.maxSize = maxSize;
    }

    @Override
    public E push(E item) {
        if (size() >= maxSize) {
            throw new IllegalStateException("Stack overflow: maxSize=" + maxSize);
        }
        return super.push(item);
    }

    public int getMaxSize() {
        return maxSize;
    }

    public boolean isFull() {
        return size() == maxSize;
    }
}
