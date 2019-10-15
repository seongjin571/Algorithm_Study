package week19;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Tree implements Comparable<Tree> {
	int age;

	Tree(int age) {
		this.age = age;
	}
	
	@Override
	public int compareTo(Tree tree) {
		if (this.age > tree.age) {
			return 1;
		}
		return -1;
	}
}

class Land {
	int x, y, num, addNum, dieNum;
	List<Tree> tree = new ArrayList<>();

	Land(int x, int y, int num, int addNum, int dieNum) {
		this.x = x;
		this.y = y;
		this.num = num;
		this.addNum = addNum;
		this.dieNum = dieNum;
	}
}

public class Main_16235_나무_재테크 {
	public static void main(String[] args) {
		int[] dx = { -1, -1, -1, 0, 1, 1, 1, 0 };
		int[] dy = { -1, 0, 1, 1, 1, 0, -1, -1 };
		List<Land> landList = new ArrayList<>();
		Scanner scan = new Scanner(System.in);
		int mapSize = scan.nextInt();
		int treeNum = scan.nextInt();
		int year = scan.nextInt();
		int[][] idxMap = new int[mapSize][mapSize];
		int cnt = 0;
		for (int x = 0; x < mapSize; x++) {
			for (int y = 0; y < mapSize; y++) {
				landList.add(new Land(x, y, 5, scan.nextInt(), 0));
				idxMap[x][y] = cnt++;
			}
		}
		for (int i = 0; i < treeNum; i++) {
			int x = scan.nextInt() - 1;
			int y = scan.nextInt() - 1;
			int age = scan.nextInt();
			int idx = idxMap[x][y];
			Land land = landList.get(idx);
			land.tree.add(new Tree(age));
		}

		for (int i = 0; i < year * 4; i++) {
			int season = i % 4;
			for (Land land : landList) {
				if (season == 0) {
					int oneTreeNum = land.tree.size();
					if (oneTreeNum > 0) {
						Collections.sort(land.tree);
						for(int t = 0; t < oneTreeNum; t++) {
							Tree oneTree = land.tree.get(t);
							if (oneTree.age <= land.num) {
								land.num -= oneTree.age;
								oneTree.age++;
							} else {
								land.dieNum += oneTree.age / 2;
								land.tree.remove(t);
								t--;
								oneTreeNum--;
							}
						}
					}

				} else if (season == 1) {
					land.num += land.dieNum;
					land.dieNum = 0;
					
				} else if (season == 2) {
					int oneTreeNum = land.tree.size();
					if (oneTreeNum > 0) {
						int x = land.x;
						int y = land.y;
						for (Tree oneTree : land.tree) {
							if (oneTree.age % 5 == 0) {
								for (int arrIdx = 0; arrIdx < 8; arrIdx++) {
									int newX = x + dx[arrIdx];
									int newY = y + dy[arrIdx];
									if (-1 < newX && newX < mapSize && -1 < newY && newY < mapSize) {
										int idx = idxMap[newX][newY];
										Land oneLand = landList.get(idx);
										oneLand.tree.add(new Tree(1));
									}
								}
							}
						}
					}

				} else {
					land.num += land.addNum;
				}
			}
		}
		int result = 0;
		for (Land land : landList) {
			result += land.tree.size();
		}
		System.out.println(result);
	}
}
