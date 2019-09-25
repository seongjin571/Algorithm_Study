#include <iostream>
#include <vector>
using namespace std;

int main()
{
	vector<vector<int>> vc;
	int n, m;
	cin >> n >> m;
	vc.assign(n, vector<int > (m, 1));

	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
		{
			int t;
			cin >> t;
			vc[i][j] = t;
		}
		
	}

	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
		{
			cout << vc[i][j] << " ";
		}
		cout << endl;
	}
}