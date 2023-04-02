#include <iostream>
using namespace std;

int main()
{
    int b;

    cin >> b;

    for (int a = 1; a < 10; a++)
    {
        cout << b << "*" << a << "="
             << b * a << endl;
    }
    return 0;
}