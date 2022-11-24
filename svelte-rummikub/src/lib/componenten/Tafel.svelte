<script lang="ts">
  import { createEventDispatcher } from "svelte";
  import type { Set } from "../../types/SpelStatus.type";
  import BestaandeSet from "./BestaandeSet.svelte";
  import NieuweSet from "./NieuweSet.svelte";
  export let sets: Set[];
  const dispatch = createEventDispatcher();
  function doelSelecteerder(ev) {
    dispatch("selecteerDoel", {
      doelContainerIndex: ev.detail.doelContainerIndex,
    });
  }
</script>

<div id="tafel">
  {#if sets.length != 0}
    {#each sets as set, index (index)}<BestaandeSet
        {set}
        {index}
        on:stuurDoelNaarTafel={doelSelecteerder}
      />{/each}
  {/if}
  <NieuweSet index={sets.length} on:stuurDoelNaarTafel={doelSelecteerder} />
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
  }
</style>
