package android.fuzzer;
import android.util.Log;
import android.location.LocationListener;
import java.util.ArrayList;
public class fuzzer {
	private static String[] strings = { "", "aaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", null };
	private static String[] locationProviders = { "gps", "network", "passive", null };
	private static int[] ints = { Integer.MIN_VALUE, 5, 0, 5, Integer.MAX_VALUE };
	private static float[] floats = { Float.MIN_VALUE, -5.6f, 0.0f, 5.6f, Float.MAX_VALUE };
	private static long[] longs = { Long.MIN_VALUE, -5l, 0l, 5l, Long.MAX_VALUE };
	private static LocationListener[] listeners = { null };

	public static ArrayList<ArrayList<Object>> fuzz( ArrayList<Object> params ) {
		ArrayList<Object> cand = new ArrayList<Object>();
		for( Object o : params ) {
			if( o instanceof String ) {
				String str = (String)o;
				if( str.equals("gps") || str.equals("network") || str.equals("passive") ) {
				   cand.add(locationProviders);
				} else {
				   cand.add( strings );
				}
			} else if( o instanceof Integer ) {
				cand.add( ints );
			} else if( o instanceof Float ) {
				cand.add( floats );
			} else if( o instanceof Long ) {
				cand.add( longs );
			} else if( o instanceof LocationListener ) {
				cand.add( listeners );
			}
		}
		ArrayList<ArrayList<Object>> res = new ArrayList<ArrayList<Object>>();
		ArrayList<Object> tmp = new ArrayList<Object>();
		solve( tmp, 0, cand, res );
		Log.i( "Shanks","fuzz printing res size " + res.size());
		for( ArrayList<Object> option : res ) {
		   Log.i( "Robin","Fuzzing case: " + option.get(0) + ", " + option.get(1) + ", " + option.get(2) );
		}
		return res;
	}

	private static void solve( ArrayList<Object> tmp, int i, ArrayList<Object> cand,
			ArrayList<ArrayList<Object>> res) {
		if( i == cand.size() ) {
			ArrayList<Object> s = (ArrayList<Object>) tmp.clone();
			res.add( s );
		} else {
			Object obj = cand.get( i );
			if( obj instanceof int[] ) {
				int[] ob = (int[])obj;
				for( int o : ob ){
					tmp.add( o );
					solve( tmp, i+1, cand, res );
					tmp.remove( tmp.size() - 1 );
				}
			} else if( obj instanceof String[] ) {
				String[] ob = (String[])obj;
				for( String o : ob ){
					tmp.add( o );
					solve( tmp, i+1, cand, res );
					tmp.remove( tmp.size() - 1 );
				}
			} else if( obj instanceof float[] ) {
                                float[] ob = (float[])obj;
				for( float o : ob ){
					tmp.add( o );
					solve( tmp, i+1, cand, res );
					tmp.remove( tmp.size() - 1 );
				}
                        } else if( obj instanceof long[] ) {
                                long[] ob = (long[])obj;
				for( long o : ob ){
					tmp.add( o );
					solve( tmp, i+1, cand, res );
					tmp.remove( tmp.size() - 1 );
				}
                        } else if( obj instanceof LocationListener[] ) {
                                LocationListener[] ob = (LocationListener[])obj;
				for( LocationListener o : ob ){
					tmp.add( o );
					solve( tmp, i+1, cand, res );
					tmp.remove( tmp.size() - 1 );
				}
                        }
		}
	}
}

