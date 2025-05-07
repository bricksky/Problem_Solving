#include <iostream>
#include <map>
#include <algorithm>

using namespace std;

int main(){
    int N;
    int count = 0;
    map <string, int> m;
    
    cin >> N;
    while(N--){
        string bookName;
        cin >> bookName;    
        m[bookName]++;
    }

    for(auto A : m) count = max(count, A.second);
    for(auto A : m){
        if(A.second == count){
            cout << A.first;
            return 0;
        }
    }
}