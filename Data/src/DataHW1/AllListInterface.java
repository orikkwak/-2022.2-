package DataHW1;

public interface AllListInterface<E> {
	public void add(int i, E x);
	public void append(E x);
	public E remove(int i);
	public boolean removeItem(E x);
	public E get(int i);
	public void set(int i, E x);
	public int indexOf(E x);
	public int len();
	public void max();//최대값
	public void min();//최소값
	public int all();//모든값출력
	public boolean isEmpty();
	public void clear();
}
