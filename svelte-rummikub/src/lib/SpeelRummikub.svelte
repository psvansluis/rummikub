<script lang="ts">
  import type { SpelStatus } from "../types/SpelStatus.type";
  import Steen from "./componenten/Steen.svelte";

  export let spelStatus: SpelStatus;
</script>

<div>
  {#each spelStatus.plankje.stenen as steen}
    <Steen {steen} />
  {/each}
</div>
