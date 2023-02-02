<script lang="ts">
  import { createEventDispatcher } from "svelte";
  import type { SpelStatus } from "../types/SpelStatus.type";
  import Plankje from "./componenten/Plankje.svelte";
  import Tafel from "./componenten/Tafel.svelte";
  import Paneel from "./componenten/Paneel.svelte";
  import { bronIndices, doelContainerIndex } from "../stores/speelSteenIndices";
  import JokerSetter from "./componenten/JokerSetter.svelte";

  $: $bronIndices, $doelContainerIndex, speelSteen();

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
        bronIndices.set(null);
        doelContainerIndex.set(null);
      } else {
        console.error(respons.statusText);
      }
    } catch (error) {
      console.error(error);
    }
  }

  async function speelSteen() {
    if ($bronIndices === null || $doelContainerIndex === null) {
      console.log("speelSteen() wacht op meer waardes...");
      return;
    }
    let coordinaten = {
      bronContainerIndex: $bronIndices.container,
      steenIndex: $bronIndices.steen,
      doelContainerIndex: $doelContainerIndex,
    };
    console.log(coordinaten);
    postRequestNaarAPI("rummikub/api/speel", coordinaten);
  }

  async function paneelActie(ev: { detail: { paneelIndex: number } }) {
    postRequestNaarAPI("rummikub/api/paneel", ev.detail.paneelIndex);
  }

  async function setJoker(ev: { detail: { cijfer: number; kleur: number } }) {
    let jokerWaardes = {
      containerIndex: $bronIndices.container,
      steenIndex: $bronIndices.steen,
      cijfer: ev.detail.cijfer,
      kleur: ev.detail.kleur,
    };
    console.log(jokerWaardes);
    postRequestNaarAPI("rummikub/api/joker", jokerWaardes);
  }
</script>

<Tafel sets={spelStatus.sets} />
<div id="onderste-rij">
  {#if $bronIndices != null && $bronIndices.steenObject.isJoker}
    <JokerSetter
      geklikteSteen={$bronIndices.steenObject}
      on:klikJoker={setJoker}
    />
  {/if}
  <Plankje
    plankje={spelStatus.plankje}
    eigenaar={spelStatus.spelerMetBeurt}
    uitgekomen={spelStatus.spelerMetBeurtIsUitgekomen}
  />
  <Paneel {spelStatus} on:klikpaneel={paneelActie} />
</div>

<style>
  #onderste-rij {
    margin: 5px auto;
    display: flex;
    flex-direction: row;
    align-items: top;
    justify-content: center;
  }
</style>
