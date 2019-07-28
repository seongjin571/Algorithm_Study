#include <cstdio>

using namespace std;
int arr[10];
int n;
void init()
{
	for (int i = 0; i < 10; i++)
		arr[i] = 0;
}
int func()
{
	int flag = 0;
	int mul = 1;
	int temp;
	int cnt = 0;
	while (1)
	{
		flag = 0;
		temp = n*mul;
		while (1)
		{
			arr[temp % 10] = -1;
			temp = temp / 10;
			if (temp == 0)
				break;
		}
		cnt++;
		mul++;
		for (int i = 0; i < 10; i++)
		{
			if (arr[i] != -1)
			{
				flag = 1;
				break;
			}
		}
		if (flag == 0)
			break;
	}
	return cnt;
}
int main()
{
	int test;
	scanf("%d", &test);

	for (int z = 1; z <= test; z++)
	{
		init();
		scanf("%d", &n);
		int result = 0;
		result = func();

		printf("#%d %d\n", z, n*result);
	}
}