<script lang="ts">
  import Welkom from "./lib/Welkom.svelte";
  import SpelPagina from "./lib/SpelPagina.svelte";
  import Spelregels from "./lib/Spelregels.svelte";

  export let menu = 1;
</script>

<header>
  <h1>Rummikub</h1>
  <nav id="menu">
    <a href="/" on:click|preventDefault={() => (menu = 1)}>Welkom</a>
    <a href="/" on:click|preventDefault={() => (menu = 2)}>Start</a>
    <a href="/" on:click|preventDefault={() => (menu = 3)}>Spelregels</a>
  </nav>
</header>
<main>
  {#if menu === 1}
    <Welkom />
  {:else if menu === 2}
    <SpelPagina />
  {:else if menu === 3}
    <Spelregels />
  {:else}
    <h1>Pagina niet gevonden.</h1>
  {/if}
</main>

<style>
</style>
