#include <iostream>
using namespace std;

int main()
{
	int arr[10];
	int result = 0;
	int num;
	int j=0;

	cin >> num;
	while (j < num)
	{
		for (int i = 0; i < 10; i++)
			cin >> arr[i];

		for (int i = 0; i < 10; i++)
		{
			if (arr[i] % 2 != 0)
				result += arr[i];
		}
		cout << '#' << j + 1 << ' ' << result << endl;
		j++;
		result = 0;
	}

	return 0;
}