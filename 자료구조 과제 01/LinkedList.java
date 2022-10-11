package linkedList;

public class LinkedList<E> implements ListInterface<E> {
	private Node<E> head;
	private int numItems;
	
	public LinkedList() {
		numItems=0;
		head = new Node<>(null, null);
	}
	
	@Override
	public void add(int index, E item) {
		// TODO Auto-generated method stub
		if (index >= 0 && index <= numItems) {
			Node<E> prevNode = getNode(index - 1);
			Node<E> newNode = new Node<>(item, prevNode.next);
			prevNode.next = newNode;
			numItems++;
		}
	}

	@Override
	public void append(E item) {
		// TODO Auto-generated method stub
		Node<E> prevNode = head;  		// 더미 노드
		while (prevNode.next != null) {
			prevNode = prevNode.next;
		}
		Node<E> newNode = new Node<>(item, null);
		prevNode.next = newNode;
		numItems++;
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		Node<E> currNode = head;  	// 더미 헤드
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
		// TODO Auto-generated method stub
		if (index >= 0 && index <= numItems - 1) {
			return getNode(index).item;
		} 
		else
			return null; 
	}

	@Override
	public void set(int index, E x) {
		// TODO Auto-generated method stub
		if (index >= 0 && index <= numItems - 1) {
			getNode(index).item = x;
		} else { 
			System.out.println("범위안에 존재하지 않는다!");
		}
	}

	public final int NOT_FOUND = -12345;
	
	@Override
	public int indexOf(E x) {
		// TODO Auto-generated method stub
		Node<E> currNode = head;   // 더미 노드
		int i;
		for (i = 0; i < numItems; i++) {
			currNode = currNode.next;
			if (((Comparable)(currNode.item)).compareTo(x) == 0)
				return i;
		}
		return NOT_FOUND; 	// not found
	}

	@Override
	public int len() {
		// TODO Auto-generated method stub
		return numItems;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return numItems == 0;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
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
	
	
}
