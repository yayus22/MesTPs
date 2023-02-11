;Division entière, calcul du Quotient (Total / Nb) et du Reste
;Entrée des données
            DECI    Total,d
            DECI    Nb, d

            LDA     Total, d    ;Registre A pour Total
            LDX     Quot, d     ;Registre X pour Quot

encore:     CPA     Nb,d 
            BRLT    fin         ;Aller à fin si zéro
            SUBA    Nb, d       
            ADDX    0x0001,i 
            BR      encore
fin:        STX     Quot, d
            STA     Reste, d
            DECO    Quot, d
            CHARO   0x0A,i      ;Ligne suivante         
            DECO    Reste, d            
            STOP

Total:      .WORD   0
Nb:         .WORD   0
Quot:       .WORD   0
Reste:      .WORD   0


            .END