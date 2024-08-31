function lengthOfLIS(nums) {
   if (nums.length === 0) return 0;

   const dp = new Array(nums.length).fill(1);

   for (let i = 1; i < nums.length; i++) {
      for (let j = 0; j < i; j++) {
         nums[j] < nums[i] && dp[j] + 1 > dp[i] && (dp[i] = dp[j] + 1)
      }
   }

   return Math.max(...dp);
}

// 测试
const nums = [10, 9, 2, 5, 3, 7, 101, 18];
console.log(lengthOfLIS(nums)); // 输出: 4 (最长递增子序列为 [2, 3, 7, 101])
