#include <cstdio>
#include <cstring>
#include <string>
#include <cmath>
#include <vector>
#include<iostream>
using namespace std;
/*
string res = "";
string fg()
{
	string temp="";
	for (int i = 0; i < res.size(); i++)
	{
		if (res.at(i) == '0')
			temp.push_back('1');
		else
			temp.push_back('0');
	}
	string temp2="";
	for (int i = temp.size()-1; i >= 0; i--)
	{
		temp2.push_back(temp.at(i));
	}
	return temp2;
}
void func(int n)
{
	
	if (n == 0)
		res += "0";
	else
	{
		func(n - 1);
		res = res + "0" + fg();
	}
	
}
int main()
{
	int test;
	scanf("%d", &test);

	for (int z = 1; z <= test; z++)
	{
		long long n;
		scanf("%lld", &n);
		long long temp;
		temp = n + 1;
		int cnt = 0;
		while (1)
		{
			double xx = pow(2, cnt);
			long  x = long(xx);
			if (x >= temp)
				break;
			else
				cnt++;
		}
		//cout << cnt << endl;
		func(cnt - 1);
		printf("#%d %c\n", z, res.at(n-1));
		//cout << "#" << z << " " << res.at(n - 1) << endl;

		res = "";
	}
}
*/
vector<long long> arr;
int main()
{
	//freopen("input_7584.txt", "r", stdin);

	int T;
	cin >> T;
	for (int test_case = 1; test_case <= T; test_case++)
	{
		int answer = 1;
		long long k;
		cin >> k;
		long long a = 1;
		while (a < k)
			a <<= 1;
		if (a == k)
			answer = 0;
		if (answer) {
			long long before;
			while (k > 0)
			{
				before = a;
				while (a > k)
					a >>= 1;
				if (a == k && before != 2 * a)
				{
					answer = 0;
					break;
				}
				k -= a;
			}
		}
		cout << "#" << test_case << " " << answer << "\n";
	}
}
/*#include<iostream>
using namespace std;
 
long long binarymultiple(long long k){
    long long tmp=1;
    while(k>tmp){
        tmp=tmp<<1;
    }
    return tmp;
}
 
bool isSingleOne(long long k){
    long long tmp=1;
    if(k==tmp){
        return true;
    }
    while(k>tmp){
        tmp=tmp<<1;
        if(k==tmp){
            return true;   
        }
    }
    return false;
}
 
int main()
{
    int T;
    cin>>T;
    for(int t=1;t<=T;t++){
        int ans;
        long long k;
        int count=0;
        cin>>k;
        while(!isSingleOne(k)){
            k=binarymultiple(k)-k;
            count++;
        }
        if(count%2==0){
            ans=0;
        }else{
            ans=1;   
        }
        cout<<"#"<<t<<" "<<ans<<endl;
    }
    return 0;
	}*/