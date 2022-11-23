export type SpelStatus = {
  plankje: Plankje;
  spelerMetBeurt: string;
  stenenInPot: number;
};

export type Plankje = {
  stenen: Steen[];
};

export type Steen = {
  cijfer: number;
  kleur: number;
};
