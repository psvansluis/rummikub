<script lang="ts">
  import Steen from "./Steen.svelte";
  import type { Steen as SteenT } from "../../types/SpelStatus.type";
  import SteenToevoeger from "./SteenToevoeger.svelte";
  import type { Plankje, Set } from "../../types/SpelStatus.type";
  import {
    doelContainerIndex,
    bronIndices,
  } from "../../stores/speelSteenIndices";

  export let container: Plankje | Set = { stenen: [], valide: null } as Set;
  export let index: number;

  function geefSteenKlikDoor(ev: {
    detail: { steenIndex: number; steenObject: SteenT };
  }) {
    console.log("steen geklikt op " + index + ", " + ev.detail.steenIndex);
    bronIndices.set({
      container: index,
      steen: ev.detail.steenIndex,
      steenObject: ev.detail.steenObject,
    });
  }

  function geefToevoegerKlikDoor() {
    console.log("toevoeger geklikt op " + index);
    doelContainerIndex.set(index);
  }
</script>

<div
  class:set={"valide" in container}
  class:valide={"valide" in container && container.valide}
  class:invalide={"valide" in container && container.valide === false}
  class:plankje={!("valide" in container)}
>
  {#each container.stenen as steen, index}
    <Steen {steen} {index} on:steenKlikt={geefSteenKlikDoor} />
  {/each}<SteenToevoeger on:steenToevoegerKlikt={geefToevoegerKlikDoor} />
</div>

<style>
  div {
    border-radius: 5px;
    border: 2px solid black;
    display: flex;
    flex-wrap: wrap;
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

  .set {
    padding: 5px;
    border-radius: 5px;
    margin: 5px;
  }
</style>
