#include <iostream>
using namespace std;
int main()
{
	int result;
	int n;
	cin >> n;
	for (int i = 1; i <= n; i++)
	{
		result += i;
	}
	cout << result;
	return 0;
}