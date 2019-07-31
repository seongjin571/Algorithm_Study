#include <cstdio>
#include <vector>
#include <string.h>
#include <string>
#include <iostream>
using namespace std;


vector<int>vc;
vector<int>temp;
int cnt;
int func()
{
	int flag = 0;
	for (int i = 0; i < vc.size(); i++)
	{
		if (temp.at(i) != vc.at(i))
		{
			cnt++;
			for (int j = i; j < vc.size(); j++)
			{
				temp.at(j) = vc.at(i);
			}
		}

		for (int j = 0; j < vc.size(); j++)
		{
			if (vc.at(j) != temp.at(j))
			{
				flag = 1;
				break;
			}
		}
		if (flag == 0)
			break;
	}
	return cnt;
}
int main()
{
	int test;
	scanf("%d", &test);

	for (int t = 1; t <= test; t++)
	{
		string str;
		cin >> str;
		cnt = 0;
		for (int i = 0; i < str.size(); i++)
		{
			int num = str.at(i) - '0';
			vc.push_back(num);
		}
		for (int i = 0; i < vc.size(); i++)
		{
			temp.push_back(0);
		}
		int result = 0;
		result = func();

		printf("#%d %d\n", t, result);
	}
}