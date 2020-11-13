public class MyQueueRingBuffer<T> {
	T[] arr;
	int headPos, tailPos;
	int maxCapacity;

	public MyQueueRingBuffer(int maxCapacity){
		arr = (T[]) new Object[maxCapacity];
		headPos = 0;
		tailPos = 0;
		this.maxCapacity = maxCapacity;
	}

	public boolean add(T e){
		if(tailPos - headPos >= maxCapacity){
			return false;
		}

		arr[tailPos % maxCapacity] = e;
		tailPos++;
		return true;
	}

	public T remove(){
		if (tailPos - headPos == 0) {
			return null;
		}

		T val = arr[headPos % maxCapacity];
		arr[headPos % maxCapacity] = null; // arguably unnecessary
		headPos++;
		return val;
	}
}
