#include <iostream>

using namespace std;

int main()
{
	int test;
	cin >> test;

	for (int t = 1; t <= test; t++)
	{
		int result = 0;
		for (int i = 0; i < 5; i++)
		{
			int n;
			cin >> n;
			if (n < 40)
				n = 40;
			result += n;
		}
		printf("#%d %d\n", t, result / 5);
	}
}