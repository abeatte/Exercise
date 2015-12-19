package com.artbeatte.exercises.testrunner.tests;

import com.artbeatte.exercises.linkedlist.LinkedListNode;
import com.artbeatte.exercises.testrunner.ExternalTestCase;
import com.artbeatte.exercises.testrunner.SystemTestRunner;
import com.artbeatte.exercises.testrunner.TestRunner;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @author art.beatte
 * @version 11/17/15
 */
public class LinkedListNodeTest {

    public static void main(String args[]) {
        TestRunner tr = new SystemTestRunner();
        tr.addTestCase(new ExternalTestCase("shortStraight", new ExternalTestCase.ExternalTest() {
            @Override
            public boolean execute(OutputStream outputStream) throws IOException {
                LinkedListNode root = new LinkedListNode();
                LinkedListNode node = root;
                for (int i = 0; i < 50; i++) {
                    LinkedListNode newNode = new LinkedListNode();
                    node.setNext(newNode);
                    node = newNode;
                }

                return !LinkedListNode.detectLoop(root);
            }
        }));

        tr.addTestCase(new ExternalTestCase("longStraight", new ExternalTestCase.ExternalTest() {
            @Override
            public boolean execute(OutputStream outputStream) throws IOException {
                LinkedListNode root = new LinkedListNode();
                LinkedListNode node = root;
                for (int i = 0; i < 500000; i++) {
                    LinkedListNode newNode = new LinkedListNode();
                    node.setNext(newNode);
                    node = newNode;
                }

                return !LinkedListNode.detectLoop(root);
            }
        }));

        tr.addTestCase(new ExternalTestCase("smallLoop", new ExternalTestCase.ExternalTest() {
            @Override
            public boolean execute(OutputStream outputStream) throws IOException {
                LinkedListNode root = new LinkedListNode();
                LinkedListNode node = root;
                LinkedListNode reentry = null;
                for (int i = 0; i < 50; i++) {
                    LinkedListNode newNode = new LinkedListNode();
                    node.setNext(newNode);
                    node = newNode;
                    if (i == 45)
                        reentry = node;
                }
                node.setNext(reentry);

                return LinkedListNode.detectLoop(root);
            }
        }));

        tr.addTestCase(new ExternalTestCase("smallLoop2", new ExternalTestCase.ExternalTest() {
            @Override
            public boolean execute(OutputStream outputStream) throws IOException {
                LinkedListNode root = new LinkedListNode();
                LinkedListNode node = root;
                LinkedListNode reentry = null;
                for (int i = 0; i < 50; i++) {
                    LinkedListNode newNode = new LinkedListNode();
                    node.setNext(newNode);
                    node = newNode;
                    if (i == 44)
                        reentry = node;
                }
                node.setNext(reentry);

                return LinkedListNode.detectLoop(root);
            }
        }));

        tr.addTestCase(new ExternalTestCase("smallLoopFar", new ExternalTestCase.ExternalTest() {
            @Override
            public boolean execute(OutputStream outputStream) throws IOException {
                LinkedListNode root = new LinkedListNode();
                LinkedListNode node = root;
                LinkedListNode reentry = null;
                for (int i = 0; i < 50000; i++) {
                    LinkedListNode newNode = new LinkedListNode();
                    node.setNext(newNode);
                    node = newNode;
                    if (i == 49995)
                        reentry = node;
                }
                node.setNext(reentry);

                return LinkedListNode.detectLoop(root);
            }
        }));

        tr.addTestCase(new ExternalTestCase("bigLoop", new ExternalTestCase.ExternalTest() {
            @Override
            public boolean execute(OutputStream outputStream) throws IOException {
                LinkedListNode root = new LinkedListNode();
                LinkedListNode node = root;
                LinkedListNode reentry = null;
                for (int i = 0; i < 500000; i++) {
                    LinkedListNode newNode = new LinkedListNode();
                    node.setNext(newNode);
                    node = newNode;
                    if (i == 45)
                        reentry = node;
                }
                node.setNext(reentry);

                return LinkedListNode.detectLoop(root);
            }
        }));

        tr.runTests();
    }
}
