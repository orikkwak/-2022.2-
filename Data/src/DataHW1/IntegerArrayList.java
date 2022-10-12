package DataHW1;

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
		// TODO Auto-generated method stub
		if (numItems >= item.length || index < 0 || index > numItems) {
			System.out.println("배열의 공간이 부족하거나, 인덱스가 올바르지않다.");
		} else {
			for (int i = numItems - 1; i >= index; i--)
				item[i + 1] = item[i];

			item[index] = x;
			numItems++;
		}
	}

	@Override
	public void append(Integer x) {
		// TODO Auto-generated method stub
		if (numItems >= item.length) {
			System.out.println("배열의 공간이 부족하다");
		} else {
			item[numItems++] = x;
		}
	}

	@Override
	public Integer remove(int index) {
		// TODO Auto-generated method stub
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
	public boolean removeItem(Integer x) {
		// TODO Auto-generated method stub
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
	public Integer get(int index) {
		// TODO Auto-generated method stub
		if (index >= 0 && index <= numItems - 1)
			return item[index];
		else
			return null;
	}

	@Override
	public void set(int index, Integer x) {
		// TODO Auto-generated method stub
		if (index >= 0 && index <= numItems - 1)
			item[index] = x;
		else {
			System.out.println("인덱스 범위가 잘못되었다");
		}
	}

	// private final int NOT_FOUND = -12345;
	@Override
	public int indexOf(Integer x) {
		// TODO Auto-generated method stub
		int i = 0;
		for (i = 0; i < numItems; i++) {
			// if (((Comparable)item[i]).compareTo(x) == 0)
			if (item[i] == x)
				return i;
		}
		return -1; // not exist
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
		item = new Integer[DEFAULT_CAPACITY];
		numItems = 0;
	}

	public void printAll() {
		System.out.print("Print list (#items=" + numItems + ") ");
		for (int i = 0; i < numItems; i++)
			System.out.print(item[i] + " ");
		System.out.println();
	}
	
	public void hap() {
		int a = 0;
		for(int i = 0 ; i < numItems; i++) {
			a += item[i];
		}
		System.out.print("모든값의 합 : " + a);
		System.out.println();
	}

	@Override
	public int total() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void max() {
		int a = 0;
//		System.out.println("최대값 : " + numItems);
		for (int i = 1; i < item.length; i++) {
			if (item[i] > a) {
				a = item[i];
			}		
		}
		System.out.println("최대값 : " + a);
		System.out.println();
	}
	
	public void min() {
		int min = 0;
//		System.out.println("최소값 : " +  min);
		for (int i = 1; i < item.length; i++) {
			if (item[i] < min) {
				min = item[i];
			}
			System.out.println("최소값 : " +  min);
			System.out.println();
		}
	}
}
