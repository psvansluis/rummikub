<script lang="ts">
  import type { Plankje } from "../../types/SpelStatus.type";
  import Steen from "./Steen.svelte";
  import SteenToevoeger from "./SteenToevoeger.svelte";
  import {
    bronContainerIndex,
    steenIndex,
  } from "../../stores/speelSteenIndices";

  export let plankje: Plankje;
  export let eigenaar: String;
  export let uitgekomen: boolean;
  const index: number = -1;

  function geefSteenKlikDoor(ev) {
    console.log("steen geklikt op " + index + ", " + ev.detail.steenIndex);
    bronContainerIndex.set(index);
    steenIndex.set(ev.detail.steenIndex);
  }
</script>

<div id="plankjewrapper">
  <div id="eigenaarbadge">
    <div id="eigenaarnaam">{eigenaar}</div>
    {#if !uitgekomen}
      <div id="uitgekomenbericht">Niet uitgekomen</div>
    {/if}
  </div>
  <div id="plankje">
    {#each plankje.stenen as steen, index (index)}
      <Steen {steen} {index} on:steenKlikt={geefSteenKlikDoor} />
    {/each}
    <SteenToevoeger />
  </div>
</div>

<style>
  #eigenaarbadge {
    background-color: var(--light-three);
    max-width: 200px;
  }

  #eigenaarbadge > * {
    text-align: center;
    margin: 0 auto;
  }

  #eigenaarnaam {
    font-size: large;
  }

  #uitgekomenbericht {
    font-size: small;
  }

  #plankjewrapper > * {
    border: 2px solid black;
    border-radius: 5px;
    margin: 0 auto;
  }

  #plankje {
    padding: 5px;
    min-width: 218px;
    max-width: 661px;
    background-color: var(--color-three);
    background-image: url("../../assets/wood-pattern.png");
  }
</style>
