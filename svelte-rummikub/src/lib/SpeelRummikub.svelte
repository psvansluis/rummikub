<script lang="ts">
  import type { SpelStatus } from "../types/SpelStatus.type";
  import Plankje from "./componenten/Plankje.svelte";
  import Tafel from "./componenten/Tafel.svelte";
  import Paneel from "./componenten/Paneel.svelte";

  export let spelStatus: SpelStatus;
  let bronSetIndex: number;
  let steenIndex: number;
  let doelSetIndex: number;
</script>

<div>
  <div>
    <Tafel sets={spelStatus.sets} />
  </div>
  <div id="onderste-rij">
    <Plankje
      plankje={spelStatus.plankje}
      eigenaar={spelStatus.spelerMetBeurt}
      uitgekomen={spelStatus.spelerMetBeurtIsUitgekomen}
    />
    <Paneel {spelStatus} />
  </div>
</div>

<style>
  #onderste-rij {
    width: 90%;
    margin: 5px auto;
    display: flex;
    flex-direction: row;
    align-items: center;
    justify-content: center;
  }
</style>
