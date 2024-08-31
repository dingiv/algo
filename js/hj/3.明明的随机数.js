const readline = require('readline')

async function readArgs() {
   const rl = readline.createInterface({
      input: process.stdin,
      output: process.stdout
   })
   let dataCount = 0;
   let dataArray = [];
   let lineIndex = 0;

   return new Promise((s, r) => {
      rl.on('line', (line) => {
         if (lineIndex === 0) {
            dataCount = parseInt(line, 10);
         } else {
            dataArray.push(parseInt(line, 10));
         }

         lineIndex++;

         if (lineIndex > dataCount) {
            rl.close()
            s(dataArray)
         }
      })
   })
}


function deduplicate(args) {
   const arr = Array.from(new Set(args))
   return arr.sort((a, b) => a - b)
}


readArgs()
   .then(deduplicate)
   .then(x => x.join('\n'))
   .then(console.log)