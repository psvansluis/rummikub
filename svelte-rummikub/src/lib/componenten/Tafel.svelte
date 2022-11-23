<script lang="ts">
  import type { Set } from "../../types/SpelStatus.type";
  import BestaandeSet from "./BestaandeSet.svelte";
  import NieuweSet from "./NieuweSet.svelte";
  export let sets: Set[];
</script>

<div id="tafel">
  {#each sets as set}
    <BestaandeSet {set} />
  {/each}<NieuweSet />
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
    min-height: 300px;
    min-width: 600px;
    width: 80%;
  }
</style>
