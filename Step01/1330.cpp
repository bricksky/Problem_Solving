#include <iostream>
using namespace std;

int main()
{
    int A;
    int B;

    cin >> A >> B;
    if (A > B)
        cout << ">" << endl;

    else if (A < B)
        cout << "<" << endl;

    else
        cout << "==" << endl;
    return 0;
}
