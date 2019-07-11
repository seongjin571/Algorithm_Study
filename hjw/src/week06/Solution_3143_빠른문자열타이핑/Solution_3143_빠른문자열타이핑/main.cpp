#include <iostream>
#include <string>
#include <string.h>
using namespace std;

int main()
{
	int test_case;
	cin >> test_case;

	for (int i = 0; i < test_case; i++)
	{
		string A;
		string B;

		cin >> A;
		cin >> B;

		int A_length;
		int B_length;

		A_length = A.length();
		B_length = B.length();
		
		int number=0;
		int j = 0;
		while (j+B_length <= A_length) {
			string sample;
			sample = A.substr(j, B_length);
			if (B.compare(sample) == 0)
			{
				number++;
				j = j + B_length;
			}
			else
			{
				j++;
			}
		}
		int result = 0;
		result = A_length - (number*B_length) + number;
		
		cout << "#" << i + 1 << " " << result << endl;
	}
}
