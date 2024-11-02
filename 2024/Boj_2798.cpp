#include <iostream>

using namespace std;

int main(){
    int n, m;
    int sum;
    int result = 0;
    
    cin >> n >> m;

    int cards[n];

    for(int i=0; i<n; i++){
        cin >> cards[i];
    }

    for(int i=0; i<n; i++){
        for(int j=i+1; j<n; j++){
            for(int k=j+1; k<n; k++){
                sum = cards[i] + cards[j] + cards[k];
                if(sum>result && sum<=m){
                    result = sum;
                }
            }
        }
    }
    cout << result;
    return 0;
}