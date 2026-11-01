#include <iostream>
#include <vector>
#include <algorithm>
#include <unordered_set>

using namespace std;

// 세트를 이용한 중복 체크
class Solution {
public:
    bool containsDuplicate(vector<int>& nums) {
        unordered_set<int> mp;
        for (int& i : nums)
        {
			// 이미 세트에 존재하는 값이면 중복이므로 true 반환
            if (mp.contains(i)) return true;
			// 세트에 값을 추가
            mp.insert(i);
        }

        return false;
    }
};