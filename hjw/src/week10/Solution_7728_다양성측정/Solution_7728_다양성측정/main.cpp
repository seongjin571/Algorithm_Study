#include <cstdio>

using namespace std;
int arr[10];
void func(int n)
{
	while (1)
	{
		arr[n % 10] = 1;
		n = n / 10;

		if (n == 0)
			break;
	}
}
int main()
{
	int test;
	scanf("%d", &test);
	int cnt;
	for (int t = 1; t <= test; t++)
	{
		for (int i = 0; i < 10; i++)
			arr[i] = 0;
		cnt = 0;
		int n;
		scanf("%d", &n);
		func(n);
		
		for (int i = 0; i < 10; i++)
		{
			if (arr[i] == 1)
				cnt++;
		}
		printf("#%d %d\n", t, cnt);
	}
}