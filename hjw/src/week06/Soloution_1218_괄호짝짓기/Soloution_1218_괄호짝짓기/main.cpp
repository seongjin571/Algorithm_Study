/*
※ SW Expert 아카데미의 문제를 무단 복제하는 것을 금지합니다.

4 종류의 괄호문자들 '()', '[]', '{}', '<>' 로 이루어진 문자열이 주어진다.

이 문자열에 사용된 괄호들의 짝이 모두 맞는지 판별하는 프로그램을 작성한다.

예를 들어 아래와 같은 문자열은 유효하다고 판단할 수 있다.



아래와 같은 문자열은 유효하지 않은 문자열이다. 붉은색으로 표시된 괄호의 짝을 찾을 수 없기 때문이다.



아래 문자열은 열고 닫는 괄호의 개수는 유효하나 짝이 맞지 않는 괄호가 사용 되었기 때문에 유효하지 않다.



[입력]

각 테스트 케이스의 첫 번째 줄에는 테스트케이스의 길이가 주어지며, 바로 다음 줄에 테스트 케이스가 주어진다.

총 10개의 테스트케이스가 주어진다.

[출력]

#부호와 함께 테스트 케이스의 번호를 출력하고, 공백 문자 후 유효성 여부를 1 또는 0으로 표시한다 (1 - 유효함, 0 - 유효하지 않음).*/

#include <iostream>
#include <vector>

using namespace std;

int main()
{
	char c;
	for (int i = 1; i <= 10; i++)
	{
		int test_case;
		cin >> test_case;//문자열의 길이

		vector<char> v;
		vector<char>::iterator it;
		for (int j = 0; j < test_case; j++)
		{
			cin >> c;
			if (c == '(' || c == '<' || c == '[' || c == '{')//닫는 괄호가 나왔을때 벡터에 푸쉬
			{
				v.push_back(c);
			}
			else//닫는괄호가 나왔을때
			{
				v.push_back(c);//맨뒤에 추가
				char change_c;//닫는괄호를 여는괄호로 변환
				switch (c)
				{
				case ')':
					change_c = '(';
					break;
				case '}':
					change_c = '{';
					break;
				case ']':
					change_c = '[';
					break;
				case '>':
					change_c = '<';
					break;
				default:
					cout << "error" << endl;
					break;
				}
				for (auto it = v.begin(); it != v.end(); it++)//벡터의 시작과 끝을 돌면서 같은거 찾기
				{
					if (*it == change_c)//지울게있는경우
					{
						it = v.erase(it);//여는괄호 지우고
						v.pop_back();//맨 뒤에 넣은 닫는괄호 지우고
						break;
					}
				}
			}
		}
		cout << "#" << i << ' ';
		if (v.size() == 0)//유효함
		{
			cout << 1 << endl;
		}
		else
			cout << 0 << endl;

	}
}