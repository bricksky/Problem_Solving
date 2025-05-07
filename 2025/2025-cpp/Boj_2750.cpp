#include <iostream>
#include <algorithm>


using namespace std;

int main(){
    int n;
    int num[1001];

    cin >> n;

    for(int i=0; i<n; i++){
        cin >> num[i];
    }

    // 배열 전체를 오름차순으로 정렬한 케이스.
    sort(num, num+n);

    for(int i=0; i<n; i++){
        cout << num[i] << endl;
    }

    return 0;
}