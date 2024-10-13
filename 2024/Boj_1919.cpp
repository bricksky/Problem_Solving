#include <iostream>
#include <cstring>

using namespace std;
int main(){
    ios::sync_with_stdio(0);
    string s1, s2;
    cin >> s1 >> s2;

    int alphabet1[26] = {};
    int alphabet2[26] = {};

    for(int i=0; i<s1.length(); i++){
        alphabet1[s1[i] - 'a']++;
    }

    for(int i=0; i<s1.length(); i++){
        alphabet2[s2[i] - 'a']++;
    }

    int result = 0;
    for(int i=0; i<26; i++){
        if(alphabet1[i] != alphabet2[i]){
            result += abs(alphabet1[i] - alphabet2[i]);
        }
    }
    cout << result;
    return 0;
}