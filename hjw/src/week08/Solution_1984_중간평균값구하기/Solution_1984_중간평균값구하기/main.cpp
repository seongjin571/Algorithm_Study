#include <cstdio>
#include <algorithm>
#include <vector>

using namespace std;

int main()
{
	int test;
	scanf("%d", &test);

	for (int i = 1; i <= test; i++)
	{
		vector<int>vc;
		int result = 0;
		for (int j = 0; j < 10; j++)
		{
			int n;
			scanf("%d", &n);
			vc.push_back(n);
		}
		sort(vc.begin(), vc.end());
		vc.pop_back();
		double temp = 0;
		for (int i = 1; i < 9; i++)
			temp += vc.at(i);
		temp = temp / 8.0;
		if (temp + 0.5 >= (int)temp + 1)
			temp = (int)temp + 1;
		else
			temp = (int)temp;
		printf("#%d %d\n", i, (int)temp);
	}
}
