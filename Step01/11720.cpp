#include <iostream>
using namespace std;

int main()
{
    int N = 0;

    cin >> N;

    int sum = 0;

    int arr[100] = {0};
    for (int i = 0; i < N; i++)
    {
        sum += arr[i];
    }

    cout << sum << endl;
    return 0;
}
