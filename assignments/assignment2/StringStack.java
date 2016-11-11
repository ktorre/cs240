public class StringStack {

	private Node head;
	private int size;

	public StringStack() {
		head = null;
		size = 0;
	}

	// Return the top item of the stack without removing the item
	public String peek() {
		if ( head != null ) {
			return head.getEntry();
		} else {
			throw new RuntimeException("Can't peek from empty stack");
		}
	}

	// Return the top item of the stack and then remove the item
	public String pop() {
		if ( head != null ) {
			String tempEntry = head.getEntry();
			head = head.getNext();
			size--;
			return tempEntry;
		} else {
			throw new RuntimeException("Can't peek from an empty stack");
		}
	}

	// Add a given string to the top of the stack, can be a null reference.
	public void push( String entry ) {
		Node newNode = new Node( entry, head );
		head = newNode;
		size++;
	}

	// Determine whetehr this stack is empty
	public boolean isEmpty() {
		return size == 0;
	}

	// Return the size of elements in this stack
	public int size() {
		return size;
	}

	public void clear() {
		head = null;
		size = 0;
	}

	// Return the stack as a string;
	public String toString() {
		String result = "[ ";
		Node cursor = head;
		while ( cursor != null ) {
			result += cursor.getEntry();
			if ( cursor.getNext() != null ) {
				result += ", ";
			}

			cursor = cursor.getNext();
		}
		result += " ]";
		return result;
	}

}
