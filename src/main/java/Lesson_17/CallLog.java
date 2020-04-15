package Lesson_17;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class CallLog implements Comparable, Serializable{

    private Date timeStart;
    private CallType callType;

    public CallLog(Date timeStart, CallType callType) {
        this.timeStart = timeStart;
        this.callType = callType;
    }

    public Date getTimeStart() {
        return timeStart;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CallLog callLog = (CallLog) o;
        return  Objects.equals(callType, callLog.callType)&&
                Objects.equals(timeStart, callLog.timeStart);
    }

    @Override
    public int hashCode() {
        return Objects.hash(callType, timeStart);
    }

    @Override
    public String toString() {
        return timeStart.toString()+" "+ callType.toString();
    }

    @Override
    public int compareTo(Object o) {
        CallLog other = (CallLog)o;
        return (int) (timeStart.getTime() - other.timeStart.getTime());
    }
}
