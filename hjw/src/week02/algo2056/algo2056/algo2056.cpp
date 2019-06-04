#include <iostream>
using namespace std;
int main()
{
	char start_arr[8];
	int x;
	int arr[8];
	int t;
	int year,month,day;
	cin >> t;

	for (int q = 1; q <= t; q++)
	{
		for (int i = 0; i < 8; i++)
		{
			cin >> start_arr[i];
		}

		for (int i = 0; i < 8; i++)
		{
			arr[i] = start_arr[i] - '0';
		}


		year = arr[0] * 1000 + arr[1] * 100 + arr[2] * 10 + arr[3];
		month = arr[4] * 10 + arr[5];
		day = arr[6] * 10 + arr[7];

		if (year < 1)
		{
			cout << '#' << q << ' ' << -1 << endl;
			
		}
		else if (month > 12 || month < 1)
		{
			cout << '#' << q << ' ' << -1 << endl;
		
		}
		else if (day > 31 || day < 1)
		{
			cout << '#' << q << ' ' << -1 << endl;
		
		}

		else if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
		{
			if (day > 31 || day < 1)
			{
				cout << '#' << q << ' ' << -1 << endl;
			
			}
			else
				cout << '#' << q << ' ' << start_arr[0] << start_arr[1] << start_arr[2] << start_arr[3] << '/' << start_arr[4] << start_arr[5] << '/' << start_arr[6] << start_arr[7] << endl;
		}
		else if (month == 2)
		{
			if (day > 28 || day < 1)
			{
				cout << '#' << q << ' ' << -1 << endl;
				
			}
			else
				cout << '#' << q << ' ' << start_arr[0] << start_arr[1] << start_arr[2] << start_arr[3] << '/' << start_arr[4] << start_arr[5] << '/' << start_arr[6] << start_arr[7] << endl;
		}
		else if(month == 4 || month == 6 || month == 9 || month == 11)
		{
			if (day > 30 || day < 1)
			{
				cout << '#' << q << ' ' << -1 << endl;
				
			}
			else
				cout << '#' << q << ' ' << start_arr[0] << start_arr[1] << start_arr[2] << start_arr[3] << '/' << start_arr[4] << start_arr[5] << '/' << start_arr[6] << start_arr[7] << endl;
		}
	}
	return 0;
}