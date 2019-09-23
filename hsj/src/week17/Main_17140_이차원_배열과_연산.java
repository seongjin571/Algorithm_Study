package week17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

class Number implements Comparable<Number>{
	int idx, num, cnt;

	Number(int idx, int num, int cnt) {
		this.idx = idx;
		this.num = num;
		this.cnt = cnt;
	}

	@Override
	public int compareTo(Number number) {
		if(this.idx > number.idx) {
			return 1;
		}else if(this.idx == number.idx) {
			if(this.cnt > number.cnt) {
				return 1;
			}else if(this.cnt == number.cnt) {
				if(this.num > number.num) {
					return 1;
				}
			}else {
				return -1;
			}
		}
		return -1;
	}

}

public class Main_17140_이차원_배열과_연산 {
	public static void main(String[]args) {
		List<Number> list = new ArrayList<>();
		Scanner scan = new Scanner(System.in);
		Set<Integer> set = new HashSet<>();
		int x = scan.nextInt() - 1;
		int y = scan.nextInt() - 1;
		int value = scan.nextInt();
		int[][] map = new int[100][100];
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				map[i][j] = scan.nextInt();
			}
		}
		int xSize = 3;
		int ySize = 3;
		int cnt = 0;
		while(map[x][y] != value && cnt < 101) {
			cnt++;
			if(xSize >= ySize) {
				int[][] mapState = new int[xSize][101];
				int maxSize = 0;
				list.clear();
				for(int i = 0; i < xSize; i++) {
					set.clear();
					for(int j = 0; j < ySize; j++) {
						if(map[i][j] != 0) {
							mapState[i][map[i][j]]++;
							set.add(map[i][j]);
						}
					}
					for(int j = 0; j <= 100; j++) {
						if(mapState[i][j] != 0) {
							list.add(new Number(i, j, mapState[i][j]));
						}
					}
					maxSize = set.size() > maxSize ? set.size() : maxSize;
				}
				ySize = maxSize * 2;
				Collections.sort(list);
				map = new int[100][100];
				int idxCnt = -1;
				int beforeIdx = 0;
				for(Number number : list) {
					int idx = number.idx;
					int num = number.num;
					int numCnt = number.cnt;
					if(idxCnt >= 100) continue;
					if(idx >= 100) break;
					if(beforeIdx != idx) idxCnt = -1;
					map[idx][++idxCnt] = num;
					map[idx][++idxCnt] = numCnt;
					beforeIdx = idx;
				}
				
			}else {
				int[][] mapState = new int[ySize][101];
				int maxSize = 0;
				list.clear();
				for(int i = 0; i < ySize; i++) {
					set.clear();
					for(int j = 0; j < xSize; j++) {
						if(map[j][i] != 0) {
							mapState[i][map[j][i]]++;
							set.add(map[j][i]);
						}
					}
					for(int j = 0; j <= 100; j++) {
						if(mapState[i][j] != 0) {
							list.add(new Number(i, j, mapState[i][j]));
						}
					}
					maxSize = set.size() > maxSize ? set.size() : maxSize;
				}
				xSize = maxSize * 2;
				Collections.sort(list);
				map = new int[100][100];
				int idxCnt = -1;
				int beforeIdx = 0;
				for(Number number : list) {
					int idx = number.idx;
					int num = number.num;
					int numCnt = number.cnt;
					if(idxCnt >= 100) continue;
					if(idx >= 100) break;
					if(beforeIdx != idx) idxCnt = -1;
					map[++idxCnt][idx] = num;
					map[++idxCnt][idx] = numCnt;
					beforeIdx = idx;
				}
			}
		}
		cnt = cnt == 101 ? -1 : cnt;
		System.out.println(cnt);
	}
}
