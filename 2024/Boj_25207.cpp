#include <iostream>

using namespace std;

int main(){
    double total_credit = 0;   // 들은 학점의 총 합
    double total = 0;  // 받은 성적과 과목 학점 곱의 합

    for(int i=0; i<20; ++i){
        string name;
        double credit;
        string grade;

        cin >> name >> credit >> grade;

        if(grade=="P"){
            continue;
        } else if (grade == "A+"){
            total += credit * 4.5;
            total_credit += credit;
        } else if (grade == "A0"){
            total += credit * 4.0;
            total_credit += credit;
        } else if (grade == "B+"){
            total += credit * 3.5;
            total_credit += credit;
        } else if (grade == "B0"){
            total += credit * 3.0;
            total_credit += credit;
        } else if (grade == "C+"){
            total += credit * 2.5;
            total_credit += credit;
        } else if (grade == "C0"){
            total += credit * 2.0;
            total_credit += credit;
        } else if (grade == "D+"){
            total += credit * 1.5;
            total_credit += credit;
        } else if (grade == "D0"){
            total += credit * 1.0;
            total_credit += credit;
        } else if (grade == "F"){
            total += credit * 0.0;
            total += credit;
        }
    }

    double finalResult = total / total_credit;
    cout << fixed;
    cout.precision(6);
    cout << finalResult;

    return 0;
}