#include <iostream>

using namespace std;

int main(){
    int a, b, c;

    cin >> a >> b >> c;

    int total = a*60 + b + c;
    
    a = (total / 60) % 24;
    b = total % 60;

    cout << a << " " << b;
    return 0;
}