package list;

public class AllArrayList<E> implements AllIntegerface<E> {

	private E[] item;
	private int numItems;
	private static final int DEFAULT_CAPACITY = 64;

	public AllArrayList() {
		item = (E[])new Object[DEFAULT_CAPACITY];
		numItems = 0;
	}

	public AllArrayList(int n) {
		item = (E[]) new Integer[n];
		numItems = 0;
	}

	@Override
	public void add(int index, E x) {
		if (numItems >= item.length || index < 0 || index > numItems) {
			System.out.println("Error");
		} else {
			for (int i = numItems - 1; i >= index; i--)
				item[i + 1] = item[i];
			item[index] = x;
			numItems++;
		}
	}

	@Override
	public void append(E x) {
		if (numItems >= item.length)
			System.out.println("Error");
		else
			item[numItems++] = x;
	}

	@Override
	public E remove(int index) {
		if (isEmpty() || index < 0 || index > numItems - 1)
			return null;
		else {
			E tmp = item[index];
			for (int i = index; i <= numItems - 2; i++)
				item[i] = item[i + 1];
			numItems--;
			return tmp;
		}
	}

	@Override
	// [알고리즘 5-4] 구현 : 배열 리스트에서 원소 x 삭제하기
	public boolean removeItem(E x) {
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
	// [알고리즘 5-5] 구현 : 배열 리스트에서 i번째 원소 알려주기
	public E get(int index) {
		if (index >= 0 && index <= numItems - 1)
			return item[index];
		else
			return null;
	}

	@Override
	// [알고리즘 5-6] 구현 : 배열 리스트에서 i번째 원소
	public void set(int index, E x) {
		if (index >= 0 && index <= numItems - 1)
			item[index] = x;
		else
			System.out.println("Error");

	}

	private final int NOT_FOUND = -12345;

	@Override
	public int indexOf(E x) {
		int i = 0;
		for (i = 0; i < numItems; i++) {
			if (((Comparable) item[i]).compareTo(x) == 0)
//			if(item[i] == x)
				return i;
		}
		return -1;
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
		item = (E[]) new Integer[item.length];
		numItems = 0;
	}
	
	public void printAll() {
		System.out.println("Print list (#items=" + numItems +")");
		for(int i = 0; i < numItems; i++) {
			System.out.println(item[i] + "");
		}
		System.out.println();
	}

}
