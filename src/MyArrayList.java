
public class MyArrayList<T> {
	T[] arr;
	int size;
	int pointer;


	public MyArrayList(){
		size = 0;
		arr = (T[]) new Object[4];
	}

	public T get(int index){
		if(index < 0 || index >= size){
			return null;
		}

		return arr[index];
	}

	public void add(T e){
		if(size == arr.length){
			doubleArray();
		}

		arr[size] = e;
		size++;
	}

	public void add(T e, int index){
		if(index < 0 || index >= size){
			return;
		}

		if(size + 1 == arr.length){
			doubleArray();
		}

		for(int i = size; i > index; i--){

			arr[size] = arr[size-1];
		}
		arr[index] = e;
	}

	public void remove(int index){
		if(index < 0 || index >= size){
			return;
		}

		for(int i = index; i < size-1; i++){
			arr[index] = arr[index+1];
		}
		arr[size-1] = null;
	}

	private void doubleArray(){
		T[] arr2 = (T[]) new Object[arr.length*2];
		for(int i = 0; i < arr.length;i++){
			arr2[i] = arr[i];
		}

		arr = arr2;
	}
}
