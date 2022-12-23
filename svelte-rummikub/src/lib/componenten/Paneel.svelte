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
  <button class="actief" on:click={() => klikPaneel(0)}>Reset</button>
  {#if spelStatus.spelerKanBeurtDoorgeven}
    <button class="actief" on:click={() => klikPaneel(1)}>Einde beurt</button>
  {:else}
    <button class="inactief">Einde beurt</button>
  {/if}
  <button class="actief" on:click={() => klikPaneel(2)}
    >Steen uit pot ({spelStatus.stenenInPot})</button
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

  button {
    padding: 5px;
    margin: 5px;
    min-width: 125px;
    min-height: 50px;
    border: solid black 2px;
    border-radius: 10px;
    background-color: var(--light-three);
    color: var(--color-three);
    transition: background-color 0.5s;
    transition: color 0.5s;
  }

  button.actief:hover {
    background-color: var(--color-three);
    color: var(--light-text-color);
  }

  .inactief {
    color: gray;
    background-color: lightgray;
  }
</style>
