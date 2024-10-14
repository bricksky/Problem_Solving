#include <iostream>
#include <vector>

using namespace std;

int main(){
    int n;
    cin >> n;

    while(n--){
        string a,b;
        cin >> a >> b;

        vector<int> count(26);

        for(int i=0; i<a.size(); i++){
            count[a[i] - 'a']++;
        }
          for(int i=0; i<b.size(); i++){
            count[b[i] - 'a']--;
        }

        bool flag = true;

        for(int i=0; i<26; i++){
            if(count[i] != 0){
                flag = false;
            }
        }
        cout << (flag ? "Possible" : "Impossible") << '\n';
    }
}