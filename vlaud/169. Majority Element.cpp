#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
    int majorityElement(vector<int>& nums) {
        // cand: 후보 원소, cnt: 후보와 같은지 여부 카운트
        int cand = nums[0], cnt = 0;

        for (int& i : nums)
        {
            if (!cnt) cand = i; // 만약 카운트가 0이면 후보 변경
            if (i == cand) cnt++; // 현재 원소가 후보와 같다면 카운트 상승
            else cnt--; // 다르면 카운트 하락
        }
        return cand;
    }
};
