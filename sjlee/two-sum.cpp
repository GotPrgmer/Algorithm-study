
// https://leetcode.com/problems/two-sum/
class Solution
{
public:
    vector<int> twoSum(vector<int> &nums, int target)
    {
        for (int i = 0; i <= nums.size() - 2; ++i)
        {
            int remain = target - nums[i];
            auto it = find(nums.begin() + i + 1, nums.end(), remain);
            if (it != nums.end())
            {
                int remainIdx = it - nums.begin();
                return {i, remainIdx};
            }
        }
        return {}; // fallback, not reached
    }
};