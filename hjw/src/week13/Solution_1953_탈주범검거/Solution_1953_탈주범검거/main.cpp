//탈출한 지 한시간 뒤 맨홀뚜껑을 통해 지하터널의 어느 한지점으로 들어감
//시간당 1거리 이동 가능
//1->상하좌우
//2->상하
//3->좌우
//4->상우
//5->하우
//6->하좌
//7->상좌
#include <iostream>
#include <queue>
#include <fstream>
using namespace std;
struct loc {
	int x;
	int y;
	int hole;
	int b_num;
};
int dx[4] = { 0.1,0,-1 };
int dy[4] = { 1,0,-1,0 };
int n, m, r, c, l;
int map[51][51];
int check[51][51];
int result;
queue<loc>que;
void up(int x, int y,int z)
{
	if ((-1 < x && x < n) && (-1 < y && y < m) && (map[x][y] == 1 || map[x][y] == 2 || map[x][y] == 5 || map[x][y] == 6) && (check[x][y] != 1))
	{
		loc t;
		t.x = x;
		t.y = y;
		t.hole = map[x][y];
		t.b_num = z + 1;
		que.push(t);
		check[x][y] = 1;
	}
}
void down(int x, int y, int z)
{
	if ((-1 < x && x < n) && (-1 < y && y < m) && (map[x][y] == 1 || map[x][y] == 2 || map[x][y] ==4 || map[x][y] == 7) && (check[x][y] != 1))
	{
		loc t;
		t.x = x;
		t.y = y;
		t.hole = map[x][y];
		t.b_num = z + 1;
		que.push(t);
		check[x][y] = 1;
	}
}
void left(int x, int y, int z)
{
	if ((-1 < x && x < n) && (-1 < y && y < m) && (map[x][y] ==1 || map[x][y] == 3 || map[x][y] == 4 || map[x][y] == 5) && (check[x][y] != 1))
	{
		loc t;
		t.x = x;
		t.y = y;
		t.hole = map[x][y];
		t.b_num = z + 1;
		que.push(t);
		check[x][y] = 1;
	}
}
void right(int x, int y, int z)
{
	if ((-1 < x && x < n) && (-1 < y && y < m) && (map[x][y] == 1 || map[x][y] ==3 || map[x][y] == 6 || map[x][y] == 7) && (check[x][y] != 1))
	{
		loc t;
		t.x = x;
		t.y = y;
		t.hole = map[x][y];
		t.b_num = z + 1;
		que.push(t);
		check[x][y] = 1;
	}
}
void bfs(int start_x, int start_y)
{
	loc t;
	t.x = start_x;
	t.y = start_y;
	t.b_num = 0;
	t.hole = map[start_x][start_y];
	que.push(t);
	check[que.front().x][que.front().y] = 1;
	while (!que.empty())
	{
		if (que.front().b_num >= l)
			break;
		loc tt;
		tt.x = que.front().x;
		tt.y = que.front().y;
		//check[tt.x][tt.y] = 0;
		int bfs_num = que.front().b_num;
		int newx = tt.x;
		int newy = tt.y;
		que.pop();
		switch (map[newx][newy])
		{
		case 1: up(newx - 1, newy,bfs_num);
			down(newx + 1, newy, bfs_num);
			left(newx, newy - 1, bfs_num);
			right(newx, newy + 1, bfs_num);
			break;
		case 2:
			up(newx -1, newy, bfs_num);
			down(newx + 1, newy, bfs_num);
			break;
		case 3:
			left(newx, newy - 1, bfs_num);
			right(newx, newy + 1, bfs_num);
			break;
		case 4:
			up(newx - 1, newy, bfs_num);
			right(newx, newy + 1, bfs_num);
			break;
		case 5:
			down(newx + 1, newy, bfs_num);
			right(newx, newy + 1, bfs_num);
			break;
		case 6:
			down(newx + 1, newy, bfs_num);
			left(newx, newy - 1, bfs_num);
			break;
		case 7:
			up(newx - 1, newy, bfs_num);
			left(newx, newy - 1, bfs_num);
			break;
		default:
			break;		
		}
	}
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
		{
			if (check[i][j] == 1)
				result++;
		}
	}
}
int main()
{
	//ifstream inf("C:\\Users\\admin\\Downloads\\sample_input.txt");
	int test_case;
	cin >> test_case;
	//inf >> test_case;
	for (int t = 1; t <= test_case; t++)
	{
		result = 0;
		//inf >> n >> m >> r >> c >> l;
		cin >> n >> m >> r >> c >> l;//행 열 맨뚜껑세로 맨뚜껑가로 탈출후 소요시간
		l = l - 1;
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < m; j++)
			{
				cin >> map[i][j];
				//inf >> map[i][j];
			}
		}
		bfs(r,c);
		printf("#%d %d\n", t, result);
		result = 0;
		while (!que.empty())
		{
			que.pop();
		}
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < m; j++)
				check[i][j] = 0;
		}
	}
}