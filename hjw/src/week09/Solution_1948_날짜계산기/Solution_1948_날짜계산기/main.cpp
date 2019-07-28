#include <cstdio>

using namespace std;
int res1;
int res2;
void cal(int m1, int m2)
{
	res1 = 0;
	res2 = 0;
	res1 = m1 - 1;
	res2 = m2 - 1;
	switch (res1)
	{
	case 0:
		res1 = 0;
		break;
	case 1:
		res1 = 31;
		break;
	case 2:
		res1 = 31+28;
		break;
	case 3:
		res1 = 31+28+31;
		break;
	case 4:
		res1 = 31+28+31+30;
		break;
	case 5:
		res1 = 31+28+31+30+31;
		break;
	case 6:
		res1 = 31 + 28 + 31 + 30 + 31+30;
		break;
	case 7:
		res1 = 31 + 28 + 31 + 30 + 31+30+31;
		break;
	case 8:
		res1 = 31 + 28 + 31 + 30 + 31+30+31+31;
		break;
	case 9:
		res1 = 31 + 28 + 31 + 30 + 31+30+31+31+30;
		break;
	case 10:
		res1 = 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30+31;
		break;
	case 11:
		res1 = 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30+31+30;
		break;
	}

	switch (res2)
	{
	case 0:
		res2 = 0;
		break;
	case 1:
		res2 = 31;
		break;
	case 2:
		res2 = 31 + 28;
		break;
	case 3:
		res2 = 31 + 28 + 31;
		break;
	case 4:
		res2 = 31 + 28 + 31 + 30;
		break;
	case 5:
		res2 = 31 + 28 + 31 + 30 + 31;
		break;
	case 6:
		res2 = 31 + 28 + 31 + 30 + 31 + 30;
		break;
	case 7:
		res2 = 31 + 28 + 31 + 30 + 31 + 30 + 31;
		break;
	case 8:
		res2 = 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31;
		break;
	case 9:
		res2 = 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30;
		break;
	case 10:
		res2 = 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31;
		break;
	case 11:
		res2 = 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + 30;
		break;
	}
}
int main()
{
	int test;
	scanf("%d", &test);

	for (int z = 1; z <= test; z++)
	{
		int m1, m2, d1, d2;
		scanf("%d %d %d %d", &m1, &d1, &m2, &d2);
		cal(m1, m2);
		res1 = res1 + d1;
		res2 = res2 + d2;
		int result = res2 - res1 + 1;
		printf("#%d %d\n",z, result);
	}
}