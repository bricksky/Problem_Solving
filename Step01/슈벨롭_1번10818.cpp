#include <iostream>
using namespace std;

int main()
{
    int n;
    cin >> n;
    int arr[n];

    for (int i = 0; i < n; i++)
    {
        cin >> arr[i];
        cout << arr[i] << ' ';
    }

    int minV = 1000000;  // 이게 무슨 말..?
    int maxV = -1000000; // 이게 무슨 말..?

    for (int i = 0; i < n; i++)
    {
        if (arr[i] < minV)
        {
            minV = arr[i];
        }
        if (arr[i] > maxV)
        {
            maxV = arr[i];
        }
    }

    cout << minV << ' ' << maxV;
    return 0;
}

// 최댓값구하는 문제에서 Index0 부터 시작하는게 일반적인데, 수를 1부터 세는 경우가 있다?
// -> "+1"을 넣어서 값을 맞추면 됨.