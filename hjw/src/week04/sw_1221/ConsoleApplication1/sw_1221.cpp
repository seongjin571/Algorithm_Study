#include <iostream>
#include <algorithm>
#include <string>
#include <fstream>
using namespace std;
/*
int main()
{
	int testcase_number;
	cin >> testcase_number;

	for (int i = 1; i <= testcase_number; i++)
	{
		int testcase_length;
		string str;
		cin >> testcase_length;
		testcase_length = testcase_length * 4;
		char *ch = new char[testcase_length];
		getline(cin, str);
		strcpy(ch, str.c_str());

		for (int j = 0; j < testcase_length; j = j+4)
		{
			string str = ch[j];
		}
	}
}
*/
int main()
{
	ifstream inf("C:\\Users\\admin\\Downloads\\GNS_test_input.txt");
	string str;
	while (!inf.eof())
	{
		getline(inf, str);
		cout << str;
	}
	
}