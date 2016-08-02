import java.util.HashMap;
import java.util.HashSet;

public class HashMapList<T1, T2> {

	HashMap<T1, HashSet<T2>> map;

	public HashMapList() {
		map = new HashMap<T1, HashSet<T2>>();
	}

	public void add(T1 t1, T2 t2) {
		if (map.containsKey(t1)) {
			map.get(t1).add(t2);
		} else {
			HashSet<T2> t2set = new HashSet<T2>();
			t2set.add(t2);
			map.put(t1, t2set);
		}
	}

	public HashSet<T2> get(T1 t1) {
		return map.get(t1);
	}

	public int size() {
		return map.size();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
