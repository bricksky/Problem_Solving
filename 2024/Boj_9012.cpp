#include <iostream>
#include <string>
#include <stack>

using namespace std;

int main(){
    int count;
    cin >> count;

    while(count--){
        stack<char> st;
        string s;
        cin >> s;

        for(int j=0; j<s.length(); j++){
            if(st.empty()){ // 스택이 비어있는 경우 pop
                st.push(s[j]);
            } else {
                if(st.top() == '(' && s[j] == ')'){
                    st.pop();
                } else {
                    st.push(s[j]);
                }
            }
        }
        if(st.empty()){
            cout << "YES" << '\n';
        } else {
            cout << "NO" << '\n';
        }
    }
    return 0;
}