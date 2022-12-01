<script lang="ts">
  import { afterUpdate } from "svelte";
  import Steen from "./Steen.svelte";
  import SteenToevoeger from "./SteenToevoeger.svelte";
  import type { Plankje, Set } from "../../types/SpelStatus.type";
  import {
    bronContainerIndex,
    steenIndex,
    doelContainerIndex,
  } from "../../stores/speelSteenIndices";

  export let container: Plankje | Set;
  export let index: number;

  function geefSteenKlikDoor(ev: { detail: { steenIndex: number } }) {
    console.log("steen geklikt op " + index + ", " + ev.detail.steenIndex);
    bronContainerIndex.set(index);
    steenIndex.set(ev.detail.steenIndex);
  }

  function geefToevoegerKlikDoor() {
    // console.log("toevoeger geklikt op " + index);
    doelContainerIndex.set(index);
  }

  let cssclass: string;
  afterUpdate(() => {
    cssclass = determineerklasse();
  });

  function determineerklasse(): string {
    if ("valide" in container) {
      return container.valide ? "valide set" : "invalide set";
    } else {
      return "plankje";
    }
  }
</script>

<div class={cssclass}>
  {#each container.stenen as steen, index (index)}
    <Steen {steen} {index} on:steenKlikt={geefSteenKlikDoor} />
  {/each}<SteenToevoeger on:steenToevoegerKlikt={geefToevoegerKlikDoor} />
</div>

<style>
  div {
    border-radius: 5px;
    border: 2px solid black;
  }

  .valide {
    border: solid green 2px;
  }

  .invalide {
    border: solid red 2px;
  }

  .plankje {
    padding: 5px;
    min-width: 218px;
    max-width: 661px;
    background-color: var(--color-three);
    background-image: url("../../assets/wood-pattern.png");
  }
</style>
