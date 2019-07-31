#include <cstdio>
#include <cmath>
#include <vector>
#include <iostream>
using namespace std;
int arr[1111];

int main()
{
	int test;
	scanf("%d", &test);

	for (int z = 1; z <= test; z++)
	{
		vector<int> vc;
		int kk;
		scanf("%d", &kk);
		double kkk = (pow(2, kk) - 1);
		int k = int(kkk); 
		for (int i = 0; i < k; i++)
		{
			int n;
			scanf("%d", &n);
			vc.push_back(n);
		}
		int mid = (1 + k) / 2 -1;
		int cnt = 0;
		int idx = 1;
		while (cnt < k)
		{
			if (cnt == 0)
			{
				int a = vc.at(mid);
				arr[1] = a;
				idx = idx * 2;
			}
			else
			{

			}


			cnt++;
		}

	}
}