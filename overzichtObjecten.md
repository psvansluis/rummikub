# Overzicht van objecten in verschillende scenario's
Een pijl tussen objecten kan gelezen worden als: een object kent het object waar de pijl naar wijst.

De emoji van een persoon verwijst naar het punt waarmee een agent buiten het domein met het domein interacteert.

Een roodomlijnd object kan Stenen bevatten.
## Eén Speler en één Set op Tafel

```mermaid
flowchart LR

AGENT("🧍")
SPELER("Speler")
PLANKJE("Plankje"):::heeftStenen
TAFEL("Tafel")
POT("Pot"):::heeftStenen
SET1("Set"):::heeftStenen

AGENT-->SPELER
SPELER-->PLANKJE
SPELER-->POT
PLANKJE-->TAFEL
TAFEL-->SET1

classDef heeftStenen stroke:#d00

```

## Drie Spelers en drie Sets op Tafel

```mermaid
flowchart LR

AGENT("🧍")
SPELER1("Speler")
SPELER2("Speler")
SPELER3("Speler")
PLANKJE1("Plankje"):::heeftStenen
PLANKJE2("Plankje"):::heeftStenen
PLANKJE3("Plankje"):::heeftStenen
TAFEL("Tafel")
POT("Pot"):::heeftStenen
SET1("Set"):::heeftStenen
SET2("Set"):::heeftStenen
SET3("Set"):::heeftStenen

AGENT-->SPELER1
SPELER1-->SPELER2
SPELER2-->SPELER3
SPELER3-->SPELER1
SPELER1-->PLANKJE1
SPELER2-->PLANKJE2
SPELER3-->PLANKJE3
SPELER1-->POT
SPELER2-->POT
SPELER3-->POT
PLANKJE1-->TAFEL
PLANKJE2-->TAFEL
PLANKJE3-->TAFEL
TAFEL-->SET1
TAFEL-->SET2
TAFEL-->SET3

classDef heeftStenen stroke:#d00

```
