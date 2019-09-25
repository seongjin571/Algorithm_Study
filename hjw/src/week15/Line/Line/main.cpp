
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
int cnt;
vector <int> vc;
vector<int>res;
bool arr[11];
void dfs(int num, int count ,int k)
{
	if (res.size() == vc.size())
	{
		cnt++;
		if (cnt == k)
		{
			for (auto z : res)
				cout << z;
			return;
		}
	}
	else
	{
		for (int i = 0; i < vc.size(); i++)
		{
			if (arr[i] == 0)
			{
				arr[i] = 1;
				res.push_back(vc[i]);
				dfs(0, count, k);
				arr[i] = 0;
				res.pop_back();
			}
		}
	}
}
int main()
{
	cnt = 0;
	int count = 0;
	int val;
	int k;
	do
	{
		scanf("%d", &val);
		vc.push_back(val);
		count++;
	} while (getc(stdin) == ' ');//while(getc(stdin) == ' ')
	
	cin >> k;
	sort(vc.begin(), vc.end());
	dfs(0,count,k);
}

/*
#include <iostream>

using namespace std;
int arr[200002];
int left(int start,int num)
{
	int x;
	int cnt = 1;
	x = start - 1;
	while (1)
	{
		if (x < 0)
			break;
		if (arr[x] == 1)
			break;
		if (arr[x] == 0)
			cnt++;
		x--;
	}
	return cnt;
}
int right(int start,int num)
{
	int x;
	int cnt = 1;
	x = start + 1;
	while (1)
	{
		if (x >= num)
			break;
		if (arr[x] == 1)
			break;
		if (arr[x] == 0)
			cnt++;
		x++;
	}
	return cnt;
}
int main()
{
	int n;
	int max = 0;
	int cnt = 0;
	cin >> n;
	for (int i = 0; i < n; i++)
	{
		int x;
		cin >> x;
		arr[i] = x;
	}
	int l;
	int r;
	for (int i = 0; i < n; i++)
	{
		if (i == 0 && arr[i] == 0)
		{
			r = right(i, n);
			cnt = r;
			if (max < cnt)
				max = cnt;
		}
		else if (i == n - 1 && arr[i] == 0)
		{
			l = left(i, n);
			cnt = l;
			if (max < cnt)
				max = cnt;
		}
		else if (arr[i] == 0)
		{
			l = left(i,n);
			r = right(i,n);
			cnt = l < r ? l : r;
			if (max < cnt)
				max = cnt;
		}
	}
	cout << max;

	return 0;
}
*/
/*
#include <iostream>
#include <queue>
using namespace std;
int arr[10][1];
queue<int>que;
int main()
{
	int msg_cnt;
	int consumer_cnt;
	cin >> msg_cnt >> consumer_cnt;
	for (int i = 0; i < msg_cnt; i++)
	{
		int t;
		cin >> t;
		que.push(t);
	}
	
	while (!que.empty())
	{
		int a = que.front();
		que.pop();

		int min = 101;
		int now;
		int idx;
		for (int i = 0; i < consumer_cnt; i++)
		{
			now = arr[i][0];
			if (now < min)
			{
				min = now;
				idx = i;
			}
		}
		arr[idx][0] += a;
	}
	int max = -1;
	for (int i = 0; i < consumer_cnt; i++)
	{
		if (max < arr[i][0])
			max = arr[i][0];
	}
	cout << max;
	
	return 0;
}
*/
/*
#include <iostream>

using namespace std;
int map[1001][1000];

int main()
{
	int num;
	cin >> num;
	int start, end;
	int time_max = 0;
	for (int i = 0; i < num; i++)
	{
		cin >> start >> end;
		if (end > time_max)
			time_max = end;
		for (int j = start; j < end; j++)
		{
			map[i][j] = 1;
		}
	}
	int max = 0;
	
	for (int j = 0; j <= time_max; j++)
	{
		int cnt = 0;
		for (int i = 0; i < num; i++)
		{
			if (map[i][j] == 1)
				cnt++;
		}
		if (cnt > max)
			max = cnt;
	}
	cout << max;
	return 0;
}
*/
/*
#include <iostream>

using namespace std;
int dx[4] = { 1,0,-1,0 };
int dy[4] = { 0,-1,0,1 };
int n, m;
int coni_x, coni_y;
int map[26][26];
int check[26][26];
int over_time;
int arr[10000];
void dfs(int cnt,int x, int y)
{
	if (x == coni_x && y == coni_y)
	{
		arr[cnt]++;
		over_time = cnt;
		return;
	}

	if (cnt > over_time)
		return;

	for (int i = 0; i < 4; i++)
	{
		int newx = x + dx[i];
		int newy = y + dy[i];
		if ((-1 < newx && newx < n) && (-1 < newy && newy < m) && (check[newx][newy] == 0))
		{
			check[newx][newy] = 1;
			dfs(cnt + 1, newx, newy);
			check[newx][newy] = 0;
		}
	}
}
int main()
{
	cin >> n >> m;
	cin >> coni_x >> coni_y;
	if ((0 > coni_x || coni_x >= n) || (0 > coni_y || coni_y >= m) || (coni_x == 0 && coni_y == 0))
	{
		cout << "fail";
		return 0;
	}
	else
	{
		over_time = n*m;
		dfs(0,0,0);
	}
	int idx = 0;
	int time, num;
	while (1)
	{
		if (arr[idx] != 0)
		{
			time = idx;
			num = arr[idx];
			break;
		}
		idx++;
	}
	cout << time << endl << num;
}
*/
