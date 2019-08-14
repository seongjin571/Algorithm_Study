#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> vc;
int map[100][100];
int main()
{
	int test;
	for (int i = 1; i < 11; i++)
	{
		cin >> test;
		for (int i = 0; i < 100; i++)
		{
			for (int j = 0; j < 100; j++)
			{
				cin >> map[i][j];
			}
		}
		int sum = 0;
		for (int i = 0; i < 100; i++)//За
		{
			for (int j = 0; j < 100; j++)
			{
				sum += map[i][j];
			}
			vc.push_back(sum);
			sum = 0;
		}

		for (int j = 0; j < 100; j++)//ї­
		{
			for (int i = 0; i < 100; i++)
			{
				sum += map[i][j];
			}
			vc.push_back(sum);
			sum = 0;
		}

		for (int i = 0; i < 100; i++)
		{
			sum += map[i][i];
		}
		vc.push_back(sum);
		sum = 0;

		for (int i = 0; i < 100; i++)
		{
			sum += map[99 - i][i];
		}
		vc.push_back(sum);
		sum = 0;

		sort(vc.begin(), vc.end());
		printf("#%d %d\n", test,vc.back());
		vc.clear();
	}
}