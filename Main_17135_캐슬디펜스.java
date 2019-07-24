package Main;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main_17135_캐슬디펜스 {
	static class rc{	
		//Queue와 ArrayList에 넣을 객체
		// x,y 좌표
		// cnt 움직인 횟수
		public int x;
		public int y;
		public int cnt;
		public rc(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
		@Override
		public String toString() {
			return "rc [x=" + x + ", y=" + y + ", cnt=" + cnt + "]";
		}
	}
	public static int [][]map;	//입력받을 2차원 Map
	public static int [][]tmpMap; //복사해서 풀 Map
	static int []seq;
	static Queue<rc> q;
	static ArrayList<rc> li;
	public static int []dx = {0,-1,0};	//좌 상 우 방향으로 설정.
	public static int []dy = {-1,0,1};
	public static int n,m,k, ans; 
	// n : 가로, m : 세로, k : 사거리, ans : 정답
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("rs/17135.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//입력 n, m, k
		String data = br.readLine();
		String []d = data.split(" ");
		n = Integer.parseInt(d[0]);
		m = Integer.parseInt(d[1]);
		k = Integer.parseInt(d[2]);
		ans = Integer.MIN_VALUE;
		// map의 크기 
		// row : n+1	n+1의 이유는 궁수를 배치하기 위해서 하나 더 크게 만듬.  
		// col : m
		map = new int[n+1][m];

		// Map 입력
		for(int i=0; i<n; i++){
			data = br.readLine();
			d = data.split(" ");
			for(int j=0; j<m; j++)
				map[i][j] = Integer.parseInt(d[j]);
		}
		//궁수위치를 위해 1차원 배열 생성.
		seq = new int[3];
		// 3명의 궁수를 위한 조합 재귀문.
		nCr(0,0);
		System.out.println(ans);
	}
	private static void nCr(int idx, int cnt) {
		if(cnt == 3){	// 궁수를 모두 뽑았을 경우.
			tmpMap = new int[n+1][m];
			for(int i=0; i<n; i++)	// 임시 맵 복사
				for(int j=0; j<m; j++)
					tmpMap[i][j] = map[i][j];
			int sum =0;
			for(int i=0; i<n; i++){	// n 궁수가 있는 거리만큼 동작함.
				li = new ArrayList<>();	// 적의 좌표를 담을 ArrayList
				for(int com=0; com<3; com++){	//3명의 궁수를 맵에다 부르기 위한 반복문
					// q 초기화
					q = new LinkedList<>();
					//임시맵에다가 궁수를 배치
					tmpMap[n][seq[com]] = 3;
					q.offer(new rc(n, seq[com], 0));
					//가장 가까운 적을 찾기위한 bfs
					bfs();
				}
				for(int z=0; z<li.size(); z++){
					rc a =li.get(z);
					//해당 좌표의 값을 sum값에 넣는다. 각 조합마다 sum에다가 잡을 수 있는 수를 저장둔다
					sum += tmpMap[a.x][a.y];	
					//중복되는 적을 잡을 경우를 대비하여 임시맵을 0으로 만들어준다.
					//뒤에 중복된 좌표가 나와서 현재 임시맵은 0을 가지기 때문에 sum값에 한명만 추가하게 된다.
					tmpMap[a.x][a.y] = 0;	
				}
				//라인을 한줄씩 내리는 함수
				move();
			}
			// 최대값 갱신.
			ans = Math.max(ans, sum);
			return;
		}

		for(int i=idx; i<m; i++){
			seq[cnt] = i;
			nCr(i+1,cnt+1);
			seq[cnt] = 0;
		}
	}
	private static void move() {
		//한줄(세로)를 보면서 한줄씩 땡기는 작업을 한다
		for(int i=0; i<m; i++){
			for(int j=n-1; j>0; j--){
				tmpMap[j][i] = tmpMap[j-1][i];
				tmpMap[j-1][i] = 0;
			}
		}
	}
	private static void bfs() {
		//q가 비어있을때까지 while을 실행한다.
		while(!q.isEmpty()){
			rc a = q.poll();
			
			//	현재 움직인 거리가 사거리보다 큰경우 바로 종료시킨다.
			if(a.cnt >= k)
				return ;
			for(int i=0; i<3; i++){	// 3방향 탐색 좌 상 
				int nx = a.x + dx[i];
				int ny = a.y + dy[i];
				if(0 <= nx && nx <= n && 0 <= ny && ny < m){	// 맵안에 있는 경우의 조건문.
					if(tmpMap[nx][ny] != 1)	//	적이 아닌 다른 애들일 경우 계속 적을 찾는다.
						q.offer(new rc(nx,ny,a.cnt+1));
					else if(tmpMap[nx][ny] == 1){	// 적이 있는 경우 적의 좌표를 ArrayList에 담는다.
						li.add(new rc(nx, ny, 0));
						return ;
					}
				}

			}

		}
	}
}
