#include <iostream>
#include <cstring>
#include <cctype>

using namespace std;

int main(){
    int n;
    
    // for문의 구조
    // string s: 문자열 변수 선언
    
    for(string s; getline(cin, s);){
        int count[4] = {};      // 소문자, 대문자, 숫자, 공백의 개수를 저장할 배열
        for(auto& i : s){
            if(islower(i))
            count[0]++;
            else if(isupper(i))
            count[1]++;
            else if(isdigit(i))
            count[2]++;
            else
            count[3]++;
        }
        for(int i=0; i<4; i++){
            cout << count[i] << ' ';
        }
        cout << '\n';     
    }
}