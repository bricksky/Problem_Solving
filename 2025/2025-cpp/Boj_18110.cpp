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

    // 합 계산
    for(int i=index; i < n-index; i++){
        sum +=  numbers[i];
    }

    // 절사평균을 계산하고 반올림
    result = round(sum / (n - 2 * index));
    cout << result;
}
