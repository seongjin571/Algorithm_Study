#include <iostream>

using namespace std;
int flag;
int map[51][51];
int check[51][51];
int n, m;
int r, c, d;
int result;
void north(int ,int);
void west(int, int);
void south(int, int);
void east(int, int);
int main()
{
	cin >> n >> m;
	cin >> r >> c >> d;
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
		{
			cin >> map[i][j];
		}
	}
	result = 0;
	flag = 0;
	switch (d)
	{
	case 0: north(r,c); break;
	case 1: east(r,c); break;
	case 2: south(r,c); break;
	case 3: west(r,c); break;
	default:
		break;
	}
	cout << result;
}
void east(int x, int y)
{
	if (flag == 1)
		return;
	if (check[x][y] != 1 && map[x][y] != 1)
	{
		result++;
		check[x][y] = 1;
	}
	int dx[4] = { -1,0,1,0 };
	int dy[4] = { 0,-1,0,1 };
	int dir = -1;//ºÏ ¼­ ³² µ¿
	int possible_go = 0;
	int can_i_go_back = 1;
	if (map[x][y-1] == 1)
		can_i_go_back = 0;//ÈÄÁøÁ¶Â÷ ¾ÈµÊ
	for (int i = 0; i < 4; i++)
	{
		dir++;
		int newx = x + dx[i];
		int newy = y + dy[i];
		if ((-1 < newx && newx < n) && (-1 < newy && newy < m) && (map[newx][newy] == 0) && (check[newx][newy] == 0))
		{
			possible_go = 1;
			break;
		}
	}

	if (possible_go == 1)
	{
		switch (dir)
		{
		case 0: north(x -1, y); break;
		case 1: west(x, y - 1); break;
		case 2: south(x + 1, y); break;
		case 3: east(x, y + 1); break;
		default:
			break;
		}
	}
	else
	{
		if (can_i_go_back == 0)
			flag = 1;
		else
		{
			east(x, y-1);
		}
	}
	if (flag == 1)
		return;
}
void south(int x, int y)
{
	if (flag == 1)
		return;
	if (check[x][y] != 1 && map[x][y] != 1)
	{
		result++;
		check[x][y] = 1;
	}
	int dx[4] = { 0,-1,0,1 };
	int dy[4] = { 1,0,-1,0 };
	int dir = -1;//µ¿ ºÏ ¼­ ³²
	int possible_go = 0;
	int can_i_go_back = 1;
	if (map[x-1][y] == 1)
		can_i_go_back = 0;//ÈÄÁøÁ¶Â÷ ¾ÈµÊ
	for (int i = 0; i < 4; i++)
	{
		dir++;
		int newx = x + dx[i];
		int newy = y + dy[i];
		if ((-1 < newx && newx < n) && (-1 < newy && newy < m) && (map[newx][newy] == 0) && (check[newx][newy] == 0))
		{
			possible_go = 1;
			break;
		}
	}

	if (possible_go == 1)
	{
		switch (dir)
		{
		case 0: east(x, y+1); break;
		case 1: north(x-1, y); break;
		case 2: west(x, y-1); break;
		case 3: south(x+1, y); break;
		default:
			break;
		}
	}
	else
	{
		if (can_i_go_back == 0)
			flag = 1;
		else
		{
			south(x-1,y);
		}
	}
	if (flag == 1)
		return;
}
void west(int x, int y)
{
	if (flag == 1)
		return;
	if (check[x][y] != 1 && map[x][y] != 1)
	{
		result++;
		check[x][y] = 1;
	}
	int dx[4] = { 1,0,-1,0 };
	int dy[4] = { 0,1,0,-1 };
	int dir = -1;//³² µ¿ ºÏ ¼­
	int possible_go = 0;
	int can_i_go_back = 1;
	if (map[x][y+1] == 1)
		can_i_go_back = 0;//ÈÄÁøÁ¶Â÷ ¾ÈµÊ
	for (int i = 0; i < 4; i++)
	{
		dir++;
		int newx = x + dx[i];
		int newy = y + dy[i];
		if ((-1 < newx && newx < n) && (-1 < newy && newy < m) && (map[newx][newy] == 0) && (check[newx][newy] == 0))
		{
			possible_go = 1;
			break;
		}
	}

	if (possible_go == 1)
	{
		switch (dir)
		{
		case 0: south(x + 1, y); break;
		case 1: east(x, y + 1); break;
		case 2: north(x - 1, y); break;
		case 3: west(x, y - 1); break;
		default:
			break;
		}
	}
	else
	{
		if (can_i_go_back == 0)
			flag = 1;
		else
		{
			west(x, y+1);
		}
	}
	if (flag == 1)
		return;
}
void north(int x, int y)
{
	if (flag == 1)
		return;
	if (check[x][y] != 1 && map[x][y] != 1)
	{
		result++;
		check[x][y] = 1;
	}
	int dx[4] = { 0,1,0,-1 };
	int dy[4] = { -1,0,1,0 };
	int dir = -1;//¼­ ³² µ¿ ºÏ
	int possible_go = 0;
	int can_i_go_back = 1;
	if (map[x + 1][y] == 1)
		can_i_go_back = 0;//ÈÄÁøÁ¶Â÷ ¾ÈµÊ
	for (int i = 0; i < 4; i++)
	{
		dir++;
		int newx = x + dx[i];
		int newy = y + dy[i];
		if ((-1 < newx && newx < n) && (-1 < newy && newy < m) && (map[newx][newy] == 0) && (check[newx][newy] == 0))
		{
			possible_go = 1;
			break;
		}
	}

	if (possible_go == 1)
	{
		switch (dir)
		{
		case 0: west(x, y - 1); break;
		case 1: south(x + 1, y); break;
		case 2: east(x, y + 1); break;
		case 3: north(x - 1, y); break;
		default:
			break;
		}
	}
	else
	{
		if (can_i_go_back == 0)
			flag = 1;
		else
		{
			north(x + 1, y);
		}
	}
	if (flag == 1)
		return;
	
}