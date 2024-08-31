function isValidIPv4(ip) {
   // 正则表达式验证基本格式
   const ipv4Regex = /^(\d+)\.(\d+)\.(\d+)\.(\d+)$/;
   const match = ipv4Regex.exec(ip);
   if (!match) {
       return false;
   }

   // 验证每个部分是否在 0 到 255 之间
   for (let i = 1; i <= 4; i++) {
       const num = Number(match[i]);
       if (num < 0 || num > 255) {
           return false;
       }
   }

   console.log(match)

   return true;
}

console.log(isValidIPv4("192.168.1.1")); // 输出: true