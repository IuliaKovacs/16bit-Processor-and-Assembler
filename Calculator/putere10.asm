        MOV X, 10
        MOV Y, 33
        JMS INMULTIRE
        HLT
INMULTIRE: MUL X, 10
        SUB Y,1
        CMP Y, 1
        BNE INMULTIRE
        RET
