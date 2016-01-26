package com.artbeatte.exercises.tests;

import com.artbeatte.exercises.meetingscheduler.Meeting;
import com.artbeatte.exercises.meetingscheduler.MeetingScheduler;
import com.artbeatte.testrunner.ExternalTestCase;
import com.artbeatte.testrunner.SystemTestRunner;
import com.artbeatte.testrunner.TestRunner;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author art.beatte
 * @version 1/25/16
 */
public class MeetingSchedulerTest {

    public static void main(String[] args) {
        TestRunner testRunner = new SystemTestRunner();
        testRunner.addTestCase(new ExternalTestCase("Test MeetingScheduler", new ExternalTestCase.ExternalTest() {
            @Override
            public boolean execute(OutputStream outputStream) throws IOException {
                MeetingScheduler meetingScheduler = new MeetingScheduler();

                Meeting[] meetingsToBook = new Meeting[]{
                        //October 3rd 2014
                        new Meeting("a", new Date(2014 - 1900, 10 - 1, 3, 15, 0), 15),
                        new Meeting("b", new Date(2014 - 1900, 10 - 1, 3, 16, 0), 15),
                        new Meeting("c", new Date(2014 - 1900, 10 - 1, 3, 17, 0), 60),
                        new Meeting("d", new Date(2014 - 1900, 10 - 1, 3, 18, 0), 15),
                        new Meeting("e", new Date(2014 - 1900, 10 - 1, 3, 14, 50), 10),
                };

                Set<Meeting> failures = new HashSet<>();
                for (Meeting m : meetingsToBook) {
                    Meeting oldMeeting = meetingScheduler.guardedAdd(m);
                    if (oldMeeting != null) {
                        outputStream.write(("Can't book room for " + m + ". It collides with " + oldMeeting + "\n").getBytes());
                        failures.add(m);
                    }
                }

                outputStream.write(("meetings booked: " + meetingScheduler.getMeetings().size() + "\n").getBytes());

                for (Meeting m : meetingScheduler.getMeetings()) {
                    outputStream.write((m.getTitle() + ": " + m.getStartDate() + " -> " + m.getDuration() + " mins" + "\n").getBytes());
                }

                return meetingScheduler.getMeetings().size() == 3 &&
                        failures.contains(meetingsToBook[3]) &&
                        failures.contains(meetingsToBook[4]);

            }
        }));
        testRunner.runTests();
    }
}
