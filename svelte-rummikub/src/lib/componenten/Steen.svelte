<script lang="ts">
  import { createEventDispatcher } from "svelte";
  import type { Steen } from "../../types/SpelStatus.type";

  const dispatch = createEventDispatcher();

  export let steen: Steen;
  export let index: number;
</script>

<button
  class={"steen kleur" + steen.kleur}
  class:joker={steen.isJoker}
  on:click={() => {
    dispatch("steenKlikt", { steenIndex: index, steenObject: steen });
  }}>{steen.cijfer}</button
>

<style>
  .joker {
    background-color: var(--kleur-joker);
  }

  .joker:hover {
    background-color: var(--kleur-joker-transparant);
  }

  :hover {
    background-color: var(--kleur-steen-transparant);
  }
</style>
