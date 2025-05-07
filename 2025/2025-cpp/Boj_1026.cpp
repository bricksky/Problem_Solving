#include <iostream>
#include <algorithm>

using namespace std;

int main(){
    int n;
    int sum = 0;

    cin >> n;

    int A[n];
    int B[n];

    for(int i=0; i<n; i++){
        cin >> A[i];
    }

    for(int i=0; i<n; i++){
        cin >> B[i];
    }

    sort(A, A+n);
    sort(B, B+n, greater<int>());

    for(int i=0; i<n; i++){
        sum += (A[i] * B[i]);
    }

    cout << sum << endl;
    return 0;
}