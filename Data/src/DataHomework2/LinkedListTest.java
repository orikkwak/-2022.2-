package DataHomework2;

public class LinkedListTest {

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		list.add(0, 100);
		list.add(0, 200); list.printAll();
		list.append(50);
		list.append(20); list.printAll();
		list.remove(2);list.printAll();
		list.removeItem(200);list.printAll();
		
	}

}
