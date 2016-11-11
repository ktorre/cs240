public class Node {

	private String entry;
	private Node next;

	public Node( String entry ) {
		this.entry = entry;
	}

	public Node( String entry, Node next ) {
		this.entry = entry;
		this.next = next;
	}

	public String getEntry() {
		return entry;
	}

	public void setEntry( String entry ) {
		this.entry = entry;
	}

	public Node getNext() {
		return next;
	}

	public void setNext( Node next ) {
		this.next = next;
	}

}
