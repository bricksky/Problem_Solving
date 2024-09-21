#include <iostream>
using namespace std;

int arr1[101][101], arr2[101][101];

int main(){
    int n, m;

    cin >> n >> m;

    for(int i=0; i<n; i++){
        for(int a=0; a<m; a++){
            cin >> arr1[i][a];
        }
    }

   for(int i=0; i<n; i++){
        for(int a=0; a<m; a++){
            cin >> arr2[i][a];
        }
    }

    for(int i=0; i<n; i++){
        for(int a=0; a<m; a++){
            cout << arr1[i][a] + arr2[i][a] << " ";
        }
        cout << '\n'; 
    }
    return 0;
}