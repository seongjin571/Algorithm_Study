#include <cstdio>
#include <vector>
#include <fstream>
#include <iostream>
using namespace std;

int main()
{
	int test;
	//ifstream inf("C:\\Users\\admin\\Downloads\\input.txt");
	scanf("%d", &test);
	//inf >> test;
	for (int z = 1; z <= test; z++)
	{
		int a, b;
		//inf >> a >> b;
		scanf("%d %d", &a, &b);
		vector<int>va;
		vector<int>vb;
		if (a < b)
		{
			for (int i = 0; i < a; i++)
			{
				int n;
				//inf >> n;
				scanf("%d", &n);
				va.push_back(n);
			}
			for (int i = 0; i < b; i++)
			{
				int n;
				//inf >> n;
				scanf("%d", &n);
				vb.push_back(n);
			}
			int result = 0;
			int max = -1000;
			int dif = b - a + 1;
			for (int i = 0; i < dif; i++)
			{
				int idx = i;
				for (int j = 0; j < va.size(); j++)
				{
					result += va.at(j)*vb.at(idx);
					idx++;
				}
				if (result > max)
					max = result;
				result = 0;
			}
			printf("#%d %d\n", z, max);
			va.clear();
			vb.clear();
		}
		else
		{
			for (int i = 0; i < a; i++)
			{
				int n;
				//inf >> n;
				scanf("%d", &n);
				va.push_back(n);
			}
			for (int i = 0; i < b; i++)
			{
				int n;
				//inf >> n;
				scanf("%d", &n);
				vb.push_back(n);
			}
			int result = 0;
			int max = -1000;
			int dif = a-b + 1;
			for (int i = 0; i < dif; i++)
			{
				int idx = i;
				for (int j = 0; j < vb.size(); j++)
				{
					result += vb.at(j)*va.at(idx);
					idx++;
				}
				if (result > max)
					max = result;
				result = 0;
			}
			printf("#%d %d\n", z, max);
			va.clear();
			vb.clear();
		}
		
	}
}