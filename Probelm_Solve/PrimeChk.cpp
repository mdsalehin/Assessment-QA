#include<bits/stdc++.h>
using namespace std;
int main()
{



    int chkPrime;
    cin>> chkPrime;

    if(chkPrime <= 1)
    {
        cout<<"This is not prime"<<endl;
        return 0;
    }
    int flag = 0;
    for(int start = 2; start*start<=chkPrime; start++)
    {
        if(chkPrime % start == 0)
        {
            flag = 1;
            break;
        }
    }
    if(flag == 0)
    {
        cout<<"This is prime"<<endl;
    }
    else
    {
        cout<<"This is not prime"<<endl;
    }

}
