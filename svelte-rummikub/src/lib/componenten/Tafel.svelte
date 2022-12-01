<script lang="ts">
  import type { Set } from "../../types/SpelStatus.type";
  import NieuweSet from "./NieuweSet.svelte";
  import SteenContainer from "./SteenContainer.svelte";
  export let sets: Set[];
</script>

<div id="tafel">
  {#if sets.length != 0}
    {#each sets as set, index (index)}<SteenContainer
        container={set}
        {index}
      />{/each}
  {/if}
  <NieuweSet index={sets.length} />
</div>

<style>
  #tafel {
    display: flex;
    flex-direction: column;
    flex-wrap: wrap;
    align-items: flex-start;
    border: 2px solid black;
    border-radius: 5px;
    margin: 5px auto;
    padding: 5px;
    background-color: var(--color-two);
    background-image: url("../../assets/classy-fabric.png");
    min-height: 300px;
    min-width: 500px;
    max-height: 75vh;
  }
</style>
