# day05 内容

字符串的处理方法
+ 普通字符的拼接和拆分
+ 正则表达式

 
正则的原理 —>自动机 —>是有限状态机的数学模型  
可分为  
+ 确定有限自动机(DFA)
+ 非确定有限自动机(NFA)

正则属于其二，

其他常用的状态机
+ AC状态机
+ KMP状态机(KMP算法)
+ 图灵机

自动机可以表示为5-元组(Q,Σ,δ,q0,F)

Q 是状态的集合。
∑ 是符号的有限集合，我们称为这个自动机接受的语言的字母表。
δ 是转移函数，就是(对于非确定自动机，空串是允许的输入)。
q0 是开始状态，就是说自动机在还未处理输入的时候的状态(明显的 q0∈ Q)。
F 是叫做终止状态的 Q 中的状态的集合(就是 F⊆Q)。


| 符号      | 意义                              |
| --------- | --------------------------------- |
| .         | 除换行符以外的所有字符。          |
| ^         | 字符串开头。                      |
| $         | 字符串结尾。                      |
| \d,\w,\s  | 匹配数字、字符、空格。            |
| \D,\W,\S  | 匹配非数字、非字符、非空格。      |
| [abc]     | 匹配 a、b 或 c 中的一个字母。     |
| [a-z]     | 匹配 a 到 z 中的一个字母。        |
| [^abc]    | 匹配除了 a、b 或 c 中的其他字母。 |
| aa \| bb  | 匹配 aa 或 bb。                   |
| ?         | 0 次或 1 次匹配。                 |
| *         | 匹配 0 次或多次。                 |
| +         | 匹配 1 次或多次。                 |
| {n}       | 匹配 n次。                        |
| {n,}      | 匹配 n次以上。                    |
| {m,n}     | 最少 m 次，最多 n 次匹配。        |
| (expr)    | 捕获 expr 子模式,以 \1 使用它。   |
| (?:expr)  | 忽略捕获的子模式。                |
| (?=expr)  | 正向肯定预查模式 expr。           |
| (?!expr)  | 正向否定预查模式 expr。           |
| (?<=expr) | 反向肯定预查模式 expr。           |
| (?<!expr) | 反向否定预查模式 expr。           |

`(?<=pattern1).+(?=pattern2)`用于匹配以pattern1开头以pattern2结尾的内容

正则表达式的工具网站 https://c.runoob.com/front-end/854/


VSCode + LeetCode 插件刷题初体验，
遇到了一个烂题，开门红，但是也借此学会了自动机的编码思想，
可以用于处理字符匹配的问题和有限输入流的问题

## 模拟自动机 
用于处理有限且确定种类的输入流和有限且确定的状态类型的输入流问题，特别适合处理字符；

自动机的核心要素有状态表State、输入字母表Alpha、转移矩阵Table(或者转移函数表)；其他辅助要素有字母拾取函数getAlpha，起始状态值q0，终止状态值Fi;
+ 状态表是一个有限的枚举列表，枚举了所有的状态，该列表一般具体实现为一个整型数组，每个数字对应一种状态；
+ 输入字母表是一个有限的枚举列表，枚举了所有可能的输入类型，该列表一般具体实现为一个整型数组，每个数字对应一种输入类型；
+ 转移矩阵是一个矩阵，每个矩阵的厄每一列代表一种状态下，若接受某种字母后需要跳转的类型，具体实现时：
这个矩阵的元素类型可以是状态值的类型，如整型，也可以是返回状态值类型的函数，也就是转移函数；
+ 字母拾取函数可以将无限的或者更多的输入转换为字母表中存在的字母，或者规格化输入内容，使得所有的输入满足字母表的要求范围；实现为一个
接受实际问题的输入序列内容的类型，并返回状态类型，如整型，的函数;
+ 起始状态值是一个状态值，它是State的子元素之一；在状态机开始工作时被赋予这个值，表示状态机处于初始状态；
+ 终止状态是一个状态值集合，它是State的子集；在状态机结束工作之后，被赋予的最终状态；