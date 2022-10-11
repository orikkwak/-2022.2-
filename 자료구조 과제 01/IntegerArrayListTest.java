package list;

public class IntegerArrayListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntegerArrayList list = new IntegerArrayList();
		list.add(0, 100);
		list.append(200);list.printAll();
		
		list.append(300);
		list.append(400);
		list.append(500);list.printAll();
		list.add(2, 250);list.printAll();
		
		Integer a = list.remove(3);
		System.out.println("삭제된 값 = " +a);
		list.printAll();
		
		list.set(2, 300);list.printAll();
		boolean b = list.removeItem(350);
		System.out.println("삭제성공? = " +b);
		b = list.removeItem(300);
		System.out.println("삭제성공? = " +b);
		list.printAll();
	}

}
