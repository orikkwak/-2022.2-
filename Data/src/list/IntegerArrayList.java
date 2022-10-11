package list;

public class IntegerArrayList implements IntegerListInterface {

	private Integer[] item;
	private int numItems;
	private static final int DEFAULT_CAPACITY = 64;

	public IntegerArrayList() {
		item = new Integer[DEFAULT_CAPACITY];
		numItems = 0;
	}

	public IntegerArrayList(int n) {
		item = new Integer[n];
		numItems = 0;
	}

	@Override
	public void add(int index, Integer x) {
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
	public void append(Integer x) {
		if (numItems >= item.length)
			System.out.println("Error");
		else
			item[numItems++] = x;
	}

	@Override
	public Integer remove(int index) {
		if (isEmpty() || index < 0 || index > numItems - 1)
			return null;
		else {
			Integer tmp = item[index];
			for (int i = index; i <= numItems - 2; i++)
				item[i] = item[i + 1];
			numItems--;
			return tmp;
		}
	}

	@Override
	// [알고리즘 5-4] 구현 : 배열 리스트에서 원소 x 삭제하기
	public boolean removeItem(Integer x) {
		int k = 0;
		while (k < numItems && item[k].compareTo(x) != 0)
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
	public Integer get(int index) {
		if (index >= 0 && index <= numItems - 1)
			return item[index];
		else
			return null;
	}

	@Override
	// [알고리즘 5-6] 구현 : 배열 리스트에서 i번째 원소
	public void set(int index, Integer x) {
		if (index >= 0 && index <= numItems - 1)
			item[index] = x;
		else
			System.out.println("Error");

	}

	private final int NOT_FOUND = -12345;

	@Override
	public int indexOf(Integer x) {
		int i = 0;
		for (i = 0; i < numItems; i++) {
//			if (((Comparable) item[i]).compareTo(x) == 0)
			if(item[i] == x)
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
		item = new Integer[item.length];
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
