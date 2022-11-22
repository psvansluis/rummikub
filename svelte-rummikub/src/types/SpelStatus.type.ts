export type SpelStatus = {
  plankje: Plankje;
};

export type Plankje = {
  stenen: Steen[];
};

export type Steen = {
  cijfer: number;
  kleur: number;
};
