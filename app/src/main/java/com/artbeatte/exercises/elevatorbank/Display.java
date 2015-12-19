package com.artbeatte.exercises.elevatorbank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author art.beatte
 * @version 8/28/15
 */
class Display {

    Display() { /* all of your instance belongs to us! */ }

    private static void println() {
        System.out.println();
    }

    private static void println(String msg) {
        System.out.println(msg);
    }

    private static void print(String msg) {
        System.out.print(msg);
    }

    static void printStatus(List<Elevator> elevators, int numFloors, List<Passenger> patrons) {
        String lid = "";
        for (Elevator ignored : elevators) {
            lid += "____";
        }
        String billboard = "| Art Plaza |";

        println(lid);
        println(billboard);
        println(lid);
        for (int floor = numFloors; floor > 0; floor--) {
            print("|");
            // draw elevators
            for (Elevator e : elevators) {
                if (e.getFloor() == floor) {
                    String status;
                    if (e.isIdle()) {
                        status = "I";
                    } else if (e.isEmpty()) {
                        status = "E";
                    } else {
                        status = "" + e.getDestination();
                        for (Passenger p : e.getPassengers()) {
                            if (p.getDestination() == floor) {
                                status = "D";
                            }
                        }
                    }

                    print(status + " |");
                } else {
                    print("  |");
                }
            }
            // draw requests
            Map<Integer, Integer> numPeople = new HashMap<>();
            for (Passenger p : patrons) {
                if (p.getFloor() == floor && !p.isInElevator()) {
                    Integer n = numPeople.get(p.getDistanceFromBank());
                    n = n == null ? 1 : n + 1;
                    numPeople.put(p.getDistanceFromBank(), n);
                }
            }
            if (!numPeople.isEmpty()) {
                print(" <-- ");
                print(getLayOfLand(numPeople));
            }
            println();
        }
        println(lid);
    }

    private static String getLayOfLand(Map<Integer, Integer> people) {
        String ret = "";
        int maxDistance = 0;
        for (int dist : people.keySet()) {
            if (dist > maxDistance) maxDistance = dist;
        }
        for (int i = 0; i <= maxDistance; i ++) {
            ret += people.get(i) == null ? " " : people.get(i);
        }
        return ret;
    }

    static void clearScreen() {
        // TODO: below solution does not work. Process returns with code 1.
//        try {
//            Runtime.getRuntime().exec(System
//                    .getProperty("os.name")
//                    .toLowerCase()
//                    .contains("windows") ? "clr" : "clear").waitFor();
//        } catch (IOException | InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    static void printClosing() {
        println();
        println("Thank you for riding the Art Plaza Elevator System.");
        println("Have a great day!");
    }
}
