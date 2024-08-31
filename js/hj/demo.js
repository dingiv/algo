const rl = require("readline").createInterface({ input: process.stdin });

function readArgs() {
   return new Promise((read) => {
      let count = 0
      let index = 0
      rl.on('line', (line) => {
         if (index++ === 0) count = parseInt(line)
         else {
            const arr=line.split(' ').map(Number)
            read([count,arr])
         }
      })
   })
}

function longestSubstr([count, arr]) {
   console.log(count,arr)
   const dp = Array(count).fill(1);

   for (let i = 1; i < count; ++i) {
      for (let j = i - 1; j >= 0; --j) {
         if (arr[i] > arr[j]) {
            dp[i] = Math.max(dp[i], dp[j] + 1);
         }
      }
   }

   return Math.max(...dp);
}

readArgs().then(longestSubstr).then(console.log);
