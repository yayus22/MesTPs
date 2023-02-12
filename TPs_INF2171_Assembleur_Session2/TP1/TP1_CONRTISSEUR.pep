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
calcul:  CPA     base,d      ;if(nombre >= BASE)
         BRLT    fcalcul     ;goto fcalcul
;
         SUBA    base, d     ;nombre = nombre - BASE
         ADDX    0x0001,i    ;Quotient++
         BR      calcul 
;         
fcalcul: STX     quot, d     ;quot = X
         STA     reste, d    ;reste = A
         LDX     cont,d      ;X = cont    
         STA     tab,x       ;tab[X] = A
         ADDX    2,i         ;X = X + 2
         STX     cont,d      ;X = cont
         LDX     0,i         ;X = 0
         LDA     0,i         ;A = 0
         LDA     quot,d      ;A = quot
         CPA     base,d      
         BRGE    calcul      ;while (A >= base)
;     
         LDA     quot,d      ;A = quot
         LDX     cont,d      ;X = cont
         STA     tab,x       ;tab[X] = A
         ADDX    2,i         ;X = X + 2
         STX     cont,d
         LDX     0,i
;         
fin2:    LDX     cont,d      ;X = cont
         SUBX    2,i         ;X = X - 2
loop5:   BRLT    done        ;goto done
         LDA     10,i
         CPA     tab,x       ;if(tab[X] = 10)
         BRNE    A           ;goto A
         STRO    As,d        ;else System.out.print("A")
         SUBX    2,i         ;X = X - 2
         BR      loop5       
A:       LDA     11,i        
         CPA     tab,x       ;if(tab[X] = 11)
         BRNE    B           ;goto B
         STRO    Bs,d        ;else System.out.print("B")
         SUBX    2,i         ;X = X - 2
         BR      loop5
B:       LDA     12,i        
         CPA     tab,x       ;if(tab[X] = 12)
         BRNE    C           ;goto C
         STRO    Cs,d        ;else System.out.print("C")
         SUBX    2,i         ;X = X - 2
         BR      loop5
C:       LDA     13,i
         CPA     tab,x       ;if(tab[X] = 13)
         BRNE    D           ;goto D
         STRO    Ds,d        ;else System.out.print("D")
         SUBX    2,i         ;X = X - 2
         BR      loop5
D:       LDA     14,i
         CPA     tab,x       ;if(tab[X] = 14)
         BRNE    E           ;goto E
         STRO    Es,d        ;else System.out.print("E")
         SUBX    2,i         ;X = X - 2
         BR      loop5
E:       LDA     15,i        
         CPA     tab,x       ;if(tab[X] = 15)
         BRNE    F           ;goto F
         STRO    Fs,d        ;else System.out.print("F")
         SUBX    2,i         ;X = X - 2
         BR      loop5
F:       LDA     16,i 
         CPA     tab,x       ;if(tab[X] = 16)
         BRNE    G           ;goto G
         STRO    Gs,d        ;else System.out.print("G")
         SUBX    2,i         ;X = X - 2
         BR      loop5
G:       LDA     17,i 
         CPA     tab,x       ;if(tab[X] = 17)
         BRNE    H           ;goto H
         STRO    Hs,d        ;else System.out.print("H")
         SUBX    2,i
         BR      loop5
H:       LDA     18,i 
         CPA     tab,x       ;if(tab[X] = 18)
         BRNE    I           ;goto I
         STRO    Is,d        ;else System.out.print("I")
         SUBX    2,i         ;X = X - 2
         BR      loop5
I:       LDA     19,i 
         CPA     tab,x       ;if(tab[X] = 19)
         BRNE    J           ;goto J
         STRO    Js,d        ;else System.out.print("J")
         SUBX    2,i         ;X = X - 2
         BR      loop5
J:       LDA     20,i 
         CPA     tab,x       ;if(tab[X] = 20)
         BRNE    K           ;goto K
         STRO    Ks,d        ;else System.out.print("K")
         SUBX    2,i         ;X = X - 2
         BR      loop5
K:       LDA     21,i 
         CPA     tab,x       ;if(tab[X] = 21)
         BRNE    L           ;goto L
         STRO    Ls,d        ;else System.out.print("L")
         SUBX    2,i         ;X = X - 2
         BR      loop5
L:       LDA     22,i 
         CPA     tab,x       ;if(tab[X] = 22)
         BRNE    M           ;goto M
         STRO    Ms,d        ;else System.out.print("M")
         SUBX    2,i         ;X = X - 2
         BR      loop5
M:       LDA     23,i 
         CPA     tab,x       ;if(tab[X] = 23)
         BRNE    N           ;goto N
         STRO    Ns,d        ;else System.out.print("N")
         SUBX    2,i         ;X = X - 2
         BR      loop5
N:       LDA     24,i 
         CPA     tab,x       ;if(tab[X] = 24)
         BRNE    O           ;goto O
         STRO    Os,d        ;else System.out.print("O")
         SUBX    2,i         ;X = X - 2
         BR      loop5
O:       LDA     25,i 
         CPA     tab,x       ;if(tab[X] = 25)
         BRNE    P           ;goto P
         STRO    Ps,d        ;else System.out.print("P")
         SUBX    2,i         ;X = X - 2
         BR      loop5
P:       LDA     26,i 
         CPA     tab,x       ;if(tab[X] = 26)
         BRNE    Q           ;goto Q
         STRO    Qs,d        ;else System.out.print("Q")
         SUBX    2,i         ;X = X - 2
         BR      loop5
Q:       LDA     27,i 
         CPA     tab,x       ;if(tab[X] = 27)
         BRNE    R           ;goto R
         STRO    Rs,d        ;else System.out.print("R")
         SUBX    2,i         ;X = X - 2
         BR      loop5
R:       LDA     28,i 
         CPA     tab,x       ;if(tab[X] = 28)
         BRNE    S           ;goto S
         STRO    Ss,d        ;else System.out.print("S")
         SUBX    2,i         ;X = X - 2
         BR      loop5
S:       LDA     29,i 
         CPA     tab,x       ;if(tab[X] = 29)
         BRNE    T           ;goto T
         STRO    Ts,d        ;else System.out.print("T")
         SUBX    2,i         ;X = X - 2
         BR      loop5
T:       LDA     30,i 
         CPA     tab,x       ;if(tab[X] = 30)
         BRNE    U           ;goto U
         STRO    Us,d        ;else System.out.print("U")
         SUBX    2,i         ;X = X - 2
         BR      loop5
U:       LDA     31,i 
         CPA     tab,x       ;if(tab[X] = 31)
         BRNE    V           ;goto V
         STRO    Vs,d        ;else System.out.print("V")
         SUBX    2,i         ;X = X - 2
         BR      loop5
V:       LDA     32,i 
         CPA     tab,x       ;if(tab[X] = 32)
         BRNE    W           ;goto W
         STRO    Ws,d        ;else System.out.print("W")
         SUBX    2,i         ;X = X - 2
         BR      loop5
W:       LDA     33,i 
         CPA     tab,x       ;if(tab[X] = 33)
         BRNE    X           ;goto X
         STRO    Xs,d        ;else System.out.print("X")
         SUBX    2,i         ;X = X - 2
         BR      loop5
X:       LDA     34,i 
         CPA     tab,x       ;if(tab[X] = 34)
         BRNE    Y           ;goto Y
         STRO    Ys,d        ;else System.out.print("Y")
         SUBX    2,i         ;X = X - 2
         BR      loop5
Y:       LDA     35,i 
         CPA     tab,x       ;if(tab[X] = 35)
         BRNE    Rr          ;goto Z
         STRO    Zs,d        ;else System.out.print("Z")
         SUBX    2,i         ;X = X - 2
         BR      loop5
Rr:      DECO    tab,x       ;else System.out.print(tab[X])
         SUBX    2,i         ;X = X - 2
         BR      loop5       ;while(cont =! 0)
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