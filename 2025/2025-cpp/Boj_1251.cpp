#include <iostream>
#include <string>
#include <algorithm>


using namespace std;

int main(){
    string s;
    cin >> s;

    int n = s.size();
    string result(n, 'z');

    for(int i=1; i<n-1; i++){
        for(int j=i+1; j<n; j++){
            string a = s.substr(0, i);
            string b = s.substr(i, j-i);
            string c = s.substr(j, n-j);

            reverse(a.begin(), a.end());
            reverse(b.begin(), b.end());
            reverse(c.begin(), c.end());

            string combined = a + b + c;

            if(combined < result){
                result = combined;
            }
        }
    }
    cout << result << endl;
    return 0;
}
