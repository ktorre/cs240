public class Lab2 {

	public static void main(String[] args) {
		int[] test = {1, 2, 3, 1, 2, 3, 4, 5, 6, 5, 7};
		int[] correct = findUniqueElements( test );

		for ( int x : correct ) {
			System.out.println(x);
		}
	}

	/*
	* Complete the function below.
	*/

	static int[] findUniqueElements(int[] a) {

	// Create a temp array the length of a because me don't know how many
	// unique numbers there are so we can trim it out later.
	int[] tempArray = new int[a.length];

	int finalCounter = 0;
	for ( int i = 0; i < a.length; i++ ) {
	    boolean dup = false;
	    for ( int j = i + 1; j < a.length; j++ ) {
		if ( a[i] == a[ j ] ) {
		    dup = true;
		    tempArray[ j ] = 102;
		}
	    }
	    if ( !dup ) {
		tempArray[ i ] = a[ i ];
		finalCounter++;
	    }

	}

	// Create and fill the final array
	int finalArrayCounter = 0;
	int[] finalArray = new int[ finalCounter ];
	for ( int i = 0; i < tempArray.length; i++ ) {
	    if ( tempArray[ i ] != 102 ) {
		finalArray[ finalArrayCounter ] = tempArray[ i ];
		finalArrayCounter++;
	    }
	}

	return finalArray;
	}
}
