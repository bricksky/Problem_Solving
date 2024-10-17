#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

int main(){
    string a,b;
    cin >> a >> b;

    reverse(a.begin(), a.end());
    reverse(b.begin(), b.end());

    string result = (stoi(a) + stoi(b));
    reverse(result.begin(), result.end());

    cout << stoi(result) << '\n';
}