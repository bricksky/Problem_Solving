// #include <iostream>
// #include <algorithm>
// #include <vector>

// using namespace std;

// int main(){
//     int n;
//     cin >> n;

//     vector<int> numbers(n);

//     for(int i=0; i<n; i++){
//         cin >> numbers[i];
//     }

//     sort(numbers.begin(), numbers.end());

//     for(int i=0; i<n; i++){
//         cout << numbers[i] << '\n';
//     }
//     return 0;
// }

#include <iostream>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);

    int n;
    cin >> n;

    int count[10001] = {0};

    for (int i = 0; i < n; i++) {
        int num;
        cin >> num;
        count[num]++;
    }
    
    for (int i = 1; i <= 10000; i++) {
        while (count[i] > 0) {
            cout << i << '\n';
            count[i]--;
        }
    }

    return 0;
}
