#include <iostream>
#include <stack>

using namespace std;

int main(){
    stack<int> s;   // 스택 선언
    int n;
    string command;
    int popnum, result;

    cin >> n;

    for(int i=0; i<n; i++){
        cin >> command;

        // 1. push 명령 
        if(command == "push"){
            cin >> popnum;
            s.push(popnum);
        }

        // 2. pop 명령
        // 스택이 비어있으면 -1을 출력하고, 이외에는 top값을 출력
        else if(command == "pop"){
            if(s.size() == 0){
                result = -1;
                cout << result <<'\n';
            } else {
                result = s.top();
                cout << result << '\n';
                s.pop();
                }
            }

        // 3. size 명령
        else if(command == "size"){
            cout << s.size() << '\n';
        }

        // 4. empty 명령
        // size함수를 통해 size가 0이면 스택이 빈것이므로 1을 출력하고, 아니면 0출력
        else if(command == "empty"){
            if(s.size() == 0){
                result = 1;
                cout << result << '\n';
            } else {
                result = 0;
                cout << result << '\n';
            }
        }

        // 5. top 명령
        // stack이 비어있으면 -1출력, 이외에는 top 출력
        else if(command == "top"){
            if(s.size() == 0){
                result = -1;
               cout << result << '\n';  
            } else {
                result = s.top();
                cout << result << '\n';
            }
        }
    }
    return 0;
}