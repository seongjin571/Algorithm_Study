#include <cstdio>
#include <cstdlib>
#include <vector>
#include<iostream>
#include <fstream>
using namespace std;

vector<int>vc;
int main()
{
	//ifstream inf("C:\\Users\\admin\\Downloads\\input.txt");
	int t;
	scanf("%d", &t);
	//inf >> t;
	for (int z = 1; z <= t; z++)
	{
		int people;
		//inf >> people;
		scanf("%d", &people);
		int min = 100000;
		int cnt = 0;

		for (int i = 0; i < people; i++)
		{
			int l;
			//inf >> l;
			scanf("%d", &l);
			vc.push_back(l);
			int temp;
			temp = abs(0 - l);
			//printf("%d", temp);
			if (temp < min)
				min = temp;

		}

		for (auto i : vc)
		{
			if (abs(0-i) == min)
				cnt++;
		}
		printf("#%d %d %d\n", z,min, cnt);
		vc.clear();
	}
}