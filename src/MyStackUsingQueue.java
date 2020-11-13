import java.util.ArrayDeque;
import java.util.Queue;

public class MyStackUsingQueue<T> {
	Queue<T> queue1;
	Queue<T> queue2; // always empty until psh
	int size;

	public MyStackUsingQueue(){
		queue1 = new ArrayDeque<>();
		queue2 = new ArrayDeque<>();
		size = 0;
	}

	public void push(T e){
		size++;

		queue2.add(e);

		while(!queue1.isEmpty()){
			queue2.add(queue1.remove());
		}

		Queue<T> tmp = queue1;
		queue1 = queue2;
		queue2 = tmp;
	}

	public T pop(){
		if(size == 0){
			return null;
		}
		return queue1.remove();
	}
}
