#include <iostream>
#include <vector>
using namespace std;
struct info {
	int how_long;
	int pay;
};
int n;
int result;
vector<info> inf;
vector <int> vc;
int check[16];
void function(int day, int paysum)
{
	int worksize = inf[day].how_long;
	int pay = inf[day].pay;
	if (day + worksize >= n)
	{
		paysum = day + worksize == n ? paysum + pay : paysum;
		result = paysum > result ? paysum : result;
		return;
	}
	else
	{
		paysum += pay;
		for (int i = day + worksize; i < n; i++)
			function(i,paysum);
	}
}
int main()
{
	cin >> n;
	int t, p;
	result = 0;
	for (int i = 0; i < n; i++)
	{
		int a, b;
		cin >> a >> b;
		inf.push_back({ a,b });
	}
	for(int i=0;i<n;i++)
	{
		function(i,0);
	}
	cout << result;
}