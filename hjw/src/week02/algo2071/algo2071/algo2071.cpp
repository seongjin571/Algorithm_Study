#include <iostream>
using namespace std;

int main()
{
	int t;
	int arr[10];
	double result = 0;
	cin >> t;

	for (int i = 0; i < t; i++)
	{
		for (int j = 0; j < 10; j++)
		{
			cin >> arr[i];
			result += arr[i];
		}
		result = result / 10;

		if ((result + 0.5) >= (int)result +1)
		{
			result = (int)result;
			cout << '#' << i + 1 << ' ' << result+1 << endl;
		}
		else
		{
			result = (int)result;
			cout << '#' << i + 1 << ' ' << result << endl;
		}
		result = 0;
	}

	return 0;
}