        MOV X, 10
        MOV Y, 20
        JMS INMULTIRE
        HLT
INMULTIRE MUL X, 10
        SUB Y,1
        CMP Y, 1
        BNE INMULTIRE
        RET
