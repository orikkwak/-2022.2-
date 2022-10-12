package DataHomework2;

public class LinkedList<E> implements ListInterface<E> {
	private Node<E> head;
	private int numItems;

	public LinkedList() {
		numItems = 0;
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
			if (((Comparable) (currNode.item)).compareTo(x) == 0) {
				prevNode.next = currNode.next;
				numItems--;
				return true;
			}
		}
		return false;
	}
//	public int lastIndexOf(E x) {
//		Node<E> q = head.next;
//		int a = 0;
//		for(int i = 0; q != null; q = q.next, i++) {
//			if(q.item == x) {
//				q = i;
//			}
//		}
//		return NOT_FOUND;
//		
//		
//	}
	
	@Override
	public E get(int index) {
		if (index >= 0 && index <= numItems - 1) {
			return getNode(index).item;
		} else
			return null;
	}
	
	public boolean contains(E x) {
		return indexOf(x) >= 0;
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
			if (((Comparable) (currNode.item)).compareTo(x) == 0)
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
		for (t = head.next; t != null; t = t.next) {
			System.out.print(t.item + " ");
		}
		System.out.println();
	}

	public Node<E> getNode(int k) {
		Node<E> cNode;
		if (k >= -1 && k <= numItems - 1) {
			cNode = head;
			for (int i = 0; i <= k; i++)
				cNode = cNode.next;
			return cNode;
		} else
			return null;
	}

	public int total() {

		return NOT_FOUND;

	}

	@Override
	public int hap() {
		Node<E> t;
		int sum = 0;
		for (t = head.next; t != null; t = t.next) {
			sum += (int) t.item;
		}
		System.out.print("Hap (#items=" + numItems + ") " + sum);
		System.out.println();
		return sum;
	}
	
//	public void remove(int index, int k) {
//		if(index>=0 && index< numItems) {
//			Node prevNode = getNode(index -1);
//			for(int i = 0; i<k; i++) {
//				if(prevNode.next != null) {
//					prevNode.next = prevNode.next.next;
//					numItems--;
//				}
//				else
//					break;
//				
//			}
//		}
//	}
	public void concat(LinkedList l1, LinkedList l2) {
		Node<E> t = l1.head;
		while(t.next!= null) {
			t=t.next;
		}
		t.next=l2.head.next;
		l1.numItems+=l2.numItems;
	}
	
	@Override
	public int maxList() {
		Node<E> t;
		int sum = 0;
		for (t = head.next; t != null; t = t.next) {
			if (sum <= (int) t.item)
				sum = (int) t.item;
		}
		System.out.print("Maxlist (#items=" + numItems + ") " + sum);
		System.out.println();
		return sum;
	}
//	public boolean Linkednode() {
//		ListInterface<E> list = null;
//		E node1 = null;
//		E node2 = null;
//		if (list.indexOf(node1) >= 0 && list.indexOf(node2) >= 0)
//			return true;
//		else
//			return false;
//	}
	@Override
	public int minList() {
		Node<E> t;
		int sum = 999999;
		for (t = head.next; t != null; t = t.next) {
			if (sum >= (int) t.item)
				sum = (int) t.item;
		}
		System.out.print("Minlist (#items=" + numItems + ") "+ sum);
		System.out.println();
		return sum;
	}
//	public void printInterval(int i, int j) {
//		Node<E> tNode = getNode(i);
//		for(;i<=j; i ++) {
//			System.out.println(tNode.item);
//			tNode = tNode.next;
//		}
//	}
}
