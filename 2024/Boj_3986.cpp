#include <iostream>
#include <stack>

using namespace std;

int main(){
    int n;
    cin >> n;

    int result = 0;
    while(n--){
        stack<char> stack;
        string word;
        cin >> word;

        for(int i=0; i<word.length(); i++){
            if(stack.empty()){
                stack.push(word[i]);
            } else {
                if(stack.top() == word[i]){
                    stack.pop();
                } else {
                    stack.push(word[i]);
                }
            }
        }
        if(stack.empty()){
            result++;
        }
    }
    cout << result;
}