#include <iostream>
#include <algorithm>

using namespace std;

int main(){
    int t;
    int arr[10];

    cin >> t;

    for(int i=0; i<t; i++){
        for(int j=0; j<10; j++){
            cin >> arr[j];
        }
        sort(arr, arr+10, greater<int>());
        cout << arr[2] << endl;
    }
    return 0;
}