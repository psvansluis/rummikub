<script>
  import SpeelRummikub from "./SpeelRummikub.svelte";
  import StartRummikub from "./StartRummikub.svelte";

  const spelStatus = false;
</script>

{#if !spelStatus}
  <StartRummikub />
{:else}
  <SpeelRummikub />
{/if}
