package toy;

import java.util.TreeSet;

public class Toy {
	public static void main(String[] args) {
		TreeSet<String> a = new TreeSet<String>();
		a.add("5");
		a.add("5");
		a.add("3");
		System.out.println(a.size());
	}
}
