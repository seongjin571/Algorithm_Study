package week11;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution_2115_벌꿀채취 {
	static int mapSize = 0;
	static int honeyCnt = 0;
	static int maxHoney = 0;
	static int[][] map = null;
	static boolean[][] visit = null;
	static List<Integer> list = new ArrayList<>();
	static List<Integer> list2 = new ArrayList<>();
	static List<Integer> list3 = new ArrayList<>();
	static int[] arr2 = new int[2];
	static int[] arr = null;
	static int maxNum = 0;

	static void getMaxHoney(int x, int y, int cnt, int idx, int cnt2 , int order) {
		if (cnt == cnt2) {
			int sum2 = 0;
			for (int i = 0; i < cnt2; i++) {
				sum2 += list3.get(arr[i]);
			}
			if (sum2 <= maxHoney) {
				int sum = 0;
				for (int i = 0; i < cnt2; i++) {
					sum += list3.get(arr[i]) * list3.get(arr[i]);
//					System.out.println(sum);
				}
				if (maxNum < sum) {
					System.out.println(maxNum + "  "+ sum);
					maxNum = sum;
					arr2[order] = maxNum;
				}
			}
			return;
		}
		for (int i = idx; i < honeyCnt; i++) {
			arr[cnt] = i;
			getMaxHoney(x, y, cnt + 1, i + 1, cnt2, order);
			arr[cnt] = 0;
		}
	}


	static void chooseHoney(List<Integer> list, int cnt) {
		for (int x = 0; x < mapSize; x++) {
			for (int y = 0; y < mapSize; y++) {
				if (y + honeyCnt > mapSize)
					continue;
				if (!visit[x][y]) {
					int sum = 0;
					for (int a = 0; a < honeyCnt; a++) {
						list.add(map[x][y + a]);
						list3.add(map[x][y + a]);
						sum += map[x][y + a];
						visit[x][y + a] = true;
					
					}
					if (sum > maxHoney) {
						list.clear();
						for (int l = 1; l < honeyCnt; l++) {
							arr = new int[l];
							getMaxHoney(x, y, 0, 0, l, cnt);
						}
//						list3.clear();
						break;
					}
					else {
						int sum3 = 0;
						for (int a = 0; a < honeyCnt; a++) {
							sum3 += map[x][y + a] * map[x][y + a];
						}
						if(arr2[cnt] < sum3)
							arr2[cnt] = sum3;
					}
				}
			}
			list.clear();
			list3.clear();
			if (cnt == 0) {
				maxNum = 0;
				chooseHoney(list2, cnt + 1);
			}
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testCnt = scan.nextInt();
		for (int i = 1; i <= testCnt; i++) {
			arr2 = new int[2];
			mapSize = scan.nextInt();
			honeyCnt = scan.nextInt();
			maxHoney = scan.nextInt();
			map = new int[mapSize][mapSize];
			visit = new boolean[mapSize][mapSize];
			for (int x = 0; x < mapSize; x++) {
				for (int y = 0; y < mapSize; y++) {
					map[x][y] = scan.nextInt();
				}
			}
			maxNum = 0;
			chooseHoney(list, 0);
			System.out.println("ss" + arr2[0] + "  " + arr2[1]);
			int result = arr2[0] + arr2[1];
			System.out.println("#" + i + " " + result);
		}
	}

}
