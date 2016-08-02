import java.util.HashMap;
import java.util.HashSet;

/**
 * @author Andreas Loizou
 *
 * @param <T1> The parameter that will be used as a key
 * @param <T2> The value of the HashMapList is actually a HashSet of T2 fields
 */
public class HashMapList<T1, T2> {

	HashMap<T1, HashSet<T2>> map;

	public HashMapList() {
		map = new HashMap<T1, HashSet<T2>>();
	}

	/**
	 * @param t1 The parameter that will be used as a key
	 * @param t2 One of the values for the t1 key that will be added in a HashMap associated with the t1 key.
	 */
	public void add(T1 t1, T2 t2) {
		if (map.containsKey(t1)) {
			map.get(t1).add(t2);
		} else {
			HashSet<T2> t2set = new HashSet<T2>();
			t2set.add(t2);
			map.put(t1, t2set);
		}
	}

	/**
	 * @param t1 The key
	 * @return A HashSet that contains all values associated with the t1 key.
	 */
	public HashSet<T2> get(T1 t1) {
		return map.get(t1);
	}

	/**
	 * @return The size of the HashMapList (How many keys we have)
	 */
	public int size() {
		return map.size();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
