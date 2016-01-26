package com.artbeatte.exercises.meetingscheduler;

import java.util.Date;

/**
 * @author art.beatte
 * @version 1/25/16
 */
public class Meeting implements Comparable<Meeting> {

    private static final int MIN_TO_MILLI = 60000;

    private Date mStartDate;
    private long mDuration;
    private String mTitle;

    public Meeting(String title, Date start, long duration) {
        this.mStartDate = start;
        this.mDuration = duration;
        this.mTitle = title;
    }

    // region boilerplate
    public Date getStartDate() {
        return mStartDate;
    }

    public Date getEndDate() {
        return new Date(mStartDate.getTime() + (mDuration * MIN_TO_MILLI));
    }

    public void setStartDate(Date startDate) {
        this.mStartDate = startDate;
    }

    public long getDuration() {
        return mDuration;
    }

    public void setDuration(long duration) {
        this.mDuration = duration;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }
    // endregion

    @Override
    // overlapping meetings are seen as equal
    public int compareTo(Meeting o) {
        if (getEndDate().before(o.getStartDate())) {
            return -1;
        } else if (mStartDate.after(o.getEndDate())) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{meeting=")
                .append(mTitle)
                .append(": ")
                .append(mStartDate)
                .append("(start), duration=")
                .append(mDuration)
                .append("(minutes)}");
        return sb.toString();
    }

}
