#include <iostream>

using namespace std;
    int a, x, y;
    int maxi = -1;

int main(){
   for(int i=1; i<9; i++){
        for(int j=1; j<9; j++){
            cin >> a;

            if(maxi <= a){
                maxi = a;
                x = i;
                y = j;
            }
        }
   }
   cout << maxi << '\n';
   cout << x << ' ' << y;

   return 0;
}
