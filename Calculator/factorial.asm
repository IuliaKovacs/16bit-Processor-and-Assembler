MOV X,3
JMS FACTORIAL
HLT
FACTORIAL: MUL X,3
SUB X,1
CMP X,1
BRO FACTORIAL
RET