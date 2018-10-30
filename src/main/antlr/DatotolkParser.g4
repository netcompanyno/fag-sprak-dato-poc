parser grammar DatotolkParser;

options { tokenVocab=DatotolkLexer; }

dato : relativ #relativDato
     | fast #fastDato
     | EOF #tomDato
     ;

relativ : IDAG #idag
        | IGAAR #igaar
        | FOR periode SIDEN #forSiden
        | OM periode #om
        | periode ETTER dato #etter
        | periode FOER dato #foer
        ;

periode : tall AAR #antallAar
        | tall MAANED #antallMaaneder
        | periode (OG|KOMMA)? periode #sammensattPeriode
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

