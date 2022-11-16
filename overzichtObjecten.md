# Overzicht van objecten in verschillende scenario's
Een pijl tussen objecten kan gelezen worden als: een object kent het object waar de pijl naar wijst.

De emoji van een persoon verwijst naar het punt waarmee een agent buiten het domein met het domein interacteert.

Een roodomlijnd object kan Stenen bevatten.
## Eén Speler en één Set op Tafel

```mermaid
flowchart LR

AGENT("🧍")
TAFEL("Tafel")
PLANKJE("Plankje"):::heeftStenen
POT("Pot"):::heeftStenen
subgraph Sets
SET1("Set"):::heeftStenen
end

AGENT-->TAFEL
TAFEL-->PLANKJE
PLANKJE-->POT
TAFEL-->Sets


classDef heeftStenen stroke:#d00
```


## Drie Spelers en drie Sets op Tafel

```mermaid
flowchart LR

AGENT("🧍")
TAFEL("Tafel")
PLANKJE1("Plankje"):::heeftStenen
PLANKJE2("Plankje"):::heeftStenen
PLANKJE3("Plankje"):::heeftStenen
POT("Pot"):::heeftStenen
subgraph Sets
SET1("Set"):::heeftStenen
SET2("Set"):::heeftStenen
SET3("Set"):::heeftStenen
end

AGENT-->TAFEL
TAFEL-->PLANKJE1
TAFEL-->Sets
PLANKJE1-->PLANKJE2
PLANKJE2-->PLANKJE3
PLANKJE3-->PLANKJE1
PLANKJE1-->POT
PLANKJE2-->POT
PLANKJE3-->POT

classDef heeftStenen stroke:#d00
```
