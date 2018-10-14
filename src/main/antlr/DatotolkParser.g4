parser grammar DatotolkParser;

options { tokenVocab=DatotolkLexer; }

dato : relativ #relativDato
     | EOF #tomDato
     ;

relativ: IDAG #idag
       | IGAAR #igaar
       ;

