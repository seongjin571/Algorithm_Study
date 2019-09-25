#include <iostream>
#include <queue>
using namespace std;
struct info {
	int t;
	char c;
};
struct snake {
	int head_x;
	int head_y;
	int tail_x;
	int tail_y;
};
int dx[4] = { 0,1,0,-1 };
int dy[4] = { 1,0,-1,0 };
snake s;
char dir;
int flag;
int result;
queue<info> que;
int n, apple,l;
int map[101][101];
int check[101][101];
void go_snake()
{
	if (dir == 'E')
	{
		int newx = s.head_x;
		int newy = s.head_y + 1;
		if ((-1 >= newy) || (newy >= n) || (check[newx][newy] == 1))
		{
			flag = 1;
			return;
		}
		
		if (map[newx][newy] == 3)//사과섭취
		{
			s.head_x = newx;
			s.head_y = newy;
			check[newx][newy] = 1;
		}
		else
		{
			check[newx][newy] = 1;
			s.head_x = newx;
			s.head_y = newy;
			for (int i = 0; i < 4; i++)
			{
				int findx = s.tail_x + dx[i];
				int findy = s.tail_y + dy[i];
				if (check[findx][findy] == 1 )
				{
					check[s.tail_x][s.tail_y] = 0;
					s.tail_x = findx;
					s.tail_y = findy;
					break;
				}
			}
		}
	}
	else if (dir == 'S')
	{
		int newx = s.head_x + 1;
		int newy = s.head_y;
		if ((-1 >= newx) || (newx >= n) || check[newx][newy] == 1)
		{
			flag = 1;
			return;
		}

		if (map[newx][newy] == 3)//사과섭취
		{
			s.head_x = newx;
			s.head_y = newy;
			check[newx][newy] = 1;
		}
		else
		{
			check[newx][newy] = 1;
			s.head_x = newx;
			s.head_y = newy;
			for (int i = 0; i < 4; i++)
			{
				int findx = s.tail_x + dx[i];
				int findy = s.tail_y + dy[i];
				if (check[findx][findy] == 1 )
				{
					check[s.tail_x][s.tail_y] = 0;
					s.tail_x = findx;
					s.tail_y = findy;
					break;
				}
			}
		}
	}
	else if (dir == 'W')
	{
		int newx = s.head_x;
		int newy = s.head_y - 1;
		if ((-1 >= newy) || (newy >= n) || (check[newx][newy] == 1))
		{
			flag = 1;
			return;
		}

		if (map[newx][newy] == 3)//사과섭취
		{
			s.head_x = newx;
			s.head_y = newy;
			check[newx][newy] = 1;
		}
		else
		{
			check[newx][newy] = 1;
			s.head_x = newx;
			s.head_y = newy;
			for (int i = 0; i < 4; i++)
			{
				int findx = s.tail_x + dx[i];
				int findy = s.tail_y + dy[i];
				if (check[findx][findy] == 1 )
				{
					check[s.tail_x][s.tail_y] = 0;
					s.tail_x = findx;
					s.tail_y = findy;
					break;
				}
			}
		}

	}
	else if (dir == 'N')
	{
		int newx = s.head_x - 1;
		int newy = s.head_y;
		if ((-1 >= newx) || (newx >= n) || check[newx][newy] == 1)
		{
			flag = 1;
			return;
		}

		if (map[newx][newy] == 3)//사과섭취
		{
			s.head_x = newx;
			s.head_y = newy;
			check[newx][newy] = 1;
		}
		else
		{
			check[newx][newy] = 1;
			s.head_x = newx;
			s.head_y = newy;
			for (int i = 0; i < 4; i++)
			{
				int findx = s.tail_x + dx[i];
				int findy = s.tail_y + dy[i];
				if (check[findx][findy] == 1)
				{
					check[s.tail_x][s.tail_y] = 0;
					s.tail_x = findx;
					s.tail_y = findy;
					break;
				}
			}
		}
	}
	
}
void change_go_snake()
{
	if (que.front().c == 'L')//왼쪽으로 90도 회전
	{
		if (dir == 'E')
		{
			go_snake();
			dir = 'N';
			//go_snake();
		}
		else if (dir == 'S')
		{
			go_snake();
			dir = 'E';
			//go_snake();
		}
		else if (dir == 'W')
		{
			go_snake();
			dir = 'S';
		}
		else if (dir == 'N')
		{
			go_snake();
			dir = 'W';
		}
	}
	else//오른쪽으로 회전
	{
		if (dir == 'E')
		{
			go_snake();
			dir = 'S';
		}
		else if (dir == 'S')
		{
			go_snake();
			dir = 'W';
		}
		else if (dir == 'W')
		{
			go_snake();
			dir = 'N';
		}
		else if (dir == 'N')
		{
			go_snake();
			dir = 'E';
		}
	}
}
int main()
{
	cin >> n;
	cin >> apple;
	int x, y;
	for (int i = 0; i < apple; i++)
	{
		cin >> x >> y;
		x = x - 1;
		y = y - 1;
		map[x][y] = 3;//3->사과
	}
	cin >> l;
	int t;
	char c;
	for (int i = 0; i < l; i++)
	{
		cin >> t >> c;
		que.push({ t,c });
	}
	result = 0;
	flag = 0;
	dir = 'E';
	s.head_x = 0;
	s.head_y = 0;
	s.tail_x = 0;
	s.tail_y = 0;
	check[s.head_x][s.head_y] = 1;
	check[s.tail_x][s.tail_y] = 1;
	int change_t;
	for (int i = 1; i < 10001; i++)
	{
		if (que.empty())
		{
			change_t = 900001;
		}
		else
			change_t = que.front().t;
		if (i == change_t)
		{
			change_go_snake();
			que.pop();
		}
		else
		{
			go_snake();
		}

		if (flag == 1)
		{
			result = i;
			break;
		}
	}
	cout << result;
}