//Ż���� �� �ѽð� �� ��Ȧ�Ѳ��� ���� �����ͳ��� ��� ���������� ��
//�ð��� 1�Ÿ� �̵� ����
//1->�����¿�
//2->����
//3->�¿�
//4->���
//5->�Ͽ�
//6->����
//7->����
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
		cin >> n >> m >> r >> c >> l;//�� �� �ǶѲ����� �ǶѲ����� Ż���� �ҿ�ð�
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