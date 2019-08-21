package week13;

import java.util.ArrayList;
import java.util.List;

public class qwd {
	public static void main(String[]args) {
		List<int[]> list = new ArrayList<>();
		int[] arr = new int[2];
		arr[0] = 1;
		arr[1] = 2;
		list.add(arr);
		arr = new int[2];
		arr[0] = 5;
		arr[1] = 55;
		list.add(arr);
		for(int[] i : list) {
			System.out.println(i[0]);
		}
	}
	
}
