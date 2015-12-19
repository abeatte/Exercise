package com.artbeatte.exercises.linkedlist;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;


/**
 * @author sarbs
 * @version 11/17/15
 */
public class LinkedListNode {
    private static int traversals;
    private static void incTraversals() {
        if (++traversals > (2 << 24))
            throw new RuntimeException("fail");
    }

    private LinkedListNode next;

    public LinkedListNode getNext() {
        incTraversals();
        return next;
    }

    public void setNext(LinkedListNode next) {
        this.next = next;
    }

    /**
     * Detects if there are any node in a linked list points back to a node in the same list, thus creating a loop.
     *
     * @param start The start of the list
     * @return True if the list contains a loop, false if the list terminates normally
     */
    public static boolean detectLoop(LinkedListNode start) {
        throw new NotImplementedException();
    }
}
