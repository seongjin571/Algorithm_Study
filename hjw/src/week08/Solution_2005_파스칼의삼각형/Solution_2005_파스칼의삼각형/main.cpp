#include <cstdio>

int map[11][11];
using namespace std;
void pas(int x)
{
	if (x == 1)
	{
		map[0][0] = 1;
		return;
	}
	if (x == 2)
	{
		for (int i = 0; i < x; i++)
		{
			map[i][0] = 1;
		}
		map[1][1] = 1;
		return;
	}
	else
	{
		for (int i = 0; i < x; i++)
			map[i][0] = 1;
		for (int i = 0; i < x; i++)
		{
			map[i][i] = 1;
		}
		for (int i = 1; i < x; i++)
		{
			for (int j = 1; j < i; j++)
			{
				map[i][j] = map[i - 1][j - 1] + map[i - 1][j];
			}
		}
		return;
	}
}
int main()
{
	int test_case;
	scanf("%d", &test_case);

	for (int i = 1; i <= test_case; i++)
	{
		int n;
		scanf("%d", &n);
		pas(n);
		printf("#%d\n", i);
		for (int a = 0; a < n; a++)
		{
			for (int b = 0; b <= a; b++)
			{
				printf("%d ", map[a][b]);
			}
			printf("\n");
		}
	}
}