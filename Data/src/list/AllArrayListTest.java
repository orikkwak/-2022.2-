package list;

public class AllArrayListTest {

	public static void main(String[] args) {
		AllArrayList<String> strList = new AllArrayList();
		strList.add(0, "I am");
		strList.append("a boy");
		strList.printAll();
		strList.append("my name");
		strList.append("is");
		strList.append("kidong"); strList.printAll();
		

		strList.set(1, "a girl"); strList.printAll();

		AllArrayList<Double> dlist = new AllArrayList();
		dlist.add(0, 23.4);
		dlist.add(1, 45.6);
		dlist.append(50.7); dlist.printAll();
		
	}

}
