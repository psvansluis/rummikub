<script lang="ts">
  import SpeelRummikub from "./SpeelRummikub.svelte";
  import StartRummikub from "./StartRummikub.svelte";
  import type { SpelStatus } from "../types/SpelStatus.type.js";
  let spelStatus: SpelStatus = undefined;
  function vernieuwSpelStatus(ev) {
    spelStatus = ev.detail.spelStatus;
    console.log(spelStatus);
  }
</script>

{#if !spelStatus}
  <StartRummikub on:change={vernieuwSpelStatus} />
{:else}
  <SpeelRummikub {spelStatus} on:change={vernieuwSpelStatus} />
{/if}
