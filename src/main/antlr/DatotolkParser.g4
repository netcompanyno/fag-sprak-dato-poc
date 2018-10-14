parser grammar DatotolkParser;

options { tokenVocab=DatotolkLexer; }

datoRegel : relativeBegrep # relativRegel
          | EOF #tomDato
          ;

relativeBegrep: IDAG # idagUttrykk
              ;

