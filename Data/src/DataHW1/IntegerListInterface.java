package DataHW1;

public interface IntegerListInterface {
	public void add(int i, Integer x);
	public void append(Integer x);
	public Integer remove(int i);
	public boolean removeItem(Integer x);
	public Integer get(int i);
	public void set(int i, Integer x);
	public int indexOf(Integer x);
	public int len();
	public void max();//최대값
	public void min();//최소값
	public void printAll();//모든값출력
	public boolean isEmpty();
	public void clear();
	int total();
}
