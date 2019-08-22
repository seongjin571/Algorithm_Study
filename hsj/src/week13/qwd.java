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
		int[] arr2 = new int[2];
		arr2[0] = 44;
		arr2[1] = 30;
		list.add(arr2);
		for(int[] arr3 : list) {
			arr3[1] = 32323;
		}
		for(int[] arr4 : list) {
			System.out.println(arr4[1]);
		}
	}
	
}
