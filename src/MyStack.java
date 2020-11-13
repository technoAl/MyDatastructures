public class MyStack<T> {
	T[] arr;
	int capacity;
	int size;
	int tailPointer;

	public MyStack(int capacity){
		this.capacity = capacity;
		size = 0;
		tailPointer = 0;
		arr = (T[]) new Object[capacity];
	}

	public boolean push(T e){
		if(size >= capacity){
			return false;
		}

		arr[tailPointer] = e;
		tailPointer++;
		size++;
		return true;
	}

	public T pop(){
		if(size == 0){
			return null;
		}

		T val = arr[tailPointer - 1];
		tailPointer--;
		size--;
		arr[tailPointer - 1] = null; // might be unnecessary

		return val;
	}

}
