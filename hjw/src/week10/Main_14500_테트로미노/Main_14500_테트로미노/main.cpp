/*�������̳�� ũ�Ⱑ 1��1�� ���簢���� ���� �� �̾ ���� �����̸�, ������ ���� ������ �����ؾ� �Ѵ�.

���簢���� ���� ��ġ�� �� �ȴ�.
������ ��� ����Ǿ� �־�� �Ѵ�.
���簢���� ������ ����Ǿ� �־�� �Ѵ�. ��, �������� �������� �´�� ������ �� �ȴ�.
���簢�� 4���� �̾� ���� �������̳�� ��Ʈ�ι̳��� �ϸ�, ������ ���� 5������ �ִ�.



�Ƹ��̴� ũ�Ⱑ N��M�� ���� ���� ��Ʈ�ι̳� �ϳ��� �������� �Ѵ�. ���̴� 1��1 ũ���� ĭ���� �������� ������, ������ ĭ���� ������ �ϳ� ���� �ִ�.

��Ʈ�ι̳� �ϳ��� ������ ���Ƽ� ��Ʈ�ι̳밡 ���� ĭ�� ���� �ִ� ������ ���� �ִ�� �ϴ� ���α׷��� �ۼ��Ͻÿ�.

��Ʈ�ι̳�� �ݵ�� �� ���簢���� ��Ȯ�� �ϳ��� ĭ�� �����ϵ��� ���ƾ� �ϸ�, ȸ���̳� ��Ī�� ���ѵ� �ȴ�.

�Է�
ù° �ٿ� ������ ���� ũ�� N�� ���� ũ�� M�� �־�����. (4 �� N, M �� 500)

��° �ٺ��� N���� �ٿ� ���̿� ���� �ִ� ���� �־�����. i��° ���� j��° ���� ���������� i��° ĭ, ���ʿ������� j��° ĭ�� ���� �ִ� ���̴�. �Է����� �־����� ���� 1,000�� ���� �ʴ� �ڿ����̴�.

���
ù° �ٿ� ��Ʈ�ι̳밡 ���� ĭ�� ���� ������ ���� �ִ��� ����Ѵ�.*/
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
	if (y + 2 < m)//�� ��
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
	if (x + 2 < n)// �� ��
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