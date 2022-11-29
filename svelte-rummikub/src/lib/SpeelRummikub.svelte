<script lang="ts">
  import { createEventDispatcher } from "svelte";
  import type { SpelStatus } from "../types/SpelStatus.type";
  import Plankje from "./componenten/Plankje.svelte";
  import Tafel from "./componenten/Tafel.svelte";
  import Paneel from "./componenten/Paneel.svelte";
  import {
    bronContainerIndex,
    doelContainerIndex,
    steenIndex,
  } from "../stores/speelSteenIndices";

  let bronContainerIndexWaarde: number;
  let steenIndexWaarde: number;
  let doelContainerIndexWaarde: number;

  bronContainerIndex.subscribe((w) => {
    bronContainerIndexWaarde = w;
  });

  steenIndex.subscribe((w) => {
    steenIndexWaarde = w;
    speelSteen();
  });

  doelContainerIndex.subscribe((w) => {
    doelContainerIndexWaarde = w;
    speelSteen();
  });

  export let spelStatus: SpelStatus;
  const dispatch = createEventDispatcher();

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
        bronContainerIndexWaarde = null;
        steenIndexWaarde = null;
        doelContainerIndexWaarde = null;
        bronContainerIndex.set(null);
        steenIndex.set(null);
        doelContainerIndex.set(null);
      } else {
        console.error(respons.statusText);
      }
    } catch (error) {
      console.error(error);
    }
  }

  async function speelSteen() {
    let coordinaten = {
      bronContainerIndex: bronContainerIndexWaarde,
      steenIndex: steenIndexWaarde,
      doelContainerIndex: doelContainerIndexWaarde,
    };
    if (Object.values(coordinaten).includes(null)) {
      console.log("speelSteen() wacht op meer waardes...");
      return;
    }
    console.log(coordinaten);
    postRequestNaarAPI("rummikub/api/speel", coordinaten);
  }

  async function paneelActie(ev: { detail: { paneelIndex: number } }) {
    postRequestNaarAPI("rummikub/api/paneel", ev.detail.paneelIndex);
  }
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
    <Paneel {spelStatus} on:klikpaneel={paneelActie} />
  </div>
</div>

<style>
  #onderste-rij {
    margin: 5px auto;
    display: flex;
    flex-direction: row;
    align-items: center;
    justify-content: center;
  }
</style>
