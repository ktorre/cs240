public class shiftArray {

	public static void main( String[] args ) {
		int[] a = { 2, 5, 3, 7, 8, 9 };

		shiftArray( a, 9 );		
		shiftArray( a, 10 );
	}

	static int[] shiftArray(int[] a, int n) {
		n = n % a.length;
		System.out.println(n);
		for ( int i = 0; i < a.length/2; i++  ) {
			int tempInt = a[ i  ];
			a[ i ] = a[ ( i + n ) % a.length ];
			a[ ( i + n ) % a.length ] = tempInt;
		}

		for ( int i : a ) {
			System.out.print( i + " " );
		}
		System.out.println();
	
		return a;
	}	
}
