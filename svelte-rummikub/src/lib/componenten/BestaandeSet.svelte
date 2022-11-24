<script lang="ts">
  import Steen from "./Steen.svelte";
  import SteenToevoeger from "./SteenToevoeger.svelte";
  import type { Set } from "../../types/SpelStatus.type";
  import { createEventDispatcher } from "svelte";

  export let set: Set;
  export let index: number;
  const dispatch = createEventDispatcher();
</script>

<div class="set {set.valide ? 'valide' : 'invalide'}">
  {#each set.stenen as steen}
    <Steen {steen} />
  {/each}
  <SteenToevoeger
    on:steenToevoegerKlikt={() => {
      dispatch("stuurDoelNaarTafel", { doelContainerIndex: index });
    }}
  />
</div>

<style>
  div {
    border-radius: 5px;
  }

  .valide {
    border: solid green 2px;
  }

  .invalide {
    border: solid red 2px;
  }
</style>
