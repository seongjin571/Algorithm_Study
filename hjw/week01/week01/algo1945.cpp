#include <iostream>
using namespace std;
void func(int n, int i)
{
	cout << "#" << i + 1;


	int arr[5];
	int q = 0;
	int count = 0;

	for (int j = 2; j < 12; j++)
	{
		if (j == 2 || j == 3 || j == 5 || j == 7 || j == 11)
		{
			while (n % j == 0)
			{
				n = n / j;
				count++;
			}
			arr[q] = count;
			q++;
		}
		count = 0;
	}
	for (int a = 0; a < 5; a++)
	{
		cout << " " << arr[a];
	}


	cout << endl;
}
int main()
{
	int t;
	int i, n;

	cin >> t;

	for (i = 0; i < t; i++)
	{
		cin >> n;
		func(n, i);
	}

	return 0;
}