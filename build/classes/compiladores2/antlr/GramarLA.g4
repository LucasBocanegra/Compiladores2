/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

grammar GramarLA;

programa returns [int count]: 
    expressao
    {$count = $expressao.count;}
; 

expressao returns [int count] : 
    t1=termo {$count = $t1.count;} (op1 t2=termo {$count += 1 + $t2.count;})*
    
; 

termo returns [int count]: 
    f1=fator {$count = $f1.count;} (op2 f2=fator {$count += 1 + $f2.count; })*
;

fator returns [int count]:
        '('expressao')' { $count = $expressao.count; } |
        NUM {$count = 0;}
;

op1:
       '+' | '-'
;
op2:
       '*'  | '/'
;

NUM:
        '0'..'9'+
;

WS:
        (' ' | '\n' | '\r' | '\t') -> skip
;
