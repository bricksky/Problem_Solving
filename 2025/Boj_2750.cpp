#include <iostream>
#include <algorithm>


using namespace std;

int main(){
    int n;
    int num[1001];

    cin >> n;

    for(int i=0; i<n; i++){
        cin >> num[i];
    }

    sort(num, num+n);

    for(int i=0; i<n; i++){
        cout << num[i] << endl;
    }

    return 0;
}