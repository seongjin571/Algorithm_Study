#include <cstdio>
#include <vector>
#include <iostream>
#include <stack>
#include <algorithm>
using namespace std;

int money;
int change;
int vc[7];
char res[7];

void cal(int z, int money, int change)
{
	int i = -1;
	stack<int>rvc;
	vector<int>sample;
	while (1)
	{
		rvc.push(money % 10);
		money = money / 10;
		if (money == 0)
			break;
	}
	while (!rvc.empty())
	{
		i++;
		int n = rvc.top();
		vc[i] = n;
		sample.push_back(n);
		rvc.pop();
	}
	sort(sample.begin(), sample.end());

	for (int j = 0; j <= i; j++)
		res[j] = -1;
	for (int a = change - 1; a >= 0; a--)
	{
		int small;
		int big;
		small = sample.at(a);
		big = sample.at(sample.size() - a-1);
		
		res[a] = small;
		res[i - a] = big;
		for(int j=0;j<=i;j++)
	}

	printf("#%d ", z);
	for (int j = 0; j <= i; j++)
		printf("%d", vc[j]);
	printf("\n");
		
}
int main()
{
	int test;
	scanf("%d", &test);

	for (int z = 1; z <= test; z++)
	{
		cin >> money >> change;
		cal(z,money, change);
	}
}
