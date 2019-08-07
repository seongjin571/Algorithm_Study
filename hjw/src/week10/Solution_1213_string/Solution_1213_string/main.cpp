#include<cstdio>
#include <iostream>
#include <vector>
#include <string.h>
#include <string>
#include <fstream>
using namespace std;

int main()
{
	//ifstream inf("C:\\Users\\admin\\Downloads\\test_input.txt");
	for (int t = 1; t < 11; t++)
	{
		int test;
		cin >> test;
		//inf >> test;
		vector<char>svc;
		vector<char>lvc;

		string str;
		//inf >> str;
		cin >> str;
		for (int i = 0; i < str.size(); i++)
		{
			svc.push_back(str.at(i));
		}
		getchar();
		char c;
		//inf >> c;
		scanf("%c", &c);
		while (c != '\n')
		{
			lvc.push_back(c);
			//inf >> c;
			scanf("%c", &c);
		}
		
		int flag = 0;
		int cnt = 0;
		int len = svc.size();
		for (int i = 0; i <= lvc.size()-len; i++)
		{
			for (int j = 0; j < len; j++)
			{
				if (lvc.at(i+j) != svc.at(j))
				{
					flag = 1;
					break;
				}
			}
			if (flag == 0)
			{
				cnt++;
			}
			else
			{
				flag = 0;
			}
		}

		printf("#%d %d\n", test, cnt);
		
	}
}