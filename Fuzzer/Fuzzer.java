package android.fuzzer;
import android.util.Log;
import android.app.Notification;

public class Fuzzer {
    public static void printLog(String tag, int id, Notification notification)
      {
        Log.i("FUZZMOD", "printing log: tag " + tag + " id: " + id + " notification: " + notification);
      }
}
