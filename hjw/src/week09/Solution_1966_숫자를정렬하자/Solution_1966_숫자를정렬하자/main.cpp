#include <cstdio>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{
	int test;
	scanf("%d", &test);
	vector<int>vc;
	for (int i = 0; i < test; i++)
	{
		int n;
		scanf("%d", &n);
		
		for (int j = 0; j < n; j++)
		{
			int m;
			scanf("%d", &m);
			vc.push_back(m);
		}
		sort(vc.begin(), vc.end());
		printf("#%d ", i+1);
		for (auto a : vc)
			printf("%d ", a);
		printf("\n");
		vc.clear();
	}
}