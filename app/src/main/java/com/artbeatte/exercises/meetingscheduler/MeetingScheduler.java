package com.artbeatte.exercises.meetingscheduler;

import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @author art.beatte
 * @version 10/21/15
 */
public class MeetingScheduler {

    private static final int MIN_TO_MILLI = 60000;

    private static class Meeting implements Comparable<Meeting> {
        Date startTime;
        Date endTime;
        int duration;

        public Meeting(Date start, int duration) {
            this.startTime = start;
            this.duration = duration;
            this.endTime = new Date(startTime.getTime() + (duration * MIN_TO_MILLI));
        }

        @Override
        public int compareTo(@NotNull Meeting other) {
            if (this.startTime.compareTo(other.endTime) > 0) {
                return 1;
            } else if (this.endTime.compareTo(other.startTime) < 0) {
                return -1;
            } else {
                return 0;
            }
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("{meeting=")
                    .append(startTime)
                    .append("(start), duration=")
                    .append(duration)
                    .append("(minutes)}");
            return sb.toString();
        }
    }

    private List<Meeting> mMeetings = new ArrayList<>();

    public Meeting bookRoom(Meeting meeting) {

        if (mMeetings.isEmpty()) {
            mMeetings.add(meeting);
            return null;
        } else {
            int pos = -Collections.binarySearch(mMeetings, meeting);
            if (pos > 0) {
                mMeetings.add(pos-1, meeting);
                return null;
            } else {
                return mMeetings.get(-pos);
            }
        }
    }

    public List<Meeting> getMeetings() {
        return Collections.unmodifiableList(mMeetings);
    }

    public static void main(String[] args) {
        MeetingScheduler meetingScheduler = new MeetingScheduler();

        Meeting[] meetingsToBook = new Meeting[]{
                //October 3rd 2014
                new Meeting(new Date(2014 - 1900, 10 - 1, 3, 15, 0), 15),
                new Meeting(new Date(2014 - 1900, 10 - 1, 3, 16, 0), 15),
                new Meeting(new Date(2014 - 1900, 10 - 1, 3, 17, 0), 60),
                new Meeting(new Date(2014 - 1900, 10 - 1, 3, 18, 0), 15),
                new Meeting(new Date(2014 - 1900, 10 - 1, 3, 14, 50), 10),
                new Meeting(new Date(2014 - 1900, 10 - 1, 3, 14, 55), 10)
        };

        for (Meeting m : meetingsToBook) {
            Meeting oldMeeting = meetingScheduler.bookRoom(m);
            if (oldMeeting != null) {
                System.out.println("Can't book room for " + m + ". It collides with " + oldMeeting);
            }
        }

        System.out.println("meetings booked: " + meetingScheduler.getMeetings().size());

        for (Meeting m : meetingScheduler.getMeetings()) {
            System.out.println(m.startTime + " -> " + m.duration + " mins");
        }

    }
}
