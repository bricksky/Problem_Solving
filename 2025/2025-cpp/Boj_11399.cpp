#include <iostream>
#include <algorithm>

using namespace std;

int main(){
    int n;
    int sum = 0;
    int num[1001];

    cin >> n;

    for(int i=0; i<n; i++){
        cin >> num[i];
    }

    // 입력받은 시간을 오름차순으로 정렬
    sort(num, num+n);

    for(int i=0; i<n; i++){
        num[i+1] += num[i];
        sum += num[i];
    }
    cout << sum << endl;
}