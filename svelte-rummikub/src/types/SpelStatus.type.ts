export type SpelStatus = {
  plankje: Plankje;
  sets: Set[];
  spelerMetBeurt: string;
  stenenInPot: number;
  spelerMetBeurtIsUitgekomen: boolean;
  spelerKanBeurtDoorgeven: boolean;
  spelIsAfgelopen: boolean;
};

export type Plankje = {
  stenen: Steen[];
};

export type Set = {
  stenen: Steen[];
  valide: boolean;
};

export type Steen = {
  cijfer: number;
  kleur: number;
  joker: boolean;
};
