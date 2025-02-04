#include <iostream>

using namespace std;

int main(){
    int n;
    string s;

    cin >> n;

    for(int i=0; i<n; i++){
        cin >> s;
        for(int i=0; i<s.length(); i++){
            s[i] = tolower(s[i]);
        }
        cout << s << '\n';
    }
}