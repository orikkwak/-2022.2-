package DataHW1;

public class IntegerArrayListTest {

	public static void main(String[] args) {
		IntegerArrayList list = new IntegerArrayList();
		list.add(0, 100);
		list.append(200);list.printAll();
		
		list.append(300);
		list.append(400);
		list.append(500);list.printAll();
		list.add(2, 250);list.printAll();
		
		Integer a = list.remove(3);
		System.out.println("������ �� = " +a);
		list.printAll();
		
		list.set(2, 300);list.printAll();
		boolean b = list.removeItem(350);
		System.out.println("��������? = " +b);
		b = list.removeItem(300);
		System.out.println("��������? = " +b);
		list.printAll();
	}

}
