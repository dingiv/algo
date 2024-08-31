const readline = require('readline')


async function readArgs() {
   const rl = readline.createInterface({
      input: process.stdin,
      output: process.stdout
   })

   let n = await new Promise((s) => rl.once('line', s))
   n = parseInt(n, 10)

   let arr = await new Promise(s => rl.once('line', s))
   arr = arr.split(' ').map(x => parseInt(x, 10))

   return [n, arr]
}

// { id: , depsId: , depedSet: }

function getMax([count, arr]) {
   const dp = []
   for (let i = 0; i < count; ++i) {
      const deps = dp[arr[i]]
      resolveDeps(deps,)

   }

   function resolveDeps(deped, deping) {
      if (deped !== undefined) {
         deped.depedSet.add(i)
      } else {
         deped = {

         }
      }
      return deped
   }


   return arr.map(x => x + count)
}



readArgs()
   .then(getMax)
   .then(x => x.join('\n'))
   .then(console.log)