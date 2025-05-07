#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int main(){
    int n, x, y;
    vector<pair<int, int> > v;
    cin >> n;

    for(int i=0; i<n; i++){
        cin >> x >> y;
        v.push_back(make_pair(x, y));
        // v.push_back({x, y}); // 괄호를 사용한 초기화
    }

    sort(v.begin(), v.end());

    for(int i=0; i<n; i++){
        cout << v[i].first << " " << v[i].second << '\n';
    }
    return 0;
}