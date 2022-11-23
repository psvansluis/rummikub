<script lang="ts">
  import type { SpelStatus } from "../types/SpelStatus.type";
  import Plankje from "./componenten/Plankje.svelte";
  import Tafel from "./componenten/Tafel.svelte";

  export let spelStatus: SpelStatus;
  let bronSetIndex: number;
  let steenIndex: number;
  let doelSetIndex: number;
</script>

<div>
  <div>
    <Tafel sets={spelStatus.sets} />
  </div>
  <Plankje
    plankje={spelStatus.plankje}
    eigenaar={spelStatus.spelerMetBeurt}
    uitgekomen={spelStatus.spelerMetBeurtIsUitgekomen}
  />
</div>
