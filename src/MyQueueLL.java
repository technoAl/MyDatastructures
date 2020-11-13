import java.util.LinkedList;
import java.util.List;

public class MyQueueLL<T> {
	List<T> linkedList;
	int size;

	public MyQueueLL(){
		size = 0;
		linkedList = new LinkedList<>();
	}

	public void add(T e){
		linkedList.add(e);
		size++;
	}

	public T remove(){
		return linkedList.remove(0);
	}
}
