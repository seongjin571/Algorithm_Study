#include <cstdio>

using namespace std;
int map[16][16];
int main()
{
	int test_case;
	scanf("%d", &test_case);

	for (int i = 1; i <= test_case; i++)
	{
		int n,m;
		scanf("%d %d", &n, &m);
		int max = 0;
		int temp = 0;
		for (int a = 0; a < n; a++)
		{
			for (int b = 0; b < n; b++)
			{
				scanf("%d", &map[a][b]);
			}
		}

		for (int a = 0; a < n; a++)
		{
			for (int b = 0; b < n; b++)
			{
				for (int j = 0; j < m; j++)
				{
					for (int k = 0; k < m; k++)
					{
						temp += map[a+j][b+k];
					}
				}
				if (temp > max)
					max = temp;
				temp = 0;
			}
		}

		printf("#%d %d\n", i, max);
	}
}