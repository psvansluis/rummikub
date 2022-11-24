<script lang="ts">
  import { createEventDispatcher } from "svelte";
  import type { Plankje } from "../../types/SpelStatus.type";
  import Steen from "./Steen.svelte";
  import SteenToevoeger from "./SteenToevoeger.svelte";

  export let plankje: Plankje;
  export let eigenaar: String;
  export let uitgekomen: boolean;
  export const index: number = -1;

  const dispatch = createEventDispatcher();
</script>

<div id="plankjewrapper">
  <div id="eigenaarbadge">
    <div id="eigenaarnaam">{eigenaar}</div>
    {#if !uitgekomen}
      <div id="uitgekomenbericht">Niet uitgekomen</div>
    {/if}
  </div>
  <div id="plankje">
    {#each plankje.stenen as steen}
      <Steen {steen} />
    {/each}<SteenToevoeger
      on:steenToevoegerKlikt={() => {
        dispatch("selecteerDoel", { doelContainerIndex: index });
      }}
    />
  </div>
</div>

<style>
  #eigenaarbadge {
    background-color: var(--light-three);
    max-width: 200px;
  }

  #eigenaarbadge > * {
    text-align: center;
    margin: 0 auto;
  }

  #eigenaarnaam {
    font-size: large;
  }

  #uitgekomenbericht {
    font-size: small;
  }

  #plankjewrapper > * {
    border: 2px solid black;
    border-radius: 5px;
    margin: 0 auto;
  }

  #plankje {
    padding: 5px;
    min-width: 218px;
    max-width: 661px;
    background-color: var(--color-three);
    background-image: url("../../assets/wood-pattern.png");
  }
</style>
