package DataHW1;

public class AllArrayList<E> implements AllListInterface<E> {

	private E[] item;
	private int numItems;
	private static final int DEFAULT_CAPACITY=64;
	
	public AllArrayList() {
		item = (E[])new Object[DEFAULT_CAPACITY];
		numItems = 0;
	}
	public AllArrayList(int n) {
		item = (E[])new Object[n];
		numItems = 0;
	}
	
	@Override
	public void add(int index, E x) {
		// TODO Auto-generated method stub
		if (numItems >= item.length || index < 0 || index > numItems) {
			System.out.println("배열의 공간이 부족하거나, 인덱스가 올바르지 않다.");
		} else {
			for (int i = numItems - 1; i >= index; i--)
				item[i + 1] = item[i];	
			
			item[index] = x;
			numItems++;
		}
	}

	@Override
	public void append(E x) {
		// TODO Auto-generated method stub
		if (numItems >= item.length) {
			System.out.println("배열의 공간이 부족하다.");
		} else {
			item[numItems++] = x;
		}
	}

//	public Integer get(int index) {
//		if(index >= 0 && index <= numItems -1)
//			return item[index+1];
//		else
//			return null;
//	}
//	
//	public void set(int index, Integerx) {
//		if(index >= 0 && index <= numItems -1)
//			item[index + 1 ] = x;
//		else
//			System.out.println("인덱스 범위가 잘못되었다.");
//	}
	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		if (isEmpty() || index < 0 || index > numItems-1)
			return null;
		else {
			E tmp = item[index];
			for (int i = index; i <= numItems-2; i++)
				item[i] = item[i + 1];	
			
			numItems--;
			return tmp;
		}
	}

	@Override
	public boolean removeItem(E x) {
		// TODO Auto-generated method stub
		int k = 0;
		while (k < numItems && ((Comparable)item[k]).compareTo(x) != 0)
			k++;
		if (k == numItems)
			return false;
		else {
			for (int i = k; i <= numItems - 2; i++)
				item[i] = item[i + 1];
			numItems--;
			return true;
		}
	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		if (index >= 0 && index <= numItems - 1)
			return item[index];
		else
			return null;
	}

	@Override
	public void set(int index, E x) {
		// TODO Auto-generated method stub
		if (index >= 0 && index <= numItems - 1)
			item[index] = x;
		else { 
			System.out.println("인덱스 범위가 잘못되었다.");
		}
	}

	//private final int NOT_FOUND = -12345;
	@Override
	public int indexOf(E x) {
		int i = 0;
 		for (i = 0; i < numItems; i++) {
			if (((Comparable)item[i]).compareTo(x) == 0) 			
 				return i;
 		}
    	return -1;
	}

	@Override
	public int len() {
		// TODO Auto-generated method stub
		return numItems;
	}
	public void max() {
		int m = numItems;
		for(int i=1 ; i<item.length ; i++) {
			if(numItems > m) {
				m = numItems;
			}
		}
		System.out.println(m);
		
	}
	public void min() {
		int m = numItems;
		for(int i=1 ; i<item.length ; i++) {
			if(numItems < m) {
				m = numItems;
			}
		}
		System.out.println(m);
		
	}
	
	public int all() {
		for(E i : (E[])new Object[DEFAULT_CAPACITY]) {
			System.out.println(i + " ");
		}
		return numItems;
	} // 과제 모든값 출력

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return numItems==0;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		item = (E[])new Object[DEFAULT_CAPACITY];
		numItems = 0;
	}

	public void printAll() {
		System.out.print("Print list (#items=" + numItems + ") ");
		for(int i = 0; i < numItems; i++) 
			System.out.print(item[i] + " ");
		System.out.println();
	}
//	public void printInterval(int i, int j) {
//		for(;i<=j; i ++) {
//			System.out.println(item[i]);
//		}
//	}
}
