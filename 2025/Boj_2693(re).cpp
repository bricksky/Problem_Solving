#include <bits/stdc++.h>

using namespace std;

int main(){
    ios_base::sync_with_stdio(0); cin.tie(0);

    vector<int> v(10);
    int t;

    cin >> t;

    while(t--){
        for(int i=0; i<10; i++){
            cin >> v[i];
            sort(v.begin(), v.end());
            cout << v[7] << endl;
        }
    }
}