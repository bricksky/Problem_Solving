#include <iostream>

using namespace std;

int main() {
    int e, s, m;
    cin >> e >> s >> m;
    
    int re = 1, rs = 1, rm = 1;  
    int year = 1;                

    while (true) {
        if (re == e && rs == s && rm == m) {
            cout << year; 
            break;
        }
        
        re = (re % 15) + 1;
        rs = (rs % 28) + 1;
        rm = (rm % 19) + 1;
        year++;
    }

    return 0;
}
