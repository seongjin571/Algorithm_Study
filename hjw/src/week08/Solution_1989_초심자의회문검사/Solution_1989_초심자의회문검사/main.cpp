#include <cstdio>
#include <string.h>
#include <vector>
using namespace std;

int main()
{
	int test;
	scanf("%d", &test);

	for (int i = 1; i <= test; i++)
	{
		char str[11];
		scanf("%s", str);
		int n = strlen(str);
		int flag = 1;
		for (int j = 0; j < n/2; j++)
		{
			if (str[j] != str[n - j-1])
			{
				flag = 0;
				break;
			}
		}
		printf("#%d %d\n", i, flag);
	}
}
