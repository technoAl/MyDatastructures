import java.util.*;

public class AdjacencyListImplementations {
	public static void main(String[] args) {

	}

	public boolean BFS(ArrayList<Integer>[] graph, int target, int start){
		Queue<Integer> toVisit = new ArrayDeque<>();
		toVisit.add(start);
		while(!toVisit.isEmpty()){
			int cur = toVisit.remove();
			for(int neighbor:graph[cur]){
				if(neighbor == target){
					return true;
				}
				toVisit.add(neighbor);
			}
		}
		return false;
	}

	public int BFS_DIST(ArrayList<Integer>[] graph, int target, int start){
		Queue<Integer> toVisit = new ArrayDeque<>();
		toVisit.add(start);
		int[] dists = new int[graph.length];
		dists[start] = 0;
		boolean[] visited = new boolean[graph.length];
		visited[start] = true;
		while(!toVisit.isEmpty()){
			int cur = toVisit.remove();
			for(int neighbor:graph[cur]){
				if(neighbor == target){
					return dists[cur]+1;
				}
				if(!visited[neighbor] || dists[cur] + 1 < dists[neighbor]){
					toVisit.add(neighbor);
					dists[neighbor] = dists[cur] +1;
				}
			}
		}
		return -1;
	}

	public int[] BFS_ALL_DISTS(ArrayList<Integer>[] graph, int start){

		Queue<Integer> toVisit = new ArrayDeque<>();
		toVisit.add(start);
		int[] dists = new int[graph.length];
		boolean[] visited = new boolean[graph.length];
		dists[start] = 0;
		visited[start] = true;
		while(!toVisit.isEmpty()){
			int cur = toVisit.remove();
			visited[cur] = true;
			for(int neighbor:graph[cur]){
				if(!visited[neighbor] || dists[cur] + 1 < dists[neighbor]){
					toVisit.add(neighbor);
					dists[neighbor] = dists[cur] +1;
				}
			}
		}
		return dists;
	}
	public boolean DFS_RECURSIVE(ArrayList<Integer>[] graph, int current, int target, boolean[] visited){
		visited[current] = true;
		if(current == target){
			return true;
		} else {
			for(int neighbor: graph[current]){
				if(!visited[neighbor]) {
					DFS_RECURSIVE(graph, neighbor, target, visited);
				}
			}
			return false;
		}
	}

	public boolean DFS_STACK(ArrayList<Integer>[] graph, int target, int start){
		ArrayDeque<Integer> toVisit = new ArrayDeque<>();
		boolean[] visited = new boolean[graph.length];
		toVisit.add(start);
		visited[start] = true;
		while(!toVisit.isEmpty()){
			int cur = toVisit.pop();
			visited[cur] = true;
			for(int neighbor: graph[cur]){
				if(neighbor == target){
					return true;
				}
				if(!visited[neighbor]){
					toVisit.add(neighbor);
				}
			}
		}
		return false;
	}

	public int dijkstra(Map<Integer, Integer>[] graph, int target, int start){
		int[] minDistances = new int[graph.length];
		Arrays.fill(minDistances, Integer.MAX_VALUE);
		minDistances[start] = 0;
		Comparator<Integer> distCompare = (Integer a, Integer b) -> {return minDistances[a] - minDistances[b];};
		PriorityQueue<Integer> toVisit = new PriorityQueue<>(distCompare);
		toVisit.add(start);
		while(!toVisit.isEmpty()){
			int cur = toVisit.remove();
			if(cur == target){
				return cur;
			}
			for(int neighbor: graph[cur].keySet()){
				if(minDistances[cur] + graph[cur].get(neighbor) < minDistances[neighbor]){
					toVisit.remove(neighbor); // if neighbor was present, reput it into the queue
					toVisit.add(neighbor);
					minDistances[neighbor] = minDistances[cur] + graph[cur].get(neighbor);
				}
			}
		}
		return -1;
	}
	public int[] dijkstra_all_dists(Map<Integer, Integer>[] graph, int start){
		int[] minDistances = new int[graph.length];
		Arrays.fill(minDistances, Integer.MAX_VALUE);
		minDistances[start] = 0;
		Comparator<Integer> distCompare = (Integer a, Integer b) -> {return minDistances[a] - minDistances[b];};
		PriorityQueue<Integer> toVisit = new PriorityQueue<>(distCompare);
		toVisit.add(start);
		while(!toVisit.isEmpty()){
			int cur = toVisit.remove();
			for(int neighbor: graph[cur].keySet()){
				if(minDistances[cur] + graph[cur].get(neighbor) < minDistances[neighbor]){
					toVisit.remove(neighbor); // if neighbor was present, reput it into the queue
					toVisit.add(neighbor);
					minDistances[neighbor] = minDistances[cur] + graph[cur].get(neighbor);
				}
			}
		}
		return minDistances;
	}

	static class unionFind {
		int size;
		int[] id;
		int[] sizes;
		unionFind(int size){
			this.size = size;
			id = new int[size];
			sizes = new int[size];
			for(int i = 0; i < id.length; i++) {
				id[i] = i;
				sizes[i] = 1;
			}
		}

		int find(int cur) {
			int orig = cur;
			while(id[cur] != cur) {
				cur = id[cur];
			}
			int componentSize = sizes[cur];
			while(id[orig] != orig) {
				orig = id[orig];
				id[orig] = cur;
			}
			return cur;
		}
		void union(int p, int q) {
			int pRoot = find(p);
			int qRoot = find(q);
			if(pRoot == qRoot) {
				return;
			}
			if(pRoot < qRoot) {
				id[pRoot] = qRoot;
				sizes[qRoot]+=sizes[pRoot];
			}else {
				id[qRoot] = pRoot;
				sizes[pRoot]+=sizes[qRoot];
			}
		}
	}
}
