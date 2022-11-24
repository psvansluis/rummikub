<script lang="ts">
  import Steen from "./Steen.svelte";
  import SteenToevoeger from "./SteenToevoeger.svelte";
  import type { Set } from "../../types/SpelStatus.type";

  export let set: Set;
</script>

<div class="set {set.valide ? 'valide' : 'invalide'}">
  {#each set.stenen as steen}
    <Steen {steen} />
  {/each}
  <SteenToevoeger />
</div>

<style>
  div {
    padding: 5px;
    border-radius: 5px;
  }

  .valide {
    border: solid green 2px;
  }

  .invalide {
    border: solid red 2px;
  }
</style>
