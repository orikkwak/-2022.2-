package list;

public class AllArrayListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AllArrayList<String> strList = new AllArrayList<>();
		
		strList.add(0, "I am");
		strList.append("a boy");strList.printAll();
		
		strList.append("my name");
		strList.append("is");
		strList.append("Kildong");strList.printAll();
		strList.set(1, "a girl");strList.printAll();
		
		AllArrayList<Double> dList = new AllArrayList<>();
		dList.add(0, 23.4);
		dList.add(1, 45.6);
		dList.append(50.7); dList.printAll();
		
		
	}

}
