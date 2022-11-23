export type SpelStatus = {
  plankje: Plankje;
  spelerMetBeurt: string;
  stenenInPot: number;
  spelerMetBeurtIsUitgekomen: boolean;
  spelerKanBeurtDoorgeven: boolean;
};

export type Plankje = {
  stenen: Steen[];
};

export type Set = {
  stenen: Steen[];
  isValide: boolean;
}

export type Steen = {
  cijfer: number;
  kleur: number;
};
