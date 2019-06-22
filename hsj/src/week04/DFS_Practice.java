package week04;

public class DFS_Practice {
	static int[][] tenByTenMap = new int[10][10];
	static boolean[][] visit = new boolean[10][10];
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int count = 0;
	
	static void DFS(int x, int y) {
		for(int i = 0; i < 4; i++) {
			int newX = x + dx[i];
			int newY = y + dy[i];
			if((-1<newX && newX<10) && (-1<newY && newY<10) && visit[newX][newY] == false) {
				count++;
				tenByTenMap[newX][newY] = count;
				visit[newX][newY] = true;
				DFS(newX, newY);
			}
		}
	}
	public static void main(String[]args) {
		visit[0][0] = true;
		DFS(0, 0);
		for(int i = 0; i < 10; i ++) {
			for(int j = 0; j < 10; j++) {
				System.out.printf("%3d", tenByTenMap[i][j]);
			}
			System.out.println("");
		}
	}
}
