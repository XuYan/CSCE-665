package android.fuzzer;
import android.util.Log;
import android.location.LocationListener;
import java.util.ArrayList;
public class fuzzer {
   private static String[] strings = { "", "aaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", null };
   private static int[] ints = { Integer.MIN_VALUE, 5, 0, 5, Integer.MAX_VALUE };
   private static float[] floats = { Float.MIN_VALUE, -5.6f, 0.0f, 5.6f, Float.MAX_VALUE };
   private static long[] longs = { Long.MIN_VALUE, -5, 0, 5, Long.MAX_VALUE };
//   private LocationListener listeners = {};
   public static ArrayList<ArrayList<Object>> fuzz( String provider, long minTime, float minDistance, LocationListener listener ) {
        LocationListener[] listeners = { listener, null };
	Log.i( "Shanks", "fuzz begins..." );
        ArrayList<ArrayList<Object>> result = new ArrayList<ArrayList<Object>>();
	
	for( String i : strings ) {
	   ArrayList<Object> l = new ArrayList<Object>();
	   l.add( i );
	   for( long j : longs ) {
	      l.add( j );
	      for( float k : floats ) {
	         l.add( k );
                 for( LocationListener ln : listeners ) {
		    l.add( ln );
		    result.add( (ArrayList<Object>)l.clone() );
		    l.remove( l.size() - 1 );
		 }
		 l.remove( l.size() - 1 );
	      }
	      l.remove( l.size() - 1 );
	   }
	   l.remove( l.size() - 1 );
	}
	Log.i( "Luffy", "fuzz ends..." );
	return result;
   }
}

