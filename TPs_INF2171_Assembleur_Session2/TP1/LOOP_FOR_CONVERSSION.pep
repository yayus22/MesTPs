         STRO m_s_n,d
         DECI nbr,d 

loop1:   LDA 0,i
         ADDA nbr,d
         BRGE fv1
         
         STRO msg_e,d
         STRO m_s_n,d
         DECI nbr,d
         BR loop1

fv1:     DECO nbr,d
         STRO nextl,d

debut:     STRO m_s_b,d
         DECI base,d

loop2:   LDA -2,i
         ADDA base,d
         BRGE loop3
         

         STRO msg_e,d
         BR debut 



loop3:   LDA  36,i
         SUBA base,d
         BRGE fv3

         STRO msg_e,d
         BR debut

fv3:     DECO base,d
         STOP
     
m_s_n:   .ASCII "Entrez un nombre positif svp: \x00"
msg_e:   .ASCII "Entrée invalide \n\x00"
m_s_b:   .ASCII "Entrez une base de conversion (un nombre de 2 à 36): \x00"
nextl:   .ASCII "\n\x00"
nbr:     .WORD 0
base:    .WORD 0
         .END