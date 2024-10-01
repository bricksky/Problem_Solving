#include <iostream>

using namespace std;

int main(){
    int dot = 2;
    int n, result;

    cin >> n;

    while(n--){
        dot = dot*2 -1;
        result = dot * dot;
    }

    cout << result;
    return 0;
}