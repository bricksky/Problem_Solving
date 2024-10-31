#include <iostream>

using namespace std;

int main(){
    int count;
    int h, w, n;
    int result;

    cin >> count;

    for(int i=0; i<count; i++){
        cin >> h >> w >> n;
    if(n%h == 0){
        result = h*100 + (n/h);
    } else {
        result = (n%6) * 100 + (n/6)+1;
    }
    cout << result << '\n';
    }
    return 0;
}