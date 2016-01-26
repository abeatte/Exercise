package com.artbeatte.exercises.meetingscheduler;

import java.util.*;

/**
 * @author art.beatte
 * @version 10/21/15
 */
public class MeetingScheduler {

    List<Meeting> mMeetings;

    public MeetingScheduler() {
        mMeetings = new ArrayList<>();
    }

    public List<Meeting> getMeetings() {
        return Collections.unmodifiableList(mMeetings);
    }

    public boolean addMeeting(Meeting m) {
        return guardedAdd(m) != null;
    }

    /**
     * Adds the {@link Meeting} if successful
     * @param m the {@link Meeting} to add
     * @return null if successful, otherwise the {@link Meeting} conflicting with the proposed addition
     */
    public Meeting guardedAdd(Meeting m) {
        Meeting existing = null;
        int pos = Collections.binarySearch(mMeetings, m);
        if (pos < 0) { // clear
            mMeetings.add(-pos - 1, m);
        } else { // conflict
            existing = mMeetings.get(pos);
        }
        return existing;
    }
}
