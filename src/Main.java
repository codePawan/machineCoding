import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        SessionDetails sessionDetails = new SessionDetails();
        Map<SessionUserPair,BookingDetails> bookingDetailsMap =  new HashMap<>();
        BookingQueue bookingQueue  =  new BookingQueue();


        BookingManager bookingManager = new BookingManager();
        // session  creation
        for(int i=0; i<2;i++){
            Calendar calendar = Calendar. getInstance(); // Get the current time in milliseconds.
            long currentTime = calendar. getTimeInMillis();
            Session session = new Session(i+1,SessionType.GYM,
                    currentTime+i*1000,currentTime+i*15000+2,0);
            sessionDetails.sessionMap.put(session.getSessionId(),session);
        }
        for(int i=0;i<5;i++){
            UserDetails userDetails =  new UserDetails(i+1,"pawan"+i);
            bookingManager.bookSession(1,userDetails.getUserId(),bookingDetailsMap,
                    sessionDetails.sessionMap,SessionType.GYM,bookingQueue);
            bookingManager.cancelBooking(userDetails.getUserId(),1,
                    bookingDetailsMap,sessionDetails.sessionMap,bookingQueue,SessionType.GYM);
        }


    }


}

// classes
//  session enum->yoga, gym, dance (session time (time stamp  start  to end))
// session class
//user details (id,name)
// bookingDetails (userId, sessionId, sessionType,)