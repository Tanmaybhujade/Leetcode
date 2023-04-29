class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        int size = nums.size();
        vector<int> left(size, 0), right(size, 0), output;
        left[0] = 1, right[size - 1] = 1;
        //get the product for all the left side array
        for(int i = 0; i < size - 1; i++)
            left[i + 1] = nums[i]*left[i];
        //get the product for all the right side array 
        for(int i = size - 2; i > -1; i--)
            right[i] = right[i+1]*nums[i + 1];
        
        for(int i = 0; i < size; i++){
            output.push_back(left[i]*right[i]);
        }
        
        return output;
    }
};
