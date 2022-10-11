package DataHomework2;

public class LinkedList<E> implements ListInterface<E> {
	private Node<E> head;
	private int numItems;
	
	public LinkedList() {
		numItems=0;
		head = new Node<>(null, null);
	}
	
	@Override
	public void add(int index, E item) {
		if (index >= 0 && index <= numItems) {
			Node<E> prevNode = getNode(index - 1);
			Node<E> newNode = new Node<>(item, prevNode.next);
			prevNode.next = newNode;
			numItems++;
		}
	}

	@Override
	public void append(E item) {
		Node<E> prevNode = head;
		while (prevNode.next != null) {
			prevNode = prevNode.next;
		}
		Node<E> newNode = new Node<>(item, null);
		prevNode.next = newNode;
		numItems++;
	}

	@Override
	public E remove(int index) {
		if (index >= 0 && index < numItems) {
			Node<E> prevNode = getNode(index - 1);
			Node<E> currNode = prevNode.next;
			prevNode.next = currNode.next;
			numItems--;
			return currNode.item;
		} else
			return null;
	}

	@Override
	public boolean removeItem(E x) {
		Node<E> currNode = head;
		Node<E> prevNode;
		for (int i = 0; i < numItems; i++) {
			prevNode = currNode;
			currNode = currNode.next;
			if (((Comparable)(currNode.item)).compareTo(x) == 0) {
				prevNode.next = currNode.next;
				numItems--;
				return true;
			}
		}
		return false; 	
	}

	@Override
	public E get(int index) {
		if (index >= 0 && index <= numItems - 1) {
			return getNode(index).item;
		} 
		else
			return null; 
	}

	@Override
	public void set(int index, E x) {
		if (index >= 0 && index <= numItems - 1) {
			getNode(index).item = x;
		} else { 
			System.out.println("범위안에 존재하지 않는다");
		}
	}

	public final int NOT_FOUND = -12345;
	
	@Override
	public int indexOf(E x) {
		Node<E> currNode = head;
		int i;
		for (i = 0; i < numItems; i++) {
			currNode = currNode.next;
			if (((Comparable)(currNode.item)).compareTo(x) == 0)
				return i;
		}
		return NOT_FOUND;
	}

	@Override
	public int len() {
		return numItems;
	}

	@Override
	public boolean isEmpty() {
		return numItems == 0;
	}

	@Override
	public void clear() {
		numItems = 0;
		head = new Node<>(null, null);
	}

	public void printAll() {
		Node<E> t;
		System.out.print("Print list (#items=" + numItems + ") ");
		for(t=head.next; t != null; t = t.next) {
			System.out.print(t.item + " ");
		}
		System.out.println();
	}
	
	public Node<E> getNode(int k) {
		Node<E> cNode;
		if(k>=-1 && k <= numItems-1) {
			cNode = head;
			for(int i=0; i<=k; i++)
				cNode = cNode.next;
			return cNode;
		}
		else
			return null;
	}
	
	public int total() {
		
		return NOT_FOUND;
		
	}
	
	
}
