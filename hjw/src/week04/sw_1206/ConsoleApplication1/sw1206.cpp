#include <iostream>
#include <fstream>
#include <algorithm>
using namespace std;

int main()
{
	int result = 0;//결과 값
	int dif = 0;//층 의 차
	int arr1[3];
	int arr2[5];

	for (int k = 1; k <= 10; k++)//10회반복
	{
		int apt_number;//아파트 개수
		cin >> apt_number;
		int *arr;
		arr = new int[apt_number];
		for (int j = 0; j < apt_number; j++)
		{
			cin >> arr[j];//i번째 아파트의 최대 층수
		}
		//입력 종료


		for (int j = 0; j < apt_number; j++)
		{


			if (j == 0)//맨 처음 즉 왼쪽은 확인x 오른쪽만 확인
			{
				if (arr[j] > arr[j + 1])
				{
					if (arr[j] > arr[j + 2])//1동이 3동까지 중 가장 높은 경우
					{
						(arr[j + 1] > arr[j + 2]) ? dif = (arr[j] - arr[j + 1]) : dif = (arr[j] - arr[j + 2]);//삼항연산자 사용
						result += dif;//결과값 누적
						dif = 0;//층 의 차 초기화
					}
				}
			}
			else if (j == apt_number - 1)//맨 오른쪽 즉 오른쪽은 확인x 왼쪽만 확인
			{
				if (arr[j] > arr[j - 1])
				{
					if (arr[j] > arr[j - 2])
					{
						(arr[j - 1] > arr[j - 2]) ? dif = (arr[j] - arr[j - 1]) : dif = (arr[j] - arr[j - 2]);//삼항연산자 사용
						result += dif;//결과값 누적
						dif = 0;//층 의 차 초기화
					}
				}
			}
			else if(j==1)//비대칭 확인,,,2동
			{
				if (arr[j] > arr[j - 1])//1동보다 크고
				{
					if (arr[j] > arr[j + 1])//3동보다 크고
					{
						if (arr[j] > arr[j + 2])//4동 보다 크고 ,,, 여기까지 들어온것이면 j가 최소 조망권 가진 아파트 1개 이상은 확보
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
			else if (j == apt_number - 2)//비대칭 확인
			{
				if (arr[j] > arr[j + 1])
				{
					if (arr[j] > arr[j - 1])
					{
						if (arr[j] > arr[j - 2])//여기까지 들어온것이면 j가 최소 조망권 가진 아파트 1개 이상은 확보
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
			else//j가 2 부터 apt_number-2 까지의 범위내에서
			{
				for (int q = 0; q < 5; q++)//앞 두개 뒤 두개 본인 포함 5개 sort
				{
					arr2[q] = arr[j + q - 2];
				}
				sort(arr2, arr2 + 5);

				if (arr[j] == arr2[4])//가장 큰수가 자기자신일 경우에만 조망권 확보
				{
					result += arr[j] - arr2[3];//자기자신이 가장 크고 그 다음으로 큰것을 뺌
				}
			}

			//cout << "#" << j << "\t" << result << endl;
		}

		cout << "#" << k << " ";
		cout << result << endl;
		result = 0;
	}
}
