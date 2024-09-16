#include <iostream>

using namespace std;

int main() {

    int arr[100] = {0, };
    int n, m;
    cin >> n >> m;

    for(int z=0; z<m; z++){
        int i, j, k;
        cin >> i >> j >> k;

        for(int w=i; w<=j; w++){
            arr[w] = k;
        }
    }

    for(int i=1; i<n+1; i++){
        cout << arr[i] + << " ";
    }

    return 0;
}