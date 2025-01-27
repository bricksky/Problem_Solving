#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int main(){
   int n, m;
   cin >> n >> m;

    vector<int> merged(n + m);  

    for(int i=0; i<n; i++){
        cin >> merged[i];
    }

    for(int i=n; i<n+m; i++){
        cin >> merged[i];
    }

    sort(merged.begin(), merged.end());

    for(int num : merged){
        cout << num << " ";
    }

}
