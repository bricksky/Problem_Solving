#include <iostream>

using namespace std;

int main(){
    int line = 1;
    int x;

    cin >> x;

    while(x-line > 0){
        x = x - line;
        line++;
    }
    // 홀수
    if(line % 2 ==1){
        cout << (line + 1)-x << "/" << x;
    } 
    // 짝수
    else
        cout << x << "/" << (line + 1)-x;

    return 0;
}