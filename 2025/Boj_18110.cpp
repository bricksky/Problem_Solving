#include <iostream>
#include <algorithm>
#include <vector>
#include <cmath>

using namespace std;

int main(){
    int n;
    int result = 0;

    cin >> n;

    if(n == 0){
        cout << result;
        return 0;
    }

    vector<int> numbers(n);

    for(int i=0; i<n; i++){
        cin >> numbers[i];
    }

    // 난이도 정렬
    sort(numbers.begin(), numbers.end());

    // 절사평균으로 해당되는 수 계산
    int index = round(n * 0.15);
    double sum = 0;

    // 합 까지 구한 결과
    for(int i=index; i < n-index; i++){
        sum +=  numbers[i];
    }

    result = round(sum / n - (index*2));
    cout << result << '\n';
}