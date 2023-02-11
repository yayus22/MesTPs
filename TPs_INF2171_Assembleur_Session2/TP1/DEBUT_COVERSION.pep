         STRO    m_s_n,d
         DECI    nbr,d 

loop1:   LDA     0,i
         ADDA    nbr,d
         BRGE    fv1
         
         STRO    msg_e,d
         STRO    m_s_n,d
         DECI    nbr,d
         BR      loop1

fv1:     DECO    nbr,d
         STRO    nextl,d

debut:   STRO    m_s_b,d
         DECI    base,d

loop2:   LDA     -2,i
         ADDA    base,d
         BRGE    loop3
         

         STRO    msg_e,d
         BR      debut 



loop3:   LDA     36,i
         SUBA    base,d
         BRGE    fv3

         STRO    msg_e,d
         BR      debut

fv3:     LDA     nbr,d
encore:  CPA     base,d 
         BRLT    fin         ;Aller à fin si zéro
         SUBA    base, d       
         ADDX    0x0001,i 
         BR      encore
fin:     STX     quot, d
         STX     nbr,d
         STA     reste, d
         LDA     10,i
         CPA     reste,d
         BRNE    A
         STRO    As,d
         BR      fin2
A:       LDA     11,i
         CPA     reste,d
         BRNE    B
         STRO    Bs,d
         BR      fin2
B:       LDA     12,i
         CPA     reste,d
         BRNE    C
         STRO    Cs,d
         BR      fin2
C:       LDA     13,i
         CPA     reste,d
         BRNE    D
         STRO    Ds,d
         BR      fin2
D:       LDA     14,i
         CPA     reste,d
         BRNE    E
         STRO    Es,d
         BR      fin2
E:       LDA     15,i
         CPA     reste,d
         BRNE    F
         STRO    Fs,d
         BR      fin2
F:       LDA     16,i
         CPA     reste,d
         BRNE    G
         STRO    Gs,d
         BR      fin2
G:       LDA     17,i
         CPA     reste,d
         BRNE    H
         STRO    Hs,d
         BR      fin2
H:       LDA     18,i
         CPA     reste,d
         BRNE    I
         STRO    Is,d
         BR      fin2
I:       LDA     19,i
         CPA     reste,d
         BRNE    J
         STRO    Js,d
         BR      fin2
J:       LDA     20,i
         CPA     reste,d
         BRNE    K
         STRO    Ks,d
         BR      fin2
K:       LDA     21,i
         CPA     reste,d
         BRNE    L
         STRO    Ls,d
         BR      fin2
L:       LDA     22,i
         CPA     reste,d
         BRNE    M
         STRO    Ms,d
         BR      fin2
M:       LDA     23,i
         CPA     reste,d
         BRNE    N
         STRO    Ns,d
         BR      fin2
N:       LDA     24,i
         CPA     reste,d
         BRNE    O
         STRO    Os,d
         BR      fin2
O:       LDA     25,i
         CPA     reste,d
         BRNE    P
         STRO    Ps,d
         BR      fin2
P:       LDA     26,i
         CPA     reste,d
         BRNE    Q
         STRO    Qs,d
         BR      fin2
Q:       LDA     27,i
         CPA     reste,d
         BRNE    R
         STRO    Rs,d
         BR      fin2
R:       LDA     28,i
         CPA     reste,d
         BRNE    S
         STRO    Ss,d
         BR      fin2
S:       LDA     29,i
         CPA     reste,d
         BRNE    T
         STRO    Ts,d
         BR      fin2
T:       LDA     30,i
         CPA     reste,d
         BRNE    U
         STRO    Us,d
         BR      fin2
U:       LDA     31,i
         CPA     reste,d
         BRNE    V
         STRO    Vs,d
         BR      fin2
V:       LDA     32,i
         CPA     reste,d
         BRNE    W
         STRO    Ws,d
         BR      fin2
W:       LDA     33,i
         CPA     reste,d
         BRNE    X
         STRO    Xs,d
         BR      fin2
X:       LDA     34,i
         CPA     reste,d
         BRNE    Y
         STRO    Ys,d
         BR      fin2
Y:       LDA     35,i
         CPA     reste,d
         BRNE    norm
         STRO    Zs,d
         BR      fin2
norm:    DECO    reste,d              
         LDA     quot,d
         CPA     base,d
         BRLT    cas    
         BRNE    encore

cas:     DECO    0,i
         LDA     quot,d
         BREQ    fin2
fin2:    STOP
     
m_s_n:   .ASCII "Entrez un nombre positif svp: \x00"
msg_e:   .ASCII "Entrée invalide \n\x00"
m_s_b:   .ASCII "Entrez une base de conversion (un nombre de 2 à 36): \x00"
nextl:   .ASCII "\n\x00"
nbr:     .WORD 0
base:    .WORD 0
quot:    .WORD 0
reste: .WORD 0
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