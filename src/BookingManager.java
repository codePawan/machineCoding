import java.security.KeyPair;
import java.util.Calendar;
import java.util.Map;

public class BookingManager {
    public void  bookSession(int sessionId, int  userId ,
                          Map<SessionUserPair,BookingDetails>bookingDetailsMap,
                          Map<Integer,Session> sessionDetailsMap, SessionType sessionType,
                             BookingQueue bookingQueue){
        synchronized (BookingManager.class){
            if(!sessionDetailsMap.containsKey(sessionId)){
                throw new RuntimeException("There doesnt exist any session with the sessionId ");
            }
            Calendar calendar = Calendar. getInstance(); // Get the current time in milliseconds.
            long currentTime = calendar. getTimeInMillis();
            Session session = sessionDetailsMap.get(sessionId);

            // valid booking
            if(bookingDetailsMap.containsKey(new SessionUserPair(sessionId,userId))){
                throw new RuntimeException("You have alreadybooked a session");

            }
            BookingDetails bookingDetails=new  BookingDetails(userId,
                    1,sessionId,currentTime,BookingStatus.ACTIVE,SessionType.GYM);
            if(session.getCount()>5){
                if(session.getSessionType()==SessionType.GYM){
                    bookingQueue.gymQueue.add(bookingDetails);
                }
            }else{
                session.setCount( session.getCount()+1);
                bookingDetailsMap.put(new SessionUserPair(sessionId,userId),bookingDetails);
            }



        }

    }

    public void cancelBooking(int userId, int sessionId,
                              Map<SessionUserPair,BookingDetails> bookingDetailsMap,
                              Map<Integer,Session> sessionMap,BookingQueue bookingQueue,SessionType sessionType ){
        if(!sessionMap.containsKey(sessionId)){
            throw new RuntimeException("There doesnt exist any session with the sessionId ");
        }
        SessionUserPair key = new SessionUserPair(sessionId,userId);
        // validitycheck
        if(bookingDetailsMap.containsKey(key)){
            BookingDetails bookingDetails=  bookingDetailsMap.get(key);
           Session session= sessionMap.get(sessionId);
            Calendar calendar = Calendar. getInstance(); // Get the current time in milliseconds.
            long currentTime = calendar. getTimeInMillis();
           if(session.getStartTime() - 30*60*1000< currentTime){
               throw new RuntimeException("User can cancel session  prior to 30 mins of starting ");
           }
           //  can cancel
           session.setCount( session.getCount() - 1);
           bookingDetails.setStatus(BookingStatus.CANCELLED);
           //  check if any queue peoplepresent
            if(sessionType== SessionType.GYM){
                if(bookingQueue.gymQueue.size()>=0){
                    session.setCount(session.getCount()+1);
                   BookingDetails bookingQueueDetails = bookingQueue.gymQueue.removeFirst();
                   bookingQueueDetails.setStatus(BookingStatus.ACTIVE);
                   bookingDetailsMap.put(new SessionUserPair(bookingQueueDetails.getSessionId(),bookingQueueDetails.getBookingId()),bookingQueueDetails);
                }
            }

        }


    }



}
