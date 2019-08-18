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

	for (int i = inner_rec; i < (n - 1) - (cnt); i++)
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

	int temp;
	int tempr = r;
	for (int j = 0; j < small_num; j++)
	{
		temp = 2 * (n - j - j) + 2 * (m - j - j) - 4;
		//printf("%d\n", temp);
		tempr = r%temp;
		//printf("%d\n", r);
		for (int i = 0; i < tempr; i++)
		{
			change(j);
		}
		cnt++;
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
