public class Session {
    private int sessionId;
    private SessionType sessionType;
    private long startTime;
    private long endTime;
    private int count;

    public Session(int sessionId, SessionType sessionType, long startTime, long endTime,int count) {
        this.sessionId = sessionId;
        this.sessionType = sessionType;
        this.startTime = startTime;
        this.endTime = endTime;
        this.count=count;
    }

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public SessionType getSessionType() {
        return sessionType;
    }

    public void setSessionType(SessionType sessionType) {
        this.sessionType = sessionType;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
