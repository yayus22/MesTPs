back:    DECI ope1,d
         DECI ope2,d
         LDA  ope1,d
         CPA  ope2,d
         BRGT finish

         DECO ope2,d 
         BR back

finish: DECO ope1,d




         STOP
ope1:    .WORD 0
ope2:    .WORD 0
         .END