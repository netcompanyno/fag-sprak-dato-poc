lexer grammar DatotolkLexer;

IDAG : 'idag' | 'i dag';
IGAAR : 'igår' | 'i går';

MANDAG : 'mandag' ;
TIRSDAG : 'tirsdag' ;
ONSDAG : 'onsdag' ;
TORSDAG : 'torsdag' ;
FREDAG : 'fredag' ;

JULI : 'juli' ;
AUGUST : 'august' ;

SIFFER: [0-9] ;

I : 'i' ;
PUNKTUM: '.' ;

WS : [ \t]+ -> skip ;
