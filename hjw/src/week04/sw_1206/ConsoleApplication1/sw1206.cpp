#include <iostream>
#include <fstream>
#include <algorithm>
using namespace std;

int main()
{
	int result = 0;//��� ��
	int dif = 0;//�� �� ��
	int arr1[3];
	int arr2[5];

	for (int k = 1; k <= 10; k++)//10ȸ�ݺ�
	{
		int apt_number;//����Ʈ ����
		cin >> apt_number;
		int *arr;
		arr = new int[apt_number];
		for (int j = 0; j < apt_number; j++)
		{
			cin >> arr[j];//i��° ����Ʈ�� �ִ� ����
		}
		//�Է� ����


		for (int j = 0; j < apt_number; j++)
		{


			if (j == 0)//�� ó�� �� ������ Ȯ��x �����ʸ� Ȯ��
			{
				if (arr[j] > arr[j + 1])
				{
					if (arr[j] > arr[j + 2])//1���� 3������ �� ���� ���� ���
					{
						(arr[j + 1] > arr[j + 2]) ? dif = (arr[j] - arr[j + 1]) : dif = (arr[j] - arr[j + 2]);//���׿����� ���
						result += dif;//����� ����
						dif = 0;//�� �� �� �ʱ�ȭ
					}
				}
			}
			else if (j == apt_number - 1)//�� ������ �� �������� Ȯ��x ���ʸ� Ȯ��
			{
				if (arr[j] > arr[j - 1])
				{
					if (arr[j] > arr[j - 2])
					{
						(arr[j - 1] > arr[j - 2]) ? dif = (arr[j] - arr[j - 1]) : dif = (arr[j] - arr[j - 2]);//���׿����� ���
						result += dif;//����� ����
						dif = 0;//�� �� �� �ʱ�ȭ
					}
				}
			}
			else if(j==1)//���Ī Ȯ��,,,2��
			{
				if (arr[j] > arr[j - 1])//1������ ũ��
				{
					if (arr[j] > arr[j + 1])//3������ ũ��
					{
						if (arr[j] > arr[j + 2])//4�� ���� ũ�� ,,, ������� ���°��̸� j�� �ּ� ������ ���� ����Ʈ 1�� �̻��� Ȯ��
						{
							arr1[0] = arr[j - 1];
							arr1[1] = arr[j + 1];
							arr1[2] = arr[j + 2];
							sort(arr1, arr1 + 3);
							result += arr[j] - arr1[2];
						}
					}
				}
			}
			else if (j == apt_number - 2)//���Ī Ȯ��
			{
				if (arr[j] > arr[j + 1])
				{
					if (arr[j] > arr[j - 1])
					{
						if (arr[j] > arr[j - 2])//������� ���°��̸� j�� �ּ� ������ ���� ����Ʈ 1�� �̻��� Ȯ��
						{
							arr1[0] = arr[j + 1];
							arr1[1] = arr[j - 1];
							arr1[2] = arr[j - 2];
							sort(arr1, arr1 + 3);
							result += arr[j] - arr1[2];
						}
					}
				}
			}
			else//j�� 2 ���� apt_number-2 ������ ����������
			{
				for (int q = 0; q < 5; q++)//�� �ΰ� �� �ΰ� ���� ���� 5�� sort
				{
					arr2[q] = arr[j + q - 2];
				}
				sort(arr2, arr2 + 5);

				if (arr[j] == arr2[4])//���� ū���� �ڱ��ڽ��� ��쿡�� ������ Ȯ��
				{
					result += arr[j] - arr2[3];//�ڱ��ڽ��� ���� ũ�� �� �������� ū���� ��
				}
			}

			//cout << "#" << j << "\t" << result << endl;
		}

		cout << "#" << k << " ";
		cout << result << endl;
		result = 0;
	}
}
