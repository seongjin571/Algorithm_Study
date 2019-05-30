#include <iostream>
using namespace std;

int main()
{
	int number;
	int result = 0;
	int rest;
	cin >> number;


	while (number > 10)
	{
		result += number % 10;
		number = number / 10;
	}
	result += number;

	cout << result;

	return 0;
}