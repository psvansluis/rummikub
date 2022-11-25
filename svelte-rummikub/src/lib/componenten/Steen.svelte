<script lang="ts">
  import { createEventDispatcher } from "svelte";
  import type { Steen } from "../../types/SpelStatus.type";

  const dispatch = createEventDispatcher();

  export let steen: Steen;
  export let index: number;
</script>

<button
  class={"steen kleur" + steen.kleur}
  on:click={() => {
    dispatch("steenKlikt", { steenIndex: index });
  }}>{steen.cijfer}</button
>

<style>
  :hover {
    background: var(--kleur-steen-transparant);
  }

  .kleur0 {
    color: black;
  }

  .kleur1 {
    color: red;
  }

  .kleur2 {
    color: green;
  }

  .kleur3 {
    color: blue;
  }
</style>
