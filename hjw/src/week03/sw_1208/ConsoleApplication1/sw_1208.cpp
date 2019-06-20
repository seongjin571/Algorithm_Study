#include <iostream>
#include <algorithm>
using namespace std;

int main()
{

	for (int i = 0; i < 10; i++)
	{

		int dump_number;//덤프의 숫자
		int arr[100];
		int max = 0, min = 0;
		int count = 0;//횟수를 세기 위한 변수
		cin >> dump_number;//덤프의 숫자를 받고
		for (int i = 0; i < 100; i++)//100개의 인자를 받음
		{
			cin >> arr[i];
		}

		sort(arr, arr + 100);//정렬한다
		max = arr[99];//최대값
		min = arr[0];//최소값

		while ((max > min)&&(count < dump_number))//반복문을 실행할 조건 1.최대값이 최소값보다 커야함. 즉 최대<=최소가 되는순간 나온다...2.횟수가 덤프옮기는 횟수를 넘어가면 stop하고 나온다
		{
			count++;//상자한번옮김
			arr[99] = arr[99] - 1;//가장높은곳 하나 감소
			arr[0] = arr[0] + 1;//가장 낮은곳 하나 추가
			sort(arr, arr + 100);//다시 소트
			max = arr[99];//다시 최대
			min = arr[0];//다시 최소
		}
		cout << "#" << i + 1 << " ";
		cout << max - min << endl;
	}


}