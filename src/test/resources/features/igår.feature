# language: no
Egenskap: I går
  Alle varianter av "i går" skal gi gårsdagens dato.

  Scenario: igår
    Gitt at dagens dato er 2018-05-27
    Når man skriver "igår"
    Så får man 2018-05-26

  Scenario: i går
    Gitt at dagens dato er 2018-07-26
    Når man skriver "i går"
    Så får man 2018-07-25
