<script lang="ts">
  import { createEventDispatcher } from "svelte";
  import type { SpelStatus } from "../../types/SpelStatus.type";

  export let spelStatus: SpelStatus;

  const dispatch = createEventDispatcher();
  function klikPaneel(index: number): void {
    dispatch("klikpaneel", { paneelIndex: index });
  }
</script>

<div>
  <button class="actief paneel-knop" on:click={() => klikPaneel(0)}
    >Reset</button
  >
  {#if spelStatus.spelerKanBeurtDoorgeven}
    <button class="actief paneel-knop" on:click={() => klikPaneel(1)}
      >Einde beurt</button
    >
  {:else}
    <button class="inactief paneel-knop">Einde beurt</button>
  {/if}
  <button class="actief paneel-knop" on:click={() => klikPaneel(2)}
    >Steen uit pot ({spelStatus.stenenInPot})</button
  >
  <button class="actief paneel-knop" on:click={() => klikPaneel(3)}>
    Sorteer op cijfer</button
  >
  <button class="actief paneel-knop" on:click={() => klikPaneel(4)}>
    Sorteer op kleur</button
  >
</div>

<style>
  div {
    margin: 0;
    display: flex;
    flex-direction: column;
    flex-wrap: wrap;
    align-items: normal;
    width: 140px;
  }

  button.inactief {
    color: gray;
    background-color: lightgray;
  }
</style>
