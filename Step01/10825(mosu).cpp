#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

struct Student
{
    string name;
    int kor, eng, math;
    Student(string name, int kor, int eng, int math) : name(name), kor(kor), eng(eng), math(math) {}
};

bool comp(Student a, Student b)
{
    if (a.kor == b.kor && a.eng == b.eng && a.math == b.math)
    {
        return a.name < b.name;
    }
    if (a.kor == b.kor && a.eng == b.eng)
    {
        return a.math > b.math;
    }
    if (a.kor == b.kor)
    {
        return a.eng < b.eng;
    }
    return a.kor > b.kor;
}

int main()
{
    int N;
    cin >> N;
    string name;
    int kor, eng, math;
    vector<Student> v;
    for (int i = 0; i < N; i++)
    {
        cin >> name;
        cin >> kor >> eng >> math;
        v.push_back(Student(name, kor, eng, math));
    }

    sort(v.begin(), v.end(), comp);
    for (int i = 0; i < v.size(); i++)
    {
        cout << v[i].name << '\n';
    }
}