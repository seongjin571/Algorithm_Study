#include <cstdio>
#include <vector>
#include <algorithm>
using namespace std;

int arr[41];
void init()
{
	for (int i = 0; i < 41; i++)
		arr[i] = 0;
}
int main()
{
	int test;
	scanf("%d", &test);

	for (int t = 1; t <= test; t++)
	{
		int n, m;
		scanf("%d %d", &n, &m);
		vector<int> vc;
		init();
		for (int i = 0; i <= n; i++)
		{
			for (int j = 0; j <= m; j++)
			{
				arr[i + j]++;
			}
		}
		int mx = -1;
		for (int i = 0; i < 41; i++)
		{
			if (mx < arr[i])
				mx = arr[i];
		}
		
		for (int i = 0; i < 41; i++)
		{
			if (mx == arr[i])
			{
				vc.push_back(i + 1);
			}
		}
		sort(vc.begin(), vc.end());
		printf("#%d ", t);
		for (auto i : vc)
			printf("%d ", i);
		printf("\n");
		vc.clear();
		//printf("#%d %d\n", t, mx);
	}
}