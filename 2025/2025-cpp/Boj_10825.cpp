#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

struct score {
    string name;
    int kor, eng, math;
};

bool compare(score a, score b){
    if(a.kor==b.kor && a.eng==b.eng && a.math==b.math){
        return a.name < b.name;
    } else if (a.kor == b.kor && a.eng==b.eng){
        return a.math > b.math;
    } else if (a.kor == b.kor){
        return a.eng < b.eng;
    } else {
        return a.kor > b.kor;
    }
}

int main(){
    int n, k, e, m;
    string name;
    vector<score> v;

    cin >> n;

    for(int i=0; i<n; i++){
        cin >> name >> k >> e >> m;

        score s;
        s.name = name;
        s.kor = k;
        s.eng = e;
        s.math = m;

        v.push_back({s.name, s.kor, s.eng, s.math});
    }

    sort(v.begin(), v.end(), compare);

    for(int i=0; i<n; i++){
        cout << v[i].name << "\n";
    }
    return 0;
}