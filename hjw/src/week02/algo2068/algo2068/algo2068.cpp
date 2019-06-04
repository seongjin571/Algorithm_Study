#include <iostream>
#include <algorithm>
using namespace std;
int main()
{
	int t;
	int arr[10];
	int result = 0;
	cin >> t;

	for (int i = 1; i <= t; i++)
	{
		for (int j = 0; j < 10; j++)
		{
			cin >> arr[j];
		}
		sort(arr, arr + 10);//오름차순정렬
		cout << '#' << i << ' ' << arr[9] << endl;
	}

	return 0;
}