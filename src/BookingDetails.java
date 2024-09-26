public class BookingDetails {

    private int userId;
    private int bookingId;
    private int sessionId;
    private long timeStamp;
    private BookingStatus status;
    private SessionType sessionType;

    public BookingDetails(int userId, int bookingId, int sessionId, long timeStamp, BookingStatus status, SessionType sessionType) {
        this.userId = userId;
        this.sessionId = sessionId;
        this.timeStamp = timeStamp;
        this.status = status;
        this.sessionType=sessionType;
        this.bookingId=bookingId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }

    public SessionType getSessionType() {
        return sessionType;
    }

    public void setSessionType(SessionType sessionType) {
        this.sessionType = sessionType;
    }
}
