<script lang="ts">
  import type { SpelStatus } from "../types/SpelStatus.type";
  import Plankje from "./componenten/Plankje.svelte";

  export let spelStatus: SpelStatus;
</script>

<h1>{spelStatus.spelerMetBeurt} is aan de beurt</h1>

<button>Haal steen uit pot ({spelStatus.stenenInPot} resterend)</button>

<div>
  <Plankje plankje={spelStatus.plankje} />
</div>
