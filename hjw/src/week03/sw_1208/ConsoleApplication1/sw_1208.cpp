#include <iostream>
#include <algorithm>
using namespace std;

int main()
{

	for (int i = 0; i < 10; i++)
	{

		int dump_number;//������ ����
		int arr[100];
		int max = 0, min = 0;
		int count = 0;//Ƚ���� ���� ���� ����
		cin >> dump_number;//������ ���ڸ� �ް�
		for (int i = 0; i < 100; i++)//100���� ���ڸ� ����
		{
			cin >> arr[i];
		}

		sort(arr, arr + 100);//�����Ѵ�
		max = arr[99];//�ִ밪
		min = arr[0];//�ּҰ�

		while ((max > min)&&(count < dump_number))//�ݺ����� ������ ���� 1.�ִ밪�� �ּҰ����� Ŀ����. �� �ִ�<=�ּҰ� �Ǵ¼��� ���´�...2.Ƚ���� �����ű�� Ƚ���� �Ѿ�� stop�ϰ� ���´�
		{
			count++;//�����ѹ��ű�
			arr[99] = arr[99] - 1;//��������� �ϳ� ����
			arr[0] = arr[0] + 1;//���� ������ �ϳ� �߰�
			sort(arr, arr + 100);//�ٽ� ��Ʈ
			max = arr[99];//�ٽ� �ִ�
			min = arr[0];//�ٽ� �ּ�
		}
		cout << "#" << i + 1 << " ";
		cout << max - min << endl;
	}


}