package d4;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution_2819_격자판의_숫자_이어_붙이기 {
	static String[][] map = null;
	static String[] arr = null;
	static Set<String> set = new HashSet<>();

	static void doDFS(int x, int y, int cnt) {
		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, 1, 0, -1 };
		if (cnt == 7) {
			String str = "";
			for(int i = 0; i < 7; i++) {
				str += arr[i];
			}
			set.add(str);
			return;
		}
		for (int i = 0; i < 4; i++) {
			int newX = x + dx[i];
			int newY = y + dy[i];
			if (-1 < newX && newX < 4 && -1 < newY && newY < 4) {
				arr[cnt] = map[newX][newY];
				doDFS(newX, newY, cnt + 1);
				arr[cnt] = "";
			}
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testCnt = scan.nextInt();
		for (int i = 1; i <= testCnt; i++) {
			set.clear();
			arr = new String[7];
			map = new String[4][4];
			for (int x = 0; x < 4; x++) {
				for (int y = 0; y < 4; y++) {
					map[x][y] = scan.next();
				}
			}
			for (int x = 0; x < 4; x++) {
				for (int y = 0; y < 4; y++) {
					arr[0] = map[x][y];
					doDFS(x, y, 1);
				}
			}
			System.out.println("#" + i + " " + set.size());
		}

	}
}
