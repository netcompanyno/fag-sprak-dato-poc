# language: no
Egenskap: I dag
  Alle varianter av "i dag" skal gi dagens dato.

  Scenario: idag
    Gitt at dagens dato er 2018-05-27
    Når man skriver "idag"
    Så får man 2018-05-27

  Scenario: i dag
    Gitt at dagens dato er 2018-07-26
    Når man skriver "i dag"
    Så får man 2018-07-26
