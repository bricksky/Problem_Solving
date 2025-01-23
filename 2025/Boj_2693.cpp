/* #include <iostream>
#include <algorithm>

using namespace std;

int main(){
    int t;
    int arr[10];

    cin >> t;

    for(int i=0; i<t; i++){

        // 각 테스트 케이스마다 10개의 숫자를 입력받음
        for(int j=0; j<10; j++){
            cin >> arr[j];
        }
        
        // 내림차순으로 정렬
        sort(arr, arr+10, greater<int>());
        cout << arr[2] << endl;
    }
    return 0;
} */