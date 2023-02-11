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
         LDA     quot,d
         LDX     cont,d
         STA     tab,x
         ADDX    2,i
         STX     cont,d
         LDX     0,i
;         
fin2:    LDX     cont,d  
         SUBX    2,i 
loop5:   BRLT    done
         LDA     10,i
         CPA     tab,x
         BRNE    A
         STRO    As,d
         SUBX    2,i
         BR      loop5
A:       LDA     11,i
         CPA     tab,x
         BRNE    B
         STRO    Bs,d
         SUBX    2,i
         BR      loop5
B:       LDA     12,i
         CPA     tab,x
         BRNE    C
         STRO    Cs,d
         SUBX    2,i
         BR      loop5
C:       LDA     13,i
         CPA     tab,x
         BRNE    D
         STRO    Ds,d
         SUBX    2,i
         BR      loop5
D:       LDA     14,i
         CPA     tab,x
         BRNE    E
         STRO    Es,d
         SUBX    2,i
         BR      loop5
E:       LDA     15,i 
         CPA     tab,x
         BRNE    F
         STRO    Fs,d
         SUBX    2,i
         BR      loop5
F:       LDA     16,i 
         CPA     tab,x
         BRNE    G
         STRO    Gs,d
         SUBX    2,i
         BR      loop5
G:       LDA     17,i 
         CPA     tab,x
         BRNE    H
         STRO    Hs,d
         SUBX    2,i
         BR      loop5
H:       LDA     18,i 
         CPA     tab,x
         BRNE    I
         STRO    Is,d
         SUBX    2,i
         BR      loop5
I:       LDA     19,i 
         CPA     tab,x
         BRNE    J
         STRO    Js,d
         SUBX    2,i
         BR      loop5
J:       LDA     20,i 
         CPA     tab,x
         BRNE    K
         STRO    Ks,d
         SUBX    2,i
         BR      loop5
K:       LDA     21,i 
         CPA     tab,x
         BRNE    L
         STRO    Ls,d
         SUBX    2,i
         BR      loop5
L:       LDA     22,i 
         CPA     tab,x
         BRNE    M
         STRO    Ms,d
         SUBX    2,i
         BR      loop5
M:       LDA     23,i 
         CPA     tab,x
         BRNE    N
         STRO    Ns,d
         SUBX    2,i
         BR      loop5
N:       LDA     24,i 
         CPA     tab,x
         BRNE    O
         STRO    Os,d
         SUBX    2,i
         BR      loop5
O:       LDA     25,i 
         CPA     tab,x
         BRNE    P
         STRO    Ps,d
         SUBX    2,i
         BR      loop5
P:       LDA     26,i 
         CPA     tab,x
         BRNE    Q
         STRO    Qs,d
         SUBX    2,i
         BR      loop5
Q:       LDA     27,i 
         CPA     tab,x
         BRNE    R
         STRO    Rs,d
         SUBX    2,i
         BR      loop5
R:       LDA     28,i 
         CPA     tab,x
         BRNE    S
         STRO    Ss,d
         SUBX    2,i
         BR      loop5
S:       LDA     29,i 
         CPA     tab,x
         BRNE    T
         STRO    Ts,d
         SUBX    2,i
         BR      loop5
T:       LDA     30,i 
         CPA     tab,x
         BRNE    U
         STRO    Us,d
         SUBX    2,i
         BR      loop5
U:       LDA     31,i 
         CPA     tab,x
         BRNE    V
         STRO    Vs,d
         SUBX    2,i
         BR      loop5
V:       LDA     32,i 
         CPA     tab,x
         BRNE    W
         STRO    Ws,d
         SUBX    2,i
         BR      loop5
W:       LDA     33,i 
         CPA     tab,x
         BRNE    X
         STRO    Xs,d
         SUBX    2,i
         BR      loop5
X:       LDA     34,i 
         CPA     tab,x
         BRNE    Y
         STRO    Ys,d
         SUBX    2,i
         BR      loop5
Y:       LDA     35,i 
         CPA     tab,x
         BRNE    Rr
         STRO    Zs,d
         SUBX    2,i
         BR      loop5
Rr:      DECO    tab,x
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
As:    .ASCII "A\x00"
Bs:    .ASCII "B\x00"
Cs:    .ASCII "C\x00"
Ds:    .ASCII "D\x00"
Es:   .ASCII "E\x00"
Fs:   .ASCII "F\x00"
Gs:   .ASCII "G\x00"
Hs:   .ASCII "H\x00"
Is:   .ASCII "I\x00"
Js:   .ASCII "J\x00"
Ks:   .ASCII "K\x00"
Ls:   .ASCII "L\x00"
Ms:   .ASCII "M\x00"
Ns:   .ASCII "N\x00"
Os:   .ASCII "O\x00"
Ps:   .ASCII "P\x00"
Qs:   .ASCII "Q\x00"
Rs:   .ASCII "R\x00"
Ss:   .ASCII "S\x00"
Ts:   .ASCII "T\x00"
Us:   .ASCII "U\x00"
Vs:   .ASCII "V\x00"
Ws:   .ASCII "W\x00"
Xs:   .ASCII "X\x00"
Ys:   .ASCII "Y\x00"
Zs:   .ASCII "Z\x00"              
         .END