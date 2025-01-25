#include <iostream>
#include <algorithm>

using namespace std;

int main(){
    int w[10];
    int k[10];

    int result1, result2;
    
    for(int i=0; i<10; i++){
        cin >> w[i];
    }

    for(int i=0; i<10; i++){
        cin >> k[i];
    }

    sort(w, w+10,  greater<int>());
    sort(k, k+10,  greater<int>());

    result1 = w[0] + w[1] + w[2];
    result2 = k[0] + k[1] + k[2];

    cout << result1 << " " << result2 << endl;
}