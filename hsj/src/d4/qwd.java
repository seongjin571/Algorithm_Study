package d4;

import java.util.HashSet;
import java.util.Set;

public class qwd {
	public static void main(String[]args) {
		Set<Integer> set = new HashSet<>();
		int[] a = {1,3,5};
		int b = Integer.parseInt(a.toString());
		set.add(b);
		a[2] = 6;
		b = Integer.parseInt(a.toString());
		set.add(b);
		for(Integer bs : set) {
			System.out.println(bs);
		}
	}
}
