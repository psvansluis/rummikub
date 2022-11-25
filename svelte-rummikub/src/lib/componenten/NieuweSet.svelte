<script lang="ts">
  import { doelContainerIndex } from "../../stores/speelSteenIndices";
  import SteenToevoeger from "./SteenToevoeger.svelte";
  export let index: number;

  function geefToevoegerKlikDoor() {
    console.log("toevoeger geklikt op " + index);
    doelContainerIndex.set(index);
  }
</script>

<div class="set">
  <SteenToevoeger on:steenToevoegerKlikt={geefToevoegerKlikDoor} />
</div>

<style>
  .set {
    border: solid black 2px;
  }
</style>
