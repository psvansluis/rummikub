<script lang="ts">
  import type { SpelStatus } from "../types/SpelStatus.type";
  import Plankje from "./componenten/Plankje.svelte";

  export let spelStatus: SpelStatus;
</script>

<div>
  <Plankje plankje={spelStatus.plankje} />
</div>
