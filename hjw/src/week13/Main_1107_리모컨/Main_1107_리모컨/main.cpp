#include <iostream>
#include <string>
#include <vector>
#include <cmath>
using namespace std;
string strn;
vector<int>vc;
int n, m;
int arr[11];
int now = 100;
int number;
int result;
int make_int_n()
{
	int num = 0;
	for (int i = 0; i < strn.size(); i++)
	{
		num = num * 10;
		num += strn.at(i) - '0';
	}
	
	return num;
}
int just_go()
{
	int temp = now - n;
	int result = abs(temp);
	return result;
}
int cal()
{
	int min= 10000000;
	for (int i = 0; i < vc.size(); i++)
	{
		if (min > abs(n - vc.at(i)))
		{
			min = abs(n - vc.at(i));
			result = vc.at(i);
		}
	}
	return min;
}
void find_num()
{
	for (int i = 0; i < 1000001; i++)
	{
		int num = 0;
		int j = i;
		int flag = 0;
		while (1)
		{
			if (arr[j % 10] == 1)
			{
				flag = 1;
				break;
			}
			num *= 10;
			num += j % 10;
			j = j / 10;
			if (j == 0)
				break;
		}
		if (flag == 0)
			vc.push_back(i);
	}
}
int main()
{
	cin >> strn;
	cin >> m;
	for (int i = 0; i < m; i++)
	{
		int idx;
		cin >> idx;
		arr[idx] = 1;
	}
	n = make_int_n();
	if (m == 10)//모두 망가졌을 경우
	{
		printf("%d", just_go());
	}
	else
	{
		find_num();
		int res1 = cal();
		int cnt = 0;
		while (1)
		{
			result = result / 10;
			cnt++;
			if (result == 0)
				break;

		}
		res1 += cnt;
		int res2 = just_go();
		printf("%d",res1 > res2 ? res2 : res1);
	}
}