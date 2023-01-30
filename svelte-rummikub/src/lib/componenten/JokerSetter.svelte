<script lang="ts">
  import { createEventDispatcher } from "svelte";

  const dispatch = createEventDispatcher();

  let invoerCijfer: number = 1;
  let invoerKleur: number = 0;

  function setJoker(): void {
    console.log(
      `setJoker aangeroepen met cijfer ${invoerCijfer} en kleur ${invoerKleur}`
    );
    dispatch("klikJoker", { cijfer: invoerCijfer, kleur: invoerKleur });
  }
</script>

<div>
  <h2>Joker</h2>
  <label
    >Cijfer: <input type="number" bind:value={invoerCijfer} min="1" max="13" />
  </label>
  <label
    >Kleur: <input
      type="number"
      bind:value={invoerKleur}
      min="0"
      max="3"
    /></label
  >
  <button on:click={setJoker}>Pas aan</button>
</div>

<style>
  div {
    padding: 5px;
    margin: 5px;
    display: flex;
    flex-direction: column;
  }
</style>
