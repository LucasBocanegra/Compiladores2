grammar GrammarLA;

programa :
    declaracoes 'algoritmo' corpo 'fim_algoritmo';

declaracoes :
    decl_local_global declaracoes | ;

decl_local_global :
    declaracao_local | declaracao_global;

declaracao_local returns [int dLocal]:
    'declare' variavel {$dLocal = 0;}
    | 'constante' IDENT ':' tipo_basico '=' valor_constante {$dLocal = 1;}
    | 'tipo'IDENT ':' tipo {$dLocal = 2;}
    ;

variavel :
    IDENT dimensao mais_var ':' tipo;

mais_var:
    ',' IDENT dimensao mais_var | ;

identificador :
    ponteiros_opcionais IDENT dimensao outros_ident;

ponteiros_opcionais :
    '^' ponteiros_opcionais | ;

outros_ident :
    '.' identificador | ;

dimensao :
    '[' exp_aritmetica ']' dimensao | ;

tipo:
    registro | tipo_estendido;

mais_ident:
    ',' identificador mais_ident | ;

mais_variaveis:
    variavel mais_variaveis | ;

tipo_basico:
    'literal' | 'inteiro' | 'real' | 'logico';

tipo_basico_ident:
    tipo_basico | IDENT;

tipo_estendido:
    ponteiros_opcionais tipo_basico_ident;

valor_constante:
    CADEIA | NUM_INT | NUM_REAL | 'verdadeiro' | 'falso';

registro:
    'registro' variavel mais_variaveis 'fim_registro';

declaracao_global:
    'procedimento' IDENT '(' parametros_opcional ')' declaracoes_locais comandos 'fim_procedimento'
    | 'funcao' IDENT '(' parametros_opcional '):' tipo_estendido declaracoes_locais comandos 'fim_funcao';

parametros_opcional:
    parametro | ;

parametro:
    var_opcional identificador mais_ident ':' tipo_estendido mais_parametros;

var_opcional:
    'var' | ;

mais_parametros:
    ',' parametro | ;

declaracoes_locais:
    declaracao_local declaracoes_locais | ;

corpo:
    declaracoes_locais comandos;

comandos:
    cmd comandos | ;

cmd returns [ int tipoCmd ]:
    'leia' '(' identificador mais_ident ')' { $tipoCmd = 0; }
    | 'escreva' '(' expressao mais_expressao ')' { $tipoCmd = 1; }
    | 'se' expressao 'entao' comandos senao_opcional 'fim_se' { $tipoCmd = 2; }
    | 'caso' exp_aritmetica 'seja' selecao senao_opcional 'fim_caso' { $tipoCmd = 3; }
    | 'para' IDENT '<-' exp_aritmetica 'ate' exp_aritmetica 'faca' comandos 'fim_para' { $tipoCmd = 4; }
    | 'enquanto' expressao 'faca' comandos 'fim_enquanto' { $tipoCmd = 5; }
    | 'faca' comandos 'ate' expressao{ $tipoCmd = 6; }
    | '^' IDENT outros_ident dimensao '<-' expressao { $tipoCmd = 7; }
    | IDENT chamada_atribuicao["undefined", "undefined"] { $tipoCmd = 8; }
    | 'retorne' expressao { $tipoCmd = 9; }
;
mais_expressao:
    ',' expressao mais_expressao | ;

senao_opcional:
    'senao' comandos | ;

chamada_atribuicao[String nameAtribuicao, String tipoAtribuicao]:
    '(' argumentos_opcional ')' | outros_ident dimensao '<-' exp=expressao;

argumentos_opcional:
    expressao mais_expressao | ;

selecao:
    constantes ':' comandos mais_selecao;

mais_selecao:
    selecao | ;

constantes:
    numero_intervalo mais_constantes;

mais_constantes:
    ',' constantes | ;

numero_intervalo:
    op_unario NUM_INT intervalo_opcional;

intervalo_opcional:
    '..' op_unario NUM_INT | ;

op_unario:
    '-' | ;

exp_aritmetica returns[String tipoSimbolo]:
    termo outros_termos;

op_multiplicacao:
    '*' | '/';

op_adicao:
    '+' | '-';

termo returns[String tipoSimbolo] :
    fator outros_fatores;

outros_termos returns[String tipoSimbolo]:
    op_adicao termo outros_termos | ;

fator returns[String tipoSimbolo]:
    parcela outras_parcelas;

outros_fatores:
    op_multiplicacao fator outros_fatores | ;

parcela returns[String tipoSimbolo]:
    op_unario parcela_unario | parcela_nao_unario;

parcela_unario returns[int tipoParcela, String tipoSimbolo]
@init {$tipoSimbolo="undefined";} :
    '^' IDENT outros_ident dimensao {$tipoParcela = 0;}
    | IDENT chamada_partes{$tipoParcela = 1;}
    | NUM_INT{$tipoParcela = 2;}
    | NUM_REAL{$tipoParcela = 3;}
    | '(' expressao ')'{$tipoParcela = 4;}
    ;

parcela_nao_unario returns[String tipoSimbolo, int tipoParcela]:
    '&' IDENT outros_ident dimensao {$tipoParcela = 0;} | CADEIA {$tipoParcela = 1;};

outras_parcelas returns[String tipoSimbolo]:
    '%' parcela outras_parcelas | ;

chamada_partes:
    '(' expressao mais_expressao ')' | outros_ident dimensao | ;

exp_relacional returns[String tipoSimbolo]:
    exp_aritmetica op_opcional;

op_opcional returns[String tipoSimbolo]:
    op_relacional exp_aritmetica | ;

op_relacional returns[String tipoSimbolo]
@init {$tipoSimbolo="undefined";} :
    '=' | '<>' | '>=' | '<=' | '>' | '<';

expressao returns[String tipoSimbolo]:
    t1=termo_logico t2=outros_termos_logicos;

op_nao returns[String tipoSimbolo]:
    'nao' | ;

termo_logico returns[String tipoSimbolo]:
    fator_logico outros_fatores_logicos;

outros_termos_logicos:
    'ou' termo_logico outros_termos_logicos | ;

outros_fatores_logicos:
    'e' fator_logico outros_fatores_logicos | ;

fator_logico returns[String tipoSimbolo]:
    op_nao parcela_logica;

parcela_logica returns[String tipoSimbolo, int tipoParcela]:
    'verdadeiro' {$tipoParcela = 0;} | 'falso' {$tipoParcela = 1;} | exp_relacional { $tipoParcela = 2;};

IDENT:
    ('a'..'z' | 'A'..'Z' | '_') ('a'..'z' | 'A'..'Z' | '0'..'9' | '_')*;

NUM_INT:
    '0'..'9'+;

NUM_REAL:
  '0'..'9'+ '.' '0'..'9'+;

CADEIA:
    '"' (~'\n')* '"';

WS:
    (' ' | '\n' | '\r' | '\t') -> skip;

COMENTARIOS:
    '{' ~('\n')* '}' -> skip;

