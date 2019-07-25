#include <cstdio>

using namespace std;

int main()
{
	int test;
	scanf("%d", &test);

	for (int a = 1; a <= test; a++)
	{
		int t1, t2, m1, m2;
		scanf("%d %d %d %d", &t1, &m1, &t2, &m2);
		int time_res, min_res;
		time_res = t1 + t2;
		min_res = m1 + m2;
		if (min_res >= 60)
		{
			min_res = min_res - 60;
			time_res++;
		}
		if (time_res > 12)
		{
			time_res = time_res - 12;
		}

		printf("#%d %d %d\n", a, time_res, min_res);
	}
}