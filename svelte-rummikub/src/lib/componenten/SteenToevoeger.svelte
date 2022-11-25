<script lang="ts">
  import { createEventDispatcher } from "svelte";
  const dispatch = createEventDispatcher();
</script>

<button
  class="steen toevoeger"
  on:click={() => {
    dispatch("steenToevoegerKlikt");
  }}>+</button
>

<style>
  .toevoeger {
    color: black;
    background: var(--kleur-steen-transparant);
  }

  .toevoeger:hover {
    background: var(--kleur-steen);
  }
</style>
