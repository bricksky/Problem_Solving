#include <iostream>

using namespace std;

int main(){
    int t, c, money;
    int q = 25, d = 10, n = 5, p = 1;
    
    cin >> t;

    for(int i=0; i<t; i++){
        money = 0;
        cin >> c;
    
        cout << c / q << " ";
        c = c % q;

        cout << c / d << " ";
        c = c % d;

        cout << c / n << " ";
        c = c % n;

        cout << c / p << endl;
        c = c % p;
    }
}