#include <iostream>
#include <algorithm>

using namespace std;

int main(){
  int n, b;
  string result;

  cin >> n >> b;

  while(n){
    if(n % b >= 0 && n % b <=9){
        result += char(n % b + 48);
    } else {
        result += char((n % b + 'A')-10);
    } n /= b;
  }

  for(int i = result.length()-1; i>=0; i--){
    cout << result[i];
  }

  return 0;
}