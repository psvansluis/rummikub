<script lang="ts">
  import type { Plankje } from "../../types/SpelStatus.type";
  import SteenContainer from "./SteenContainer.svelte";

  export let plankje: Plankje;
  export let eigenaar: String;
  export let uitgekomen: boolean;
  const index: number = -1;
</script>

<div id="plankjewrapper">
  <div id="eigenaarbadge">
    <div id="eigenaarnaam">{eigenaar}</div>
    {#if !uitgekomen}
      <div id="uitgekomenbericht">Niet uitgekomen</div>
    {/if}
  </div>
  <SteenContainer container={plankje} {index} />
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

  #plankjewrapper {
    margin-top: 5px;
  }

  #plankjewrapper > * {
    border: 2px solid black;
    border-radius: 5px;
    margin: 0 auto;
  }
</style>
