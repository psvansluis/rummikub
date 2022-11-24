<script lang="ts">
  import type { SpelStatus } from "../../types/SpelStatus.type";
  export let spelStatus: SpelStatus;
</script>

<div>
  <button>Reset</button>
  {#if spelStatus.spelerKanBeurtDoorgeven}
    <button>Einde beurt</button>
  {:else}
    <button class="inactief">Einde beurt</button>
  {/if}
  <button>Steen uit pot ({spelStatus.stenenInPot})</button>
</div>

<style>
  div {
    margin: 0;
    display: flex;
    flex-direction: row;
    flex-wrap: wrap;
    align-items: flex-start;
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

  button:hover {
    background-color: var(--color-three);
    color: var(--light-text-color);
  }

  .inactief {
    color: gray;
    background-color: lightgray;
  }

  .inactief:hover {
    background-color: gray;
    color: lightgray;
  }
</style>
