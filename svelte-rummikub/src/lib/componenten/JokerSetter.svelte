<script lang="ts">
  import { createEventDispatcher } from "svelte";
  import type { Steen } from "../../types/SpelStatus.type";

  const AANTAL_KLEUREN: number = 4;
  const HOOGSTE_CIJFER_STEEN: number = 13;

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
  <div id="jokerheader">Joker</div>
  <label
    ><input
      id="cijferslider"
      type="range"
      class="slider"
      bind:value={invoerCijfer}
      min="1"
      max={HOOGSTE_CIJFER_STEEN}
    />
  </label>
  <div id="kleurbuttons">
    {#each Array(AANTAL_KLEUREN) as _, kleurIndex}
      <label
        ><div class="kleur{kleurIndex} kleurbutton">{invoerCijfer}</div>
        <input
          type="radio"
          name="kleur"
          bind:group={invoerKleur}
          value={kleurIndex}
        /></label
      >
    {/each}
  </div>
  <button on:click={setJoker} class="paneel-knop actief">Pas aan</button>
</div>

<style>
  #jokerheader {
    font-size: large;
  }

  #cijferslider {
    max-width: 100px;
  }

  #cijferslider::-webkit-slider-thumb {
    background: var(--color-one);
  }

  #jokersetter {
    padding: 5px;
    margin: 5px;
    display: flex;
    flex-direction: column;
    justify-content: normal;
    border: 2px solid black;
    border-radius: 5px;
    max-width: 150px;
    align-items: center;
    background-color: var(--light-three);
  }

  label {
    display: flex;
    flex-direction: row;
    padding: 5px;
    margin: 5px;
  }

  #kleurbuttons {
    display: flex;
    flex-direction: row;
    flex-wrap: wrap;
    justify-content: center;
  }

  .kleurbutton {
    padding: 2px;
    display: flex;
    justify-content: center;
    vertical-align: middle;
    border: 2px solid black;
    border-radius: 5px;
    min-width: 20px;
    background-color: var(--kleur-joker);
    transition: background-color 0.5s;
  }

  .kleurbutton:hover {
    background-color: var(--kleur-joker-transparant);
  }
</style>
