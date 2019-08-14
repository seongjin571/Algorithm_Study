#include <cstdio>
#include <iostream>
#include <vector>

using namespace std;

int main()
{
	int test;
	cin >> test;

	for (int t = 1; t <= test; t++)
	{
		int n1, n2, n3;
		cin >> n1 >> n2 >> n3;
		printf("#%d ", t);
		if (n1 == n2)
		{
			if (n1 == n3)
			{
				printf("%d\n", n1);
			}
			else
			{
				printf("%d\n", n3);
			}
		}
		else
		{
			if (n2 == n3)
			{
				printf("%d\n", n1);
			}
			else
			{
				printf("%d\n", n2);
			}
		}
	}
}