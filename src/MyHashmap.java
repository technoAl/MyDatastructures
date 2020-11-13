import java.util.Map;

public class MyHashmap<T, U>{
	DataPair<T, U>[] storageArray;
	int size;
	int maxCapacity;

	public MyHashmap(int maxCapacity){
		this.maxCapacity = maxCapacity;
		storageArray = new DataPair[maxCapacity];
		size = 0;
	}

	public U put(T key, U value){

		if(size == maxCapacity){
			return null;
		}

		int pos = hashCode(key) % maxCapacity;
		if(storageArray[pos] != null){ // search for next empty slot
			while(storageArray[pos] != null){
				pos = (pos + 1) % maxCapacity;
			}
		}
		storageArray[pos] = new DataPair<>(key, value);

		size++;
		return value;
	}

	public U get(T key){
		int pos = key.hashCode() % maxCapacity;
		while(storageArray[pos] != null){
			if(storageArray[pos].key == key){
				return storageArray[pos].val;
			}
			pos = (pos + 1) % maxCapacity;
		}
		return null;
	}

	public int hashCode(T key){
		return key.hashCode() % maxCapacity;
	}


	static class DataPair<T, U>{
		T key;
		U val;
		public DataPair(T key, U val){
			this.key = key;
			this.val = val;
		}
	}
}
