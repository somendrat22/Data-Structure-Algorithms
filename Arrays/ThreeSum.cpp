class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        vector<vector<int>> ans;
        int prev;
        for(int i = 0; i<nums.size()-1; i++){
            int tgt = -nums[i];
            int st = i + 1;
            int en = nums.size() - 1;
            while(st < en){
                int sum = nums[st] + nums[en];
                if(sum == tgt){
                    vector<int> twoSum;
                    twoSum.push_back(nums[i]);
                    twoSum.push_back(nums[st]);
                    twoSum.push_back(nums[en]);
                    ans.push_back(twoSum);
                    while(st + 1 < nums.size() && nums[st] == nums[st + 1]){
                        st++;
                    }
                    st++;
                    en--;
                    
                }else if(sum < tgt){
                    st++;
                }else{
                    en--;
                }
            }
            while(i + 1 < nums.size() && nums[i + 1] == nums[i]){
                i++;
            }
        }
        
        return ans;
    }
};