#include <iostream>
using namespace std;

int main()
{
	int testcase;
	cin >> testcase;

	for (int i = 1; i <= testcase; i++)
	{
		int all_student, submitted_person;//��ü �������� ��, ������ ����� ��
		cin >> all_student >> submitted_person;
		bool *arr = new bool[all_student];//���⿩�� Ȯ��
		fill(arr, arr + all_student, false);//��� false�� ����x �ʱⰪ

		for (int i = 0; i < submitted_person; i++)
		{
			int index;//���������޴���
			cin >> index;//������ �༮
			arr[index-1] = true;//������ �༮�� ���� true�� �ٲ�..index-1 ������ 1�� ����� 0�� index�̱⶧��
		}
		cout << "#" << i << " ";
		for (int i = 0; i < all_student; i++)
		{
			if (arr[i] == false)//������ѳ༮
				cout << i+1 << " ";//���
		}
		cout << endl;
	}
}