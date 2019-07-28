#include <cstdio>
#include <iostream>
#include <fstream>
using namespace std;
int arr[101];
void init()
{
	for (int i = 0; i < 101; i++)
		arr[i] = 0;
}
int main()
{
	int t;
	//ifstream inf("C:\\Users\\admin\\Downloads\\input.txt");
	scanf("%d", &t);
	//inf >> t;
	for (int z = 1; z <= t; z++)
	{
		init();
		int test;
		scanf("%d", &test);
		//inf >> test;
		int n;
		int result = 0;
		for (int i = 0; i < 1000; i++)
		{
			int score;
			//inf >> score;
			scanf("%d", &score);
			arr[score]++;
		}
		int mx = 0;
		int idx = 0;
		for (int i = 0; i < 101; i++)
		{
			if (arr[i] >= mx)
			{
				mx = arr[i];
				idx = i;
			}
		}

		printf("#%d %d\n", test, idx);
	}
}