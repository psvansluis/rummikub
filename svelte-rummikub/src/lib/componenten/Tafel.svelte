<script lang="ts">
  import type { Set } from "../../types/SpelStatus.type";
  import SteenContainer from "./SteenContainer.svelte";
  export let sets: Set[];
</script>

<div id="tafel">
  {#each sets as set, index (index)}<SteenContainer
      container={set}
      {index}
    />{/each}
  <SteenContainer index={sets.length} />
</div>

<style>
  #tafel {
    display: flex;
    flex-direction: row;
    flex-wrap: wrap;
    align-items: flex-start;
    border: 2px solid black;
    border-radius: 5px;
    margin: 5px auto;
    padding: 5px;
    background-color: var(--color-two);
    background-image: url("../../assets/classy-fabric.png");
    min-height: 50vh;
  }
</style>
