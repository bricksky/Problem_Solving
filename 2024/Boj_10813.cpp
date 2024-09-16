#include <iostream>
#include <algorithm>

using namespace std;

int main(){
    int n, m;
    int arr[101] = {0, };
    int a, b;

    cin >> n >> m;

     // 처음 배열에 들어갈 수를 넣어주는 반복문
    for(int i=1; i<=n; i++){
        arr[i] = i;
    }

    // 위치 바꿔주는 반복문
    for(int i=0; i<m; i++){
        cin >> a >> b;
        swap(arr[a], arr[b]);
    }

    for(int i=1; i<=n; i++){
        cout << arr[i] << ' ';
    }

    return 0;
}