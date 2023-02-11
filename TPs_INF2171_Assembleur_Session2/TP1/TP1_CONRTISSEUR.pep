; Yaya NIARE (NIAY84360305) && Ned Deluscar (DELN14049806)
;Ce programme un convertie un décimal en une base entre 2 et 36 selon le choix de l'utilisateur.
         LDX     0,i  
         STRO    m_s_n,d     ;
         DECI    nbr,d 
;
loop1:   LDA     0,i         ; while (nombre < 0)
         ADDA    nbr,d
         BRGE    floop1
;         
         STRO    msg_e,d     ;System.out.println(MSG_ERR + "\n");
         STRO    m_s_n,d     ;System.out.println(MSG_SOL)
         DECI    nbr,d
         LDA     0,i
         BR      loop1
;
floop1:  STRO    nextl,d     ;NextLine
         LDA     nbr,d
         CPA     32767,i
         BRGT    loop1
;
         STRO    m_s_b,d     ;System.out.println(MSG_SOL_BASE)
         DECI    base,d
;
loop2:   LDA     -2,i        ; while (base < 2)
         ADDA    base,d
         BRGE    loop3
;
         STRO    msg_e,d     ;System.out.println(MSG_ERR + "\n")
         STRO    m_s_b,d     ;System.out.println(MSG_SOL_BASE)
         DECI    base,d     
         BR      loop2 
;
loop3:   LDA     36,i        ; while (base > 36)
         SUBA    base,d
         BRGE    floop23 
;
         STRO    msg_e,d     ;System.out.println(MSG_ERR + "\n");
         STRO    m_s_b,d     ;System.out.println(MSG_SOL_BASE)
         DECI    base,d   
         BR      loop2
;
floop23: LDA     nbr,d
;
calcul:  CPA     base,d      ;while(nombre >= BASE)
         BRLT    fcalcul     
;
         SUBA    base, d     ;nombre = nombre - BASE
         ADDX    0x0001,i    ;Quotient++
         BR      calcul 
;         
fcalcul: STX     quot, d
         STA     reste, d
         LDX     cont,d
         STA     tab,x
         ADDX    2,i
         STX     cont,d
         LDX     0,i
         LDA     0,i
         LDA     quot,d
         CPA     base,d
         BRGE    calcul
;     
         DECO    quot,d
;         
fin2:    LDX     cont,d  
         SUBX    2,i 
loop5:   BRLT    done 
         DECO    tab,x
         SUBX    2,i 
         BR      loop5
;
done:    STOP
;
m_s_n:   .ASCII "Entrez un nombre positif svp: \x00"
msg_e:   .ASCII "Entrée invalide \n\x00"
m_s_b:   .ASCII "Entrez une base de conversion (un nombre de 2 à 36): \x00"
nextl:   .ASCII "\n\x00"
nbr:     .WORD 0
base:    .WORD 0
reste:   .BLOCK 2
quot:    .BLOCK 2
cont:    .WORD 0
tab:     .BLOCK  10
len:     .EQUATE 10              
         .END