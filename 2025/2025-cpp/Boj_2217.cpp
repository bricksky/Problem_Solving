#include <iostream>
#include <algorithm>

using namespace std;

int main(){
    int n;
    int current;
    int max;
    int rope[100000];

    cin >> n;

    for(int i=0; i<n; i++){
        cin >> rope[i];
    }

    sort(rope, rope+n);

    // 최대인 경우로 가정하고 시작.
    max = rope[n-1];

    for(int i=0; i<n; i++){
        current = rope[i] * (n-i);

        if(max < current){
            max = current;
        }
    }
    cout << max << endl;
    return 0;
}