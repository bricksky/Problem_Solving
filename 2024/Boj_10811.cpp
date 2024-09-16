#include <iostream>
#include <algorithm>

using namespace std;

int main() {
    int N, M;
    cin >> N >> M;

    int arr[N];

    // 5번 입력받을 부분의 반복문   
    for(int i=0; i<N; i++){
        arr[i] = i+1;
    }

    for(int m=0; m<M; m++){
        int i, j;
        cin >> i >> j;

        while(i<j){
            swap(arr[i-1], arr[j-1]);
            i++;
            j--;
        }
    }

    for(int i=0; i<N; i++){
        cout << arr[i] << " ";
    }

    return 0;
}
