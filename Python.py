import math
import re

str = "222.111.111.1113"
list = str.split(".")
print(list)

if len(list) > 4 or len(list) < 4 :
    print("false")
else :
    for i in range(0, len(list)) :
        if int(list[i]) > 255  or  int(list[i]) < 0 :
            print("false")
            break
    print("true")
print(max(3, 8, 5))

n = 2147483648
ans = (2 ** (math.floor(math.log2(n))+1)) + ~n
# print(ans, ~n, math.floor(2 ** (math.log2(n)+1)), 2 ** (math.log2(n)))
# print(math.log2(2147483648))
print((2 ** (math.floor(math.log2(n))+1)))
print(~n)
print(ans)

str = "   foo   bar   "
print(str.split())

# write a fucntion to find gcd of two numbers

    
