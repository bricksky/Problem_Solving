#include <iostream>
#include <vector>
#include <sstream>

using namespace std;

int main(){
    int n;
    cin >> n;
    cin.ignore();

    for(int i=1; i<=n; i++){
        string list;
        getline(cin, list);

        stringstream ss(list);
        vector<string> v;

        while(ss >> list)
        v.push_back(list);

        cout << "Case #" << i << ": ";
        for(int j=v.size()-1; j>=0; j--){
            cout << v[j];
            if(j >0){
                cout << " ";
            }
        }
        cout << '\n';
    }
    return 0;
}