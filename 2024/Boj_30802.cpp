#include <iostream>

using namespace std;

int main() {
    int n, t, p;
    int s[6];
    int count = 0;

    cin >> n;

    // 6개의 수 입력받는 부분
    for (int i = 0; i < 6; i++) {
        cin >> s[i];
    }

    cin >> t >> p;

    // 정수 나눗셈을 사용해 올림을 구현한 부분
    for (int i = 0; i < 6; i++) {
        count += (s[i] + t - 1) / t;
    }

    cout << count << '\n';
    cout << n / p << ' ' << n % p << '\n';

    return 0;
}
