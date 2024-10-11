#include <iostream>
#include <iomanip>

using namespace std;

int main(){
    int d1, d2;
    double pi =3.141592;
    double result;

    cin >> d1 >> d2;

    result = (2 * pi * d2) + 2 * d1;
    
    cout << fixed << setprecision(6); 
    cout << result << '\n';

    return 0;
}