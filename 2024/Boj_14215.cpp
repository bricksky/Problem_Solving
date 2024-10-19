#include <iostream>
#include <algorithm>

using namespace std;
int main(){
    int arr[3] = {};
    int result = 0;
    cin >> arr[0] >> arr[1] >> arr[2];

    sort(arr, arr+3);

    // 삼각형 조건에 부합하는 경우
    if(arr[2] < arr[0] + arr[1]){
        result = arr[0] + arr[1] + arr[2];
    }

    // 삼각형 조건에 부합하지 않는 경우
    else if(arr[2] = arr[0] + arr[1]-1){
        result = arr[0] + arr[1] + arr[2]
    }

    cout << result;
    return 0;
}