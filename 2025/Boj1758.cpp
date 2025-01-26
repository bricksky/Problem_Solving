#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int main(){
    int n;
    int arr[100001];

    cin >> n;

    // 입력받고 정렬
    for(int i=0; i<n; i++){
        cin >> arr[i];
    }

    sort(arr, arr+n, greater<int>());
    long long sum = 0;

    // 팁 구하는 부분
    for(int i=1; i<=n; i++){
        if(arr[i-1] - (i-1) > 0){
            sum += arr[i-1] - (i-1);
        }
    }
    cout << sum;
    return 0;
}