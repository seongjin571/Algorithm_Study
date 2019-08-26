//가로 -> 가로 or 대각  1
//세로 -> 세로 or 대각  2
//대각 -> 가로 or 세로 or 대각  3
#include <iostream>

using namespace std;

int map[18][18];
int check[18][18];
int n;
int result;
void func(int start_x, int start_y, int end_x, int end_y)
{
	if (end_x == n - 1 && end_y == n - 1)
	{
		result++;
		
		return;
	}

	if (check[end_x][end_y] == 1)//가로일때
	{
		int next_x = end_x;
		int next_y = end_y + 1;
		int origin_x = end_x;
		int origin_y = end_y;
		if ((-1 < next_x && next_x < n) && (-1 < next_y && next_y < n) && map[next_x][next_y] == 0 && check[next_x][next_y] == 0)//가로
		{
			//check[origin_x][origin_y] = 1;
			check[next_x][next_y] = 1;
			func(origin_x, origin_y, next_x, next_y);
			check[next_x][next_y] = 0;
			//check[origin_x][origin_y] = 0;
		}
		next_x = end_x + 1;
		next_y = end_y + 1;
		if ((-1 < next_x && next_x < n) && (-1 < next_y && next_y < n) && (map[next_x][next_y] == 0) && (map[origin_x][origin_y+1] == 0) && (map[origin_x+1][origin_y] == 0) && (check[next_x][next_y] == 0))//대각
		{
			//check[origin_x][origin_y] = 3;
			check[next_x][next_y] = 3;
			func(origin_x, origin_y, next_x, next_y);
			check[next_x][next_y] = 0;
			//check[origin_x][origin_y] = 0;
		}
	}
	else if (check[end_x][end_y] == 2)//세로일때
	{
		int next_x = end_x + 1;
		int next_y = end_y;
		int origin_x = end_x;
		int origin_y = end_y;
		if ((-1 < next_x && next_x < n) && (-1 < next_y && next_y < n) && map[next_x][next_y] == 0 && check[next_x][next_y] == 0)//가로
		{
			//check[origin_x][origin_y] = 2;
			check[next_x][next_y] = 2;
			func(origin_x, origin_y, next_x, next_y);
			check[next_x][next_y] = 0;
			//check[origin_x][origin_y] = 0;
		}
		next_x = end_x + 1;
		next_y = end_y + 1;
		if ((-1 < next_x && next_x < n) && (-1 < next_y && next_y < n) && (map[next_x][next_y] == 0) && (map[origin_x][origin_y + 1] == 0) && (map[origin_x + 1][origin_y] == 0) && (check[next_x][next_y] == 0))//대각
		{
			//check[origin_x][origin_y] = 3;
			check[next_x][next_y] = 3;
			func(origin_x, origin_y, next_x, next_y);
			check[next_x][next_y] = 0;
			//check[origin_x][origin_y] = 0;
		}
	}
	else if (check[end_x][end_y] == 3)//대각일때
	{
		int next_x = end_x;
		int next_y = end_y + 1;
		int origin_x = end_x;
		int origin_y = end_y;
		if ((-1 < next_x && next_x < n) && (-1 < next_y && next_y < n) && map[next_x][next_y] == 0 && check[next_x][next_y] == 0)//가로
		{
			//check[origin_x][origin_y] = 1;
			check[next_x][next_y] = 1;
			func(origin_x, origin_y, next_x, next_y);
			check[next_x][next_y] = 0;
			//check[origin_x][origin_y] = 0;
		}
		next_x = end_x + 1;
		next_y = end_y;
		if ((-1 < next_x && next_x < n) && (-1 < next_y && next_y < n) && (map[next_x][next_y] == 0) && (check[next_x][next_y] == 0))//세로
		{
			//check[origin_x][origin_y] = 2;
			check[next_x][next_y] = 2;
			func(origin_x, origin_y, next_x, next_y);
			check[next_x][next_y] = 0;
			//check[origin_x][origin_y] = 0;
		}
		next_x = end_x + 1;
		next_y = end_y + 1;
		if ((-1 < next_x && next_x < n) && (-1 < next_y && next_y < n) && (map[next_x][next_y] == 0) && (map[origin_x][origin_y + 1] == 0) && (map[origin_x + 1][origin_y] == 0) && (check[next_x][next_y] == 0))//대각
		{
			//check[origin_x][origin_y] = 3;
			check[next_x][next_y] = 3;
			func(origin_x, origin_y, next_x, next_y);
			check[next_x][next_y] = 0;
			//check[origin_x][origin_y] = 0;
		}
	}
}
int main()
{
	cin >> n;

	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < n; j++)
		{
			cin >> map[i][j];
		}
	}
	result = 0;
	check[0][0] = 1;
	check[0][1] = 1;
	func(0, 0, 0, 1);
	printf("%d", result);
}