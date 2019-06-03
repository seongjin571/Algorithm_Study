#include <iostream>
using namespace std;
void function(int a, int b)
{
	if (a > b)
		cout << '>' << endl;
	else if (a < b)
		cout << '<' << endl;
	else
		cout << '=' << endl;
}
int main()
{
	int t;
	int a, b;
	cin >> t;
	for (int i = 1; i <= t; i++)
	{
		cin >> a >> b;
		cout << '#' << i << ' ';
		function(a, b);
	}
	return 0;
}