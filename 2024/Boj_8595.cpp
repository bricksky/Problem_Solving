#include <iostream>
#include <cstring>
#include <cctype>

using namespace std;

int main(){
    long long num;
    string input;
     long long sum = 0;
     long long currentNum = 0;

    cin >> num >> input;

    for(int i=0; i<num; i++){
        // 숫자인 경우
        if(isdigit(input[i])){
            currentNum = currentNum * 10 + (input[i] - '0');
        } else {
            sum += currentNum;
            currentNum = 0;
        }
    }
    sum += currentNum;

    cout << sum << '\n';
    return 0;
}