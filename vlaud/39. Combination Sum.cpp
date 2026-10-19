#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
    vector<vector<int>> combinationSum(vector<int>& candidates, int target)
    {
        vector<vector<int>> res;
        vector<int> nums;
        findcomb1(res, candidates, nums, 0, 0, target);
        //findcomb1(res, candidates, nums, 0, 0, target);
        return res;
    }

    // for 반복문 O
    void findcomb1(vector<vector<int>>& res, vector<int>& cand, vector<int>& nums, int idx, int sum, int& target)
    {
        // 누적 합이 target보다 크면 빠져나감
        if (sum > target) return;

        // 누적 합이 target과 같으면 현재 배열 조합을 삽입
        if (sum == target)
        {
            res.emplace_back(nums);
            return;
        }

        for (int i = idx; i < cand.size(); i++)
        {
            // 조합 배열에 현재 원소 삽입
            nums.emplace_back(cand[i]);
            // 누적합에 현재 원소를 더한 값을 재귀검사
            findcomb1(res, cand, nums, i, sum + cand[i], target);
            // 현재 원소 삭제
            nums.pop_back();
        }
    }

    // for 반복문 X
    void findcomb2(vector<vector<int>>& res, vector<int>& cand, vector<int>& nums, int idx, int sum, int& target)
    {
        // 현재 검사 인덱스가 배열 밖이거나 누적 합이 target보다 크면 빠져나감
        if (idx == nums.size() || sum > target) return;

        // 누적 합이 target과 같으면 현재 배열 조합을 삽입
        if (sum == target)
        {
            res.emplace_back(nums);
            return;
        }

        // 조합 배열에 현재 원소 삽입
        nums.emplace_back(cand[idx]);
        // 누적합에 현재 원소를 더한 값을 재귀검사
        findcomb2(res, cand, nums, idx, sum + cand[idx], target);
        // 현재 원소 삭제
        nums.pop_back();
        // 현재 원소를 뺀 조합을 다시 재귀 검사
        findcomb2(res, cand, nums, idx+1, sum, target);
    }
};