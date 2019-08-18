#include <cstdio>

using namespace std;
int n, m, r;
int map[301][301];
int cnt;
void change(int inner_rec)
{
	int temp;
	temp = map[inner_rec][inner_rec];
	for (int i = inner_rec; i < (m - 1) - (cnt); i++)
	{
		map[inner_rec][i] = map[inner_rec][i + 1];
	}

	for (int i = inner_rec; i < (n-1)-(cnt); i++)
	{
		map[i][(m - 1) - (cnt)] = map[i + 1][(m - 1) - (cnt)];
	}

	for (int i = (m - 1) - (cnt); i > inner_rec; i--)
	{
		map[(n - 1) - (cnt)][i] = map[(n - 1) - (cnt)][i - 1];
	}

	for (int i = (n - 1) - (cnt); i > inner_rec; i--)
	{
		map[i][inner_rec] = map[i - 1][inner_rec];
	}
	map[inner_rec + 1][inner_rec] = temp;
}
int main()
{
	scanf("%d %d %d", &n, &m, &r);

	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
		{
			scanf("%d", &map[i][j]);
		}
	}

	cnt = 0;
	int small_num;
	if (n > m)
		small_num = m;
	else
		small_num = n;
	
	small_num = small_num / 2;

	for (int i = 0; i < r; i++)
	{
		for (int j = 0; j < small_num; j++)
		{
			change(j);
			cnt++;
		}
		cnt = 0;
	}

	for (int k = 0; k < n; k++)
	{
		for (int z = 0; z < m; z++)
		{
			printf("%d ", map[k][z]);
		}
		printf("\n");
	}
	
}

/*t = 0;
	int temp1;
	temp1 = map[t][t];
	for (int i = t; i < n-1; i++)//À­ÁÙ ÇÑÄ­¾¿ ¿ÞÂÊ
	{
		map[t][i] = map[t][i + 1];// - - - x
	}
	
	for (int i = 0; i < m - 1;i++)//¿À¸¥ÂÊ ÁÙ ÇÑÄ­¾¿ À§·Î
	{
		map[i][m - 1] = map[i + 1][m - 1];
		// -
		// -
		// -
		// x
	}

	for (int i = m - 1; i > 0; i--)//¸Ç ¾Æ·§ÁÙ ÇÑÄ­¾¿ ¿À¸¥ÂÊ ÀÌµ¿
	{
		map[n-1][i] = map[n-1][i - 1];// x - - -
	}

	for (int i = n - 1; i > 0; i--)
	{
		map[i][t] = map[i - 1][t];
	}
	map[t + 1][0] = temp1;*/
/*
#include <cstdio>

using namespace std;
int n, m, r;
int map[301][301];
int result_map[301][301];
void rotation(int inner_rec)
{
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
		{
			if (i - r < 0)
			{

			}
		}
	}
}
int main()
{
	scanf("%d %d %d", &n, &m, &r);

	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
		{
			scanf("%d", &map[i][j]);
		}
	}

	int small_rec;

	if (n > m)
		small_rec = m;
	else
		small_rec = n;

	for (int i = 0; i < small_rec; i++)
	{
		rotation(i);
	}
}
*/