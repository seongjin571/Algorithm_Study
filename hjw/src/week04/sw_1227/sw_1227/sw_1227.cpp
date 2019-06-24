#include <iostream>
#include <queue>
#include <string.h>
/*
using namespace std;
int map[16][16];
int check[16][16];
char fir[16][16];
int dx[4] = { 0,-1,0,1 };
int dy[4] = { -1,0,1,0 };
int flag = 0;//도착여부 판단
void bfs(int x, int y)
{
	if (map[x][y] == 3)
	{
		flag = 1;
	}

	queue<int> que;//que선언
	que.push(x);//que에 x 값 넣기
	que.push(y);
	check[x][y] = 1;//방문처리

	while (!que.empty())//que가 비어있지 않을 동안 반복문 돌기
	{
		int xx = que.front();
		que.pop();
		int yy = que.front();
		que.pop();

		for (int k = 0; k < 4; k++)//dxdy이용 순회
		{
			int newx = xx + dx[k];
			int newy = yy + dy[k];
			if ((-1 < newx && newx < 16) && (-1 < newy && newy < 16) && (check[newx][newy] == 0)&&(map[newx][newy] != 1))
			{
				que.push(newx);
				que.push(newy);
				check[newx][newy] = 1;
			}
		}
	}
}
int main()
{
	int count = 1;
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
				if (count == 1)//처음 시작지점 찾기
				{
					if (map[j][k] == 2 && check[j][k] == 0)
					{
						count++;
						bfs(j, k);
					}
				}
				else
				{
					if (check[j][k] == 0 && map[j][k] != 1)//두번째 이후
						bfs(j, k);
				}
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
		count = 1;
	}
}
*/
#include <iostream>
#include <string.h>
using namespace std;
int map[100][100];
int check[100][100];
char fir[100][100];
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
		if ((-1 < newx && newx < 100) && (-1 < newy&&newy < 100) && (check[newx][newy] == 0) && (map[newx][newy] != 1))
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
		for (int a = 0; a < 100; a++)
		{
			for (int b = 0; b < 100; b++)
			{
				cin >> fir[a][b];//map값 입력
				map[a][b] = fir[a][b] - '0';
			}
		}
		for (int c = 0; c < 100; c++)
		{
			memset(check[c], 0, sizeof(int) * 100);//check배열 초기화
		}



		for (int j = 0; j < 100; j++)//탐색
		{
			for (int k = 0; k < 100; k++)
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