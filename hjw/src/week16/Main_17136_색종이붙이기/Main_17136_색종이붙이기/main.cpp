#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;
int arr[6] = { 0,5,5,5,5,5 };
vector<vector<int> > map(10, vector<int>(10, 0));
int cnt, result;

void go(int x, int y)
{
	if (y == 10)
	{
		go(x + 1, 0);
		return;
	}

	if (x == 10)
	{
		result = min(result, cnt);
		return;
	}

	if (map[x][y] == 0)
	{
		go(x, y+1);
		return;
	}

	for (int len = 5; len >= 1; len--)
	{
		if (arr[len] == 0 || x + len > 10 || y + len > 10)
		{
			continue;
		}

		bool flag = true;

		for (int i = 0; i < len; i++)
		{
			for (int j = 0; j < len; j++)
			{
				if (map[x + i][y + j] == 0)
				{
					flag = false;
					break;
				}
			}
			if (flag == false)
				break;
		}

		if (flag == false)
			continue;

		for (int i = 0; i < len; i++)
		{
			for (int j = 0; j < len; j++)
			{
				map[x + i][y + j] = 0;
			}
		}

		arr[len]--;
		cnt++;
		go(x,y + len);

		for (int i = 0; i < len; i++)
		{
			for (int j = 0; j < len; j++)
			{
				map[x + i][y + j] = 1;
			}
		}

		arr[len]++;
		cnt--;
	}
}
int main()
{
	int num;
	for (int i = 0; i < 10; i++)
	{
		for (int j = 0; j < 10; j++)
		{
			cin >> num;
			map[i][j] = num;
		}
	}
	result = 999;
	go(0, 0);
	if (result == 999)
		cout << -1 << endl;
	else
		cout << result << endl;
}
