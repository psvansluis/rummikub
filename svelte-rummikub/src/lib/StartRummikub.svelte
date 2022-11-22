<script lang="ts">
  import { createEventDispatcher } from "svelte";
  import type { SpelStatus } from "../types/SpelStatus.type.js";

  export let spelStatus: SpelStatus;
  let aantalSpelers: number = 1;
  let voorbeeldNamen: string[] = ["Henk", "Toos", "Huub", "Truus"];
  let statusBericht: string = "";

  const dispatch = createEventDispatcher();

  function elkeCelIsGevuld(lijst: string[]): boolean {
    return lijst.every((str) => str != null && str.length > 0);
  }

  async function startSpel() {
    let spelerNamen: string[] = voorbeeldNamen.slice(0, aantalSpelers);
    if (spelerNamen.length === 0) {
      statusBericht = "Geef tenminste één speler op";
      return;
    } else if (!elkeCelIsGevuld(spelerNamen)) {
      statusBericht = "Iedere speler moet een naam hebben";
      return;
    } else {
      statusBericht =
        "Een spel met " +
        aantalSpelers +
        " speler" +
        (aantalSpelers != 1 ? "s" : "") +
        ": " +
        spelerNamen.join(", ");
    }

    try {
      const respons = await fetch("rummikub/api/start", {
        method: "POST",
        headers: {
          Accept: "application/json",
          "Content-Type": "application/json",
        },
        body: JSON.stringify({ spelerNamen: spelerNamen }),
      });

      if (respons.ok) {
        dispatch("change", { spelStatus: await respons.json() });
        // spelStatus = await respons.json();
        console.log(statusBericht);
      } else {
        console.error(respons.statusText);
        statusBericht = "" + respons.status + respons.statusText;
      }
    } catch (error) {
      console.error(error);
      statusBericht = error;
    }
  }
</script>

<div>
  <h2>Start een nieuw spel</h2>
  <label>
    Aantal spelers: <input type="number" bind:value={aantalSpelers} min="1" />
  </label>
  {#each Array(aantalSpelers) as _, index (index)}
    <label>
      Naam speler {index + 1}
      <input
        type="text"
        bind:value={voorbeeldNamen[index]}
        minlength="1"
        required
      /></label
    >
  {/each}
  <button on:click={startSpel}>Start spel</button>
  <p>
    {statusBericht}
  </p>
</div>

<style>
  div {
    margin: 10px auto;
    max-width: 600px;
    width: 80%;
    min-width: 280px;
    border: 2px solid var(--color-two);
    padding: 10px;
    border-radius: 10px;
  }
  label {
    display: block;
    padding: 5px;
  }
  button {
    padding: 5px;
  }
</style>
