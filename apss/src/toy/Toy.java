package toy;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Toy {
	public static void main(String[] args) {
		TreeSet<String> a = new TreeSet<String>();
		a.add("5");
		a.add("5");
		a.add("3");
		System.out.println(a.size());
		List<String> b = new ArrayList<String>();
		b.add("bbb");
		System.out.println(b.toString());
	}
}
