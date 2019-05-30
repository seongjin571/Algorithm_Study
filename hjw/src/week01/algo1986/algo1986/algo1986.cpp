#include <iostream>

using namespace std;

int main()
{
	int t;
	int n;
	int i = 1;
	int odd = 0, even = 0;
	cin >> t;
	for (int k = 1; k <= t; k++)
	{
		cin >> n;
		while (i <= n)
		{
			if (i % 2 == 0)//even
			{
				even += i;
			}
			else//odd
			{
				odd += i;
			}
			i++;
		}
		cout << "#" << k << " " << odd - even << endl;
	}

	return 0;
}