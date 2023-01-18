        MOV X, 2
        MOV Y, 2
        JMS INMULTIRE
        HLT
INMULTIRE: MUL X, 2
        SUB Y,1
        CMP Y, 1
        BRO INMULTIRE
        RET
