#include <iostream>
#include <algorithm>
using namespace std;
int main()
{
	int n;
	cin >> n;

	int *arr = new int[n];

	for (int i = 0; i < n; i++)
		cin >> arr[i];
	sort(arr, arr + n);
	int mid = (1 + n) / 2;
	cout << arr[mid-1] << endl;
	
	delete[]arr;
	return 0;
}