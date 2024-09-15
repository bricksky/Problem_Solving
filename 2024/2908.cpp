#include <iostream>
#include <string>

using namespace std;

int main() {
    string a, b, result;
    cin >> a >> b;

    for(int i=2; i>=0; i--){
        if(a[i] > b[i]){
            result = a;
            break;
        }
        else if(a[i] < b[i]){
            result = b;
            break;
        }
    }
    cout << result[2] << result[1] << result[0];
   return 0;
}