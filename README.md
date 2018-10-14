Dato-tolk
=========

Dato-tolk er et bibliotek som gjør om norsk tekst til dato-objekter.

F.eks. `i dag`, `på mandag`, `2. tirsdag i august`, ...


Utvikling – Kom i gang
----------------------

### Last ned koden

    $ git clone https://github.com/netcompanyno/fag-sprak-dato-poc.git

### Åpne i IntelliJ

Åpne `build.gradle` i rot-mappa og velg `Open as Project`.

IntelliJ bør begynne å indeksere og konfigurere Gradle og bygge og holde på en 
god stund.

### Konfigurer Gradle

For å få Gradle/IntelliJ til å forstå seg på de genererte filene fra Antlr, må vi endre litt på standard innstillinger.

#### Settings > Build, Execution, Deployment > Build Tools > Gradle

* *Use Auto-import*: **Ja**
* *Create directories for empty content roots automatically*: **Ja**
* *Group modules*: **using explicit module groups**
* *Create separate module per source set*: **Nei**
* *Store generated project files externally*: **Ja**

### Kjør tester

Finn klassen [`KjørCucumberTester`](src/test/kotlin/no/netcompany/datotolk/cucumber/KjørCucumberTester.kt), 
høyreklikk den og velg _Run_.

### Skriv en test

Finn testene i [src/test/resources/features](src/test/resources/features). 
Rediger en eksisterende fil eller lag en ny. Når du kjører Cucumber-testene på 
nytt bør noe feile.

### Få testen til å kjøre

Først når du har en test som feiler, skal du skrive noe kode. Inngangsporten er 
klassen [DatoTolk](src/main/kotlin/no/netcompany/datotolk/DatoTolk.kt). Skriv kode 
helt til testene kjører grønt igjen, og skriv en ny test som feiler, helt til du 
er førnøyd.

### Jobbe med ANTLR

Alle ord som skal kunne gjenkjennes av parseren skal defineres i 
[Lexer-filen](src/main/antlr/DatotolkLexer.g4).
Deretter kan man skrive regler for hvordan ordene kan settes sammen i
[Parser-filen](src/main/antlr/DatotolkParser.g4).

Etter at man har endret noe i disse filene kan man kjøre Gradle-tasken `generateGrammarSource`.
Da genereres eller oppdateres bl.a. klassen `DatotolkParserBaseVisitor` som brukes av `DatoTolk`-klassen.


`DatotolkParserBaseVisitor` har en `visit`-metode for hver regel som er definert i parser-filen, f.eks `visitIdag()`
for regelen `# idag`.

I objekt-klassen `DatoUtlederVisitor` kan man overskrive de visit-metodene man vil for å konstruere en `DatoUtleder`
når parseren tolker teksten til den tilhørende regelen.

Man kan også lage nye `visitor`-klasser med andre typeparametere hvis man har andre ting i gramatikken som skal tolkes 
til en annen Java/Kotlin-klasse.

#### Tips

Når man har kjørt `generateGrammarSource` vil IntelliJ gi veldig god *code completion* på visit-metodene.
Man trenger bare å gå inn i Visitor-klassen og begynne å skrive navnet på en regel, så vil editoren foreslå hele
metodesignaturen som f.eks `override fun visitIdag(ctx: DatotolkParser.IdagContext?): DatoUtleder`. Spørsmålstegnet
i typedeklarasjonen til `ctx`-parameteret kan tas vekk, siden denne i praksis aldri vil være `null`, og så slipper
man å styre med null-sjekk i Kotlin-koden.
