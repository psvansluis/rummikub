<script lang="ts">
  import { createEventDispatcher } from "svelte";
  import SteenToevoeger from "./SteenToevoeger.svelte";
  export let index: number;

  const dispatch = createEventDispatcher();
</script>

<div class="set">
  <SteenToevoeger
    on:steenToevoegerKlikt={() => {
      dispatch("stuurDoelNaarTafel", { doelContainerIndex: index });
    }}
  />
</div>

<style>
  .set {
    border: solid black 2px;
  }
</style>
