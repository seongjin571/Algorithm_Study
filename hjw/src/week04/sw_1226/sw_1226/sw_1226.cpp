#include <iostream>
#include <string.h>
using namespace std;
int map[16][16];
int check[16][16];
char fir[16][16];
int dx[4] = { 0,-1,0,1 };
int dy[4] = { -1,0,1,0 };
int flag = 0;//도착여부 판단
void dfs(int x, int y)
{
	check[x][y] = 1;//방문처리
	if (map[x][y] == 3)//도착가능
	{
		flag = 1;
	}

	for (int i = 0; i < 4; i++)//dxdy돌리기
	{
		int newx = x + dx[i];
		int newy = y + dy[i];
		if ((-1 < newx && newx < 16) && (-1 < newy&&newy < 16) && (check[newx][newy] == 0) && (map[newx][newy] != 1))
		{
			dfs(newx, newy);
		}
	}
}
int main()
{
	int n;//첫 입력 테스트케이스 순서
	for (int i = 1; i <= 10; i++)
	{
		cin >> n;
		for (int a = 0; a < 16; a++)
		{
			for (int b = 0; b < 16; b++)
			{
				cin >> fir[a][b];//map값 입력
				map[a][b] = fir[a][b] - '0';
			}
		}
		for (int c = 0; c < 16; c++)
		{
			memset(check[c], 0, sizeof(int) * 16);//check배열 초기화
		}
		


		for (int j = 0; j < 16; j++)//탐색
		{
			for (int k = 0; k < 16; k++)
			{
				if (map[j][k] == 2)
					dfs(j, k);
			}
		}
		if (flag == 1)
		{
			cout << "#" << i << " " << 1 << endl;
		}
		else
		{
			cout << "#" << i << " " << 0 << endl;
		}
		flag = 0;
	}
}