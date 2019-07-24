#include <cstdio>
#include <vector>
using namespace std;
void cal(int x)
{
	int n,m=0;
	int temp = x;
	vector<int>vc;
	while (1)
	{
		int n = temp % 10;
		vc.push_back(n);
		temp = temp / 10;
		if (temp == 0)
			break;
	}
	for (auto i : vc)
	{
		int a = i;
		if (i == 3 || i == 6 || i == 9)
			m++;
	}
	if (m > 0)
	{
		for (int i = 0; i < m; i++)
			printf("-");
		printf(" ");
	}
	else
		printf("%d ", x);
}
int main()
{
	int n;
	scanf("%d", &n);

	for (int i = 1; i <= n; i++)
	{
		if (i < 10)
		{
			if (i == 3 || i == 6 || i == 9)
			{
				printf("- ");
			}
			else
			{
				printf("%d ", i);
			}
		}
		else
		{
			cal(i);
		}
	}
}
