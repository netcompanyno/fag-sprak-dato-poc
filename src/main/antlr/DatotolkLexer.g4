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

MAANED : 'mnd' | 'måned' | 'måneder' ;
AAR : 'år' ;

FOER : 'før' ;
ETTER : 'etter' ;
OM : 'om' ;
FOR : 'for' ;
SIDEN : 'siden' ;

I : 'i' ;
OG : 'og' ;
PUNKTUM: '.' ;
KOMMA: ',' ;

WS : [ \t]+ -> skip ;
