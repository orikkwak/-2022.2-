package hashTable;
import BST.IndexInterface;

public class ArrayHashTable implements IndexInterface<Integer>{
	private Integer table[];
	int numItems;
	static final Integer DELETED = -12345, NOT_FOUND = -1; 
	
	public ArrayHashTable(int n) {
		table = new Integer[n];
		numItems = 0;
	 	for(int i = 0; i < n, i++) table[i] = null;
	}

	private int hash(int i, Integer x) {
		return (x + i) % table.length;
	}
	
	public void insert(Integer x) {
		int slot;
		if (numItems == table.length) { /* 에러 처리 */ }
		else {
			for (int i = 0; i < table.length; i++) {
				slot = hash(i, x);
				if (	table[slot] == null || table[slot] == DELETED) {  
					table[slot] = x;
					numItems++;
					break;
				}
			}
		}
	} 
 
	public Integer search(Integer x) {
		int slot;
		for (int i = 0; i < table.length; i++) {
			slot = hash(i, x);
			if (table[slot] == null) return NOT_FOUND; // search failed
			if (table[slot].compareTo(x) == 0) 
				return slot;  
		}
		return NOT_FOUND;
	}
	
	public void delete(Integer x) {
		int slot = 0;
		for (int i = 0; i< table.length; i++) {
			slot = hash(i, x);
			if (table[slot] == null) break; // 필요 시 에러 처리
			if (table[slot].compareTo(x) == 0) {
					table[slot] = DELETED;
					numItems--;
					break;
			}
		}
	}
	
	public Integer getItem(Integer i) {
		return table[i];
	}

	//////////////////////////////////////////////////
	public void printAll() {
		System.out.println("Slots:"); 
		for (int i=0; i < table.length; i++) {
			System.out.println("   " + i + ": " + table[i]);
		}
	}
} // 코드 12-3
