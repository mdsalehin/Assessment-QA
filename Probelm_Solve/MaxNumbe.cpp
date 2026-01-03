#include<bits/stdc++.h>
using namespace std;
int main()
{
    int n;
    cout << "Enter the number of elements: = ";
    cin>>n;
    int arr[n+10];
    for(int i = 0; i<n; i++)
    {
        cin>>arr[i];
    }
    int maxNumber = INT_MIN;
    int cmp = 0;
    for(int i = 0;i<n;i++)
    {
        if(arr[i]>maxNumber)
        {
            maxNumber =  arr[i];
        }
    }
    cout<<maxNumber<<endl;
}
