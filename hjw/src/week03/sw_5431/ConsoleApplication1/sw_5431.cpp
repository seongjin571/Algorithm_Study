#include <iostream>
using namespace std;

int main()
{
	int testcase;
	cin >> testcase;

	for (int i = 1; i <= testcase; i++)
	{
		int all_student, submitted_person;//전체 수강생의 수, 제출한 사람의 수
		cin >> all_student >> submitted_person;
		bool *arr = new bool[all_student];//제출여부 확인
		fill(arr, arr + all_student, false);//모두 false로 제출x 초기값

		for (int i = 0; i < submitted_person; i++)
		{
			int index;//누가제출햇는지
			cin >> index;//제출한 녀석
			arr[index-1] = true;//제출한 녀석의 값을 true로 바꿈..index-1 이유는 1번 사람은 0번 index이기때문
		}
		cout << "#" << i << " ";
		for (int i = 0; i < all_student; i++)
		{
			if (arr[i] == false)//제출안한녀석
				cout << i+1 << " ";//출력
		}
		cout << endl;
	}
}