<script lang="ts">
  import type { Plankje } from "../../types/SpelStatus.type";
  import Steen from "./Steen.svelte";

  export let plankje: Plankje;
</script>

<div>
  {#each plankje.stenen as steen}
    <Steen {steen} />
  {/each}
</div>
