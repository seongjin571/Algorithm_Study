#include <iostream>
#include <algorithm>
#include <string>
#include <string.h>
#include <fstream>
#include <vector>
using namespace std;

int main()
{
	int testcase;
	cin >> testcase;
	
	int arr[10];
	string comparestr[10] = { "ZRO ","ONE ","TWO ","THR ","FOR ","FIV ","SIX ","SVN ","EGT ","NIN " };

	for (int i = 0; i < testcase; i++)
	{
		string fir_num;
		int number;
		string str;
		string sub;
		cin >> fir_num;
		cin >> number;
		getchar();//��ĭ �Է� �ȹޱ�
		memset(arr, 0, sizeof(arr));//���� �ʱ�ȭ
		getline(cin, str);

		for (int j = 0; j < number*4; j = j+4)//4���� �ѹ����̹Ƿ� 4ĭ�� �а� 4ĭ�� �о��⶧���� ��ü�� x 4
		{
			sub = str.substr(j, 4);//��ĭ�� �߶� �ܾ� �Ѱ��� Ȯ��
			for (int j = 0; j < 10; j++)//��
			{
				int c = sub.compare(comparestr[j]);//-1, 0 ,1 ,,,,0�� ���� -1�� �ռ��� 1�� �޼���
				if (c == 0)
				{
					arr[j] += 1;//������ ���� ++
				}
			}
		}
		cout << fir_num << endl;
		for (int i = 0; i < 10; i++)
		{
			for (int j = 0; j < arr[i]; j++)
			{
				cout << comparestr[i];
			}
		}
	}
}
