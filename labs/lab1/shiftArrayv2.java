public class shiftArrayv2 {

	public static void main( String[] args ) {
		int[] a = { 2, 5, 3, 7, 8, 9 };

		shiftArray( a, 9 );		
		shiftArray( a, 10 );
	}

	static int[] shiftArray(int[] a, int n) {
		// Remove any excess loops where we would essentially loop all
		// elements to same place.
		n = n % a.length;

		
		for ( int i = 0; i < n; i++ ) {

			// Did this in reverse because it was easier than going forwards
			// Create a temp int to hold the last value then start at the second
			// to last position going leftwards and shift everything to the right
			// one and then swap the first value with the last stored in temp int.
			int tempInt = a[ a.length - 1 ];
			for ( int j = a.length - 2; j >= 0; j-- ) {
				a[ j + 1 ] = a[ j ];
			}
			a[ 0 ] = tempInt;
		}

		return a;
	}	
}
