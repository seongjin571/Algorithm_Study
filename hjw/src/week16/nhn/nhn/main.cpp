#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;
/*
struct info {
	string str;
	int num;
};
vector <string> vc;
vector <info>res;
bool cmp(const info &p1, const info &p2)
{
	if (p1.num > p2.num)
		return true;
	else if (p1.num == p2.num) {
		return p1.str < p2.str;
	}
	else
		return false;
}
int main()
{
	int n;
	cin >> n;
	string str;
	for (int i = 0; i < n; i++)
	{
		cin >> str;
		vc.push_back(str);
	}
	
	for (int i = 0; i < vc.size(); i++)
	{
		int flag = 0;
		for (int j = 0; j < res.size(); j++)
		{
			if (vc[i] == res[j].str)//같은것이 있을 경우
			{
				flag = 1;
				res[j].num = res[j].num + 1;
			}
		}
		if (flag == 0)
			res.push_back({ vc[i],1 });
	}

	sort(res.begin(), res.end(), cmp);

	int max = res[0].num;
	int flag = 0;
	for (auto i : res)
	{
		if (max > i.num && flag == 0)
		{
			if (max == i.num + 1)
			{
				flag = 1;
			}
			else
			{
				flag = 2;
				break;
			}
		}
		else if (max > i.num && flag == 1)
		{
			flag = 2;
			break;
		}
		else if (max == i.num)
			continue;
	}

	if (flag == 2)
	{
		cout << "N" << endl << n << endl << res.size();
	}
	else {
		cout << "Y" << endl << n + flag << endl << res.size();
	}

}
*/
/*
vector<int>vc;
vector<int>res;
int arr[101];
void init()
{
	for (int i = 0; i < 101; i++)
	{
		arr[i] = 0;
	}
}
int func()
{
	for (int i = 0; i < vc.size(); i++)
	{
		arr[vc[i]]++;
	}
	int max = 0;
	int return_index = 0;
	for (int i = 0; i < 10; i++)
	{
		if (max < arr[i])
		{
			max = arr[i];
			return_index = i;
		}
	}
	return return_index;
}
int main()
{
	int n;
	cin >> n;
	string str;
	for (int i = 0; i < n; i++)
	{
		cin >> str;
		if (str == "enqueue")
		{
			int num;
			cin >> num;
			vc.push_back(num);
		}
		else if (str == "dequeue")
		{
			if (vc.size() == 0)
			{
				cout << -1;
			}
			else
			{
				init();
				int max = func();
				for (int j = 0; j < vc.size(); j++)
				{
					if (vc[j] == max)
					{
						res.push_back(vc[j]);
						vc.erase(vc.begin() + j);
						break;
					}
				}
			}
		}
	}
	for (auto i : res)
		cout << i << endl;
}
*/