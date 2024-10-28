#include <iostream>
#include <stack>

using namespace std;

int main(){
    string s;
    cin >> s;

    stack<char> result;
    int ans = 0;

    for(int i = 0; i < s.size(); i++){
        if(s[i] == '(' && s[i + 1] == ')'){
            ans += result.size();
            i++;
        }
        else if(s[i] == '('){
            ans++;
            result.push(')');
        }
        else if(s[i] == ')'){
            result.pop();
        }
    }
    cout << ans << '\n';
}