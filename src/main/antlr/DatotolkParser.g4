parser grammar DatotolkParser;

options { tokenVocab=DatotolkLexer; }

dato : relativ #relativDato
     | fast #fastDato
     | EOF #tomDato
     ;

relativ: IDAG #idag
       | IGAAR #igaar
       ;

fast : flytendeUkedag I maaned #nteUkedagIMaaned
     ;

flytendeUkedag : nummer ukedag #nteUkedag
               ;

ukedag : MANDAG
       | TIRSDAG
       | ONSDAG
       | TORSDAG
       | FREDAG
       ;

maaned : JULI
       | AUGUST
       ;

nummer : tall PUNKTUM? ;
tall : SIFFER+ ;

