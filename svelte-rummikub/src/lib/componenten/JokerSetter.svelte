<script lang="ts">
  import { createEventDispatcher } from "svelte";
  import type { Steen } from "../../types/SpelStatus.type";

  const AANTAL_KLEUREN: number = 4;

  const dispatch = createEventDispatcher();
  export let geklikteSteen: Steen;
  let invoerCijfer: number = geklikteSteen.cijfer;
  let invoerKleur: number = geklikteSteen.kleur;

  function setJoker(): void {
    console.log(
      `setJoker aangeroepen met cijfer ${invoerCijfer} en kleur ${invoerKleur}`
    );
    dispatch("klikJoker", { cijfer: invoerCijfer, kleur: invoerKleur });
  }
</script>

<div id="jokersetter">
  <label
    ><input
      id="cijferslider"
      type="range"
      class="slider"
      bind:value={invoerCijfer}
      min="1"
      max="13"
    />
  </label>
  <div id="kleurbuttons">
    {#each Array(AANTAL_KLEUREN) as _, kleurIndex}
      <label
        ><div class="kleur{kleurIndex} kleurbutton steen">{invoerCijfer}</div>
        <input
          type="radio"
          name="kleur"
          bind:group={invoerKleur}
          value={kleurIndex}
        /></label
      >
    {/each}
  </div>
  <button on:click={setJoker}>Pas aan</button>
</div>

<style>
  #cijferslider {
    max-width: 100px;
  }

  #jokersetter {
    padding: 5px;
    margin: 5px;
    display: flow-root;
    flex-direction: column;
    border: 2px solid black;
    border-radius: 5px;
    max-width: 200px;
    align-items: center;
  }

  label {
    display: flex;
    flex-direction: row;
    align-self: center;
    padding: 5px;
    margin: 5px;
  }

  button {
    padding: 5px;
    margin: 5px;
    min-width: 125px;
    min-height: 50px;
    border: solid black 2px;
    border-radius: 10px;
    background-color: var(--light-three);
    color: var(--color-three);
    transition: background-color 0.5s;
    transition: color 0.5s;
  }

  button:hover {
    background-color: var(--color-three);
    color: var(--light-text-color);
  }

  #kleurbuttons {
    display: flex;
    flex-direction: row;
    flex-wrap: wrap;
  }

  .kleurbutton {
    padding: 2px;
    display: inline-block;
    vertical-align: middle;
    border: 2px solid black;
    border-radius: 5px;
    min-width: 20px;
    background-color: var(--kleur-joker);
  }
</style>
