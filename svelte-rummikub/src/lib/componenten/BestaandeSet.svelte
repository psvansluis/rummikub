<script lang="ts">
  import Steen from "./Steen.svelte";
  import SteenToevoeger from "./SteenToevoeger.svelte";
  import type { Set } from "../../types/SpelStatus.type";
  import {
    bronContainerIndex,
    steenIndex,
    doelContainerIndex,
  } from "../../stores/speelSteenIndices";

  export let set: Set;
  export let index: number;
  function geefSteenKlikDoor(ev) {
    console.log("steen geklikt op " + index + ", " + ev.detail.steenIndex);
    bronContainerIndex.set(index);
    steenIndex.set(ev.detail.steenIndex);
  }

  function geefToevoegerKlikDoor() {
    console.log("toevoeger geklikt op " + index);
    doelContainerIndex.set(index);
  }
</script>

<div class="set {set.valide ? 'valide' : 'invalide'}">
  {#each set.stenen as steen, index (index)}
    <Steen {steen} {index} on:steenKlikt={geefSteenKlikDoor} />
  {/each}
  <SteenToevoeger on:steenToevoegerKlikt={geefToevoegerKlikDoor} />
</div>

<style>
  div {
    border-radius: 5px;
  }

  .valide {
    border: solid green 2px;
  }

  .invalide {
    border: solid red 2px;
  }
</style>
