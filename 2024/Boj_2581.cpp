#include <iostream>
#include <vector>

using namespace std;

int main(){
    int m,n;
    cin >> m >> n;

    vector<int> vec;

    for(int i=m; i<=n; i++){
        int count = 0;
        for(int j=1; j<=i; j++){
            if(i % j == 0){
                count++;
            }
        }
        if(count==2){
            vec.push_back(i);   // 벡터에 i를 넣어줌
        }
    }

    int sum = 0;
    // 소수들의 합 구하는 부분
    for(int i=0; i<vec.size(); i++){
        sum += vec[i];
    }

    // 소수가 없는 경우 출력
    if(vec.size() == 0){
        cout << "-1";
    } else {
        cout << sum << '\n' << vec[0];
    }


}