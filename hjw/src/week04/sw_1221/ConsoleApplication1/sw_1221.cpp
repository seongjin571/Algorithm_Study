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
		getchar();//빈칸 입력 안받기
		memset(arr, 0, sizeof(arr));//개수 초기화
		getline(cin, str);

		for (int j = 0; j < number*4; j = j+4)//4개가 한묶음이므로 4칸씩 읽고 4칸씩 읽었기때문에 전체수 x 4
		{
			sub = str.substr(j, 4);//네칸씩 잘라서 단어 한개씩 확보
			for (int j = 0; j < 10; j++)//비교
			{
				int c = sub.compare(comparestr[j]);//-1, 0 ,1 ,,,,0이 같음 -1은 앞순서 1은 뒷순거
				if (c == 0)
				{
					arr[j] += 1;//같을시 개수 ++
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
