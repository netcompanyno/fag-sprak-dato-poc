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

MAANED : 'måned' | 'måneder' ;
AAR : 'år' ;

OM : 'om' ;
FOR : 'for' ;
SIDEN : 'siden' ;

I : 'i' ;
OG : 'og' | ',' ;
PUNKTUM: '.' ;

WS : [ \t]+ -> skip ;
