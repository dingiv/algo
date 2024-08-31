function combine(nums, m) {
   const result = [];
   const path = []

   function dfs(start) {
      if (path.length === m) {
         result.push([...path]);
         return;
      }

      for (let i = start; i < nums.length; i++) {
         path.push(nums[i]);
         dfs(i + 1);
         path.pop();
      }
   }

   dfs(0);
   return result;
}

// 测试
const nums = [1, 2, 3, 4, 5];
const m = 3;
const combinations = combine(nums, m);
console.log(combinations);
// 输出: [
//   [1, 2],
//   [1, 3],
//   [1, 4],
//   [2, 3],
//   [2, 4],
//   [3, 4]
// ]
