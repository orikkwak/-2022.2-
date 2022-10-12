package DataHomework2;

public interface ListInterface<E> {
	public void add(int i, E x);
	public void append(E x);
	public E remove(int i);
	public boolean removeItem(E x);
	public E get(int i);
	public void set(int i, E x);
	public int indexOf(E x);
	public int len();
	public boolean isEmpty();
	public int total();
	public void clear();
	public int hap();
	public int maxList();
	public int minList();
	
}
