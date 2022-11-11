<script lang="ts">
  import Welkom from "./lib/Welkom.svelte";
  import StartRummikub from "./lib/StartRummikub.svelte";
  import Spelregels from "./lib/Spelregels.svelte";

  export let menu = 1;
</script>

<header>
  <ul id="menu">
    <li><a href="/" on:click|preventDefault={() => (menu = 1)}>Welkom</a></li>
    <li>
      <a href="/" on:click|preventDefault={() => (menu = 2)}>Start</a>
    </li>
    <li>
      <a href="/" on:click|preventDefault={() => (menu = 3)}>Spelregels</a>
    </li>
  </ul>
</header>

<main>
  {#if menu === 1}
    <Welkom />
  {:else if menu === 2}
    <StartRummikub />
  {:else if menu === 3}
    <Spelregels />
  {:else}
    <h1>Pagina niet gevonden.</h1>
  {/if}
</main>

<style>
</style>
