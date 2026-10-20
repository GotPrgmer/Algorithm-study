#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& it) {
        const int n = it.size();
        // 오름차순 정렬
        sort(begin(it), end(it));
        vector<vector<int>> res;

        // 배열에 첫번째 원소 삽입
        res.emplace_back(it[0]);
        for (int i = 1; i < n; i++)
        {
            if (res.back()[1] < it[i][0]) res.emplace_back(it[i]); // 만약 res의 맨 뒤 원소의 뒷자리가 it의 앞자리보다 작으면 it의 현재 원소 삽입
            else res.back()[1] = max(res.back()[1], it[i][1]); // 범위가 겹치면 res 맨 뒤 원소의 뒷자리를 큰 값으로 갱신
        }

        return res;
    }
};