/*폴리오미노란 크기가 1×1인 정사각형을 여러 개 이어서 붙인 도형이며, 다음과 같은 조건을 만족해야 한다.

정사각형은 서로 겹치면 안 된다.
도형은 모두 연결되어 있어야 한다.
정사각형의 변끼리 연결되어 있어야 한다. 즉, 꼭짓점과 꼭짓점만 맞닿아 있으면 안 된다.
정사각형 4개를 이어 붙인 폴리오미노는 테트로미노라고 하며, 다음과 같은 5가지가 있다.



아름이는 크기가 N×M인 종이 위에 테트로미노 하나를 놓으려고 한다. 종이는 1×1 크기의 칸으로 나누어져 있으며, 각각의 칸에는 정수가 하나 쓰여 있다.

테트로미노 하나를 적절히 놓아서 테트로미노가 놓인 칸에 쓰여 있는 수들의 합을 최대로 하는 프로그램을 작성하시오.

테트로미노는 반드시 한 정사각형이 정확히 하나의 칸을 포함하도록 놓아야 하며, 회전이나 대칭을 시켜도 된다.

입력
첫째 줄에 종이의 세로 크기 N과 가로 크기 M이 주어진다. (4 ≤ N, M ≤ 500)

둘째 줄부터 N개의 줄에 종이에 쓰여 있는 수가 주어진다. i번째 줄의 j번째 수는 위에서부터 i번째 칸, 왼쪽에서부터 j번째 칸에 쓰여 있는 수이다. 입력으로 주어지는 수는 1,000을 넘지 않는 자연수이다.

출력
첫째 줄에 테트로미노가 놓인 칸에 쓰인 수들의 합의 최댓값을 출력한다.*/
#include <cstdio>
#include <vector>
using namespace std;
int n, m;
int map[500][500];
int dx[4] = { 0,1,0,-1 };
int dy[4] = { 1,0,-1,0 };

int check[500][500];
int result;
int cnt;

void dfs(int x, int y, int num, int cnt)
{
	//printf("%d %d\n", x, y);
	
	cnt += map[x][y];
	if (num == 0)
	{
		if (result < cnt)
			result = cnt;
		return;
	}

	for (int i = 0; i < 4; i++)
	{
		int newx = x + dx[i];
		int newy = y + dy[i];
		if ((-1 < newx && newx < n) && (-1 < newy && newy < m) && (num > 0) && (check[newx][newy] == 0))
		{
			check[newx][newy] = 1;
			dfs(newx, newy, num - 1, cnt);
			check[newx][newy] = 0;
		}
	}
	
}
void ex(int x, int y, int cnt)
{
	cnt += map[x][y];
	int temp = cnt;
	if (y + 2 < m)//ㅗ ㅜ
	{
		for (int i = 1; i < 3; i++)
		{
			temp += map[x][y + i];
		}
		for (int i = 0; i < 2; i++)
		{
			if (-1 < x - 1)
			{
				int temp2 = temp;
				temp2 += map[x - 1][y+1];
				if (temp2 > result)
					result = temp2;
			}

			if (x + 1 < n)
			{
				int temp2 = temp;
				temp2 += map[x + 1][y+1];
				if (temp2 > result)
					result = temp2;
			}
		}
	}

	int temp3 = cnt;
	if (x + 2 < n)// ㅓ ㅏ
	{
		for (int i = 1; i < 3; i++)
		{
			temp3 += map[x + i][y];
		}
		for (int i = 0; i < 2; i++)
		{
			if (-1 < y - 1)
			{
				int temp2 = temp3;
				temp2 += map[x+1][y-1];
				if (temp2 > result)
					result = temp2;
			}

			if (y + 1 < m)
			{
				int temp2 = temp3;
				temp2 += map[x+1][y+1];
				if (temp2 > result)
					result = temp2;
			}
		}
	}
}
int main()
{
	scanf("%d %d", &n, &m);
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
		{
			scanf("%d", &map[i][j]);
		}
	}
	result = 0;
	
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
		{
			cnt = 0;
			check[i][j] = 1;
			dfs(i, j,3,cnt);
			check[i][j] = 0;
			cnt = 0;
			ex(i, j,cnt);
			
		}
	}
	
	printf("%d", result);
}