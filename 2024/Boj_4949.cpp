#include <iostream>
#include <stack>
#include <cstring>

using namespace std;

int main(){
    // 입력의 종료조건으로 맨 마지막에 온점 하나(".")가 들어온다.
    for(string s; getline(cin, s) && s!= ".";){
        stack<char> S;
        bool flag = 0;

        for(int i=0; i<s.size(); i++){
            if(s[i] == '(' || s[i] == '['){     
            S.push(s[i]);   
            } else if(s[i]  == ')'){
                if(S.empty() || S.top() != '('){
                flag = 1;  
                break;         
                } else {
                    S.pop();
                 }
            } else if(s[i] == ']'){
                if(S.empty() || S.top() != '['){
                flag = 1; 
                break;
                } else {
                    S.pop();
                }
            }
        }
        if(S.size()) flag = 1;{
                cout << (flag ? "no" : "yes") << '\n';
    }
}
}