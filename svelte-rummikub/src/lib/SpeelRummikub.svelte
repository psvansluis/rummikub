<script lang="ts">
  import { createEventDispatcher } from "svelte";
  import type { SpelStatus } from "../types/SpelStatus.type";
  import Plankje from "./componenten/Plankje.svelte";
  import Tafel from "./componenten/Tafel.svelte";
  import Paneel from "./componenten/Paneel.svelte";

  export let spelStatus: SpelStatus;
  const dispatch = createEventDispatcher();

  let bronContainerIndex: number;
  let steenIndex: number;
  let doelContainerIndex: number;
  let paneelIndex: number;

  async function postRequestNaarAPI(bestemming: string, body: any) {
    try {
      const respons = await fetch(bestemming, {
        method: "POST",
        headers: {
          Accept: "application/json",
          "Content-Type": "application/json",
        },
        body: JSON.stringify(body),
      });
      if (respons.ok) {
        dispatch("change", { spelStatus: await respons.json() });
      } else {
        console.error(respons.statusText);
      }
    } catch (error) {
      console.error(error);
    }
  }

  async function speelSteen() {
    postRequestNaarAPI("rummikub/api/speel", {
      bronContainerIndex: bronContainerIndex,
      steenIndex: steenIndex,
      doelContainerIndex: doelContainerIndex,
    });
  }

  async function paneelActie(ev) {
    postRequestNaarAPI("rummikub/api/paneel", ev.detail.paneelIndex);
  }
</script>

<button
  on:click={() =>
    ([bronContainerIndex, steenIndex, doelContainerIndex] = [-1, 0, 0])}
  >set 0</button
>
<button
  on:click={() =>
    ([bronContainerIndex, steenIndex, doelContainerIndex] = [-1, 0, 1])}
  >set 1</button
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
    <Paneel {spelStatus} on:change={paneelActie} />
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
