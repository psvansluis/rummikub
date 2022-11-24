<script lang="ts">
  import type { SpelStatus } from "../types/SpelStatus.type";
  import Plankje from "./componenten/Plankje.svelte";
  import Tafel from "./componenten/Tafel.svelte";
  import Paneel from "./componenten/Paneel.svelte";

  export let spelStatus: SpelStatus;
  let bronContainerIndex: number;
  let steenIndex: number;
  let doelContainerIndex: number;

  async function speelSteen() {
    try {
      const respons = await fetch("rummikub/api/speel", {
        method: "POST",
        headers: {
          Accept: "application/json",
          "Content-Type": "application/json",
        },
        body: JSON.stringify({
          bronContainerIndex: bronContainerIndex,
          steenIndex: steenIndex,
          doelContainerIndex: doelContainerIndex,
        }),
      });

      console.log(respons);
    } catch (error) {
      console.error(error);
    } finally {
      bronContainerIndex = null;
      steenIndex = null;
      doelContainerIndex = null;
    }
  }
</script>

<button
  on:click={() =>
    ([bronContainerIndex, steenIndex, doelContainerIndex] = [-1, 0, 0])}
  >kies steen</button
>
<button on:click={speelSteen}>speel</button>

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
