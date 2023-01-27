<script lang="ts">
  import { afterUpdate, createEventDispatcher } from "svelte";
  import type { Steen } from "../../types/SpelStatus.type";

  const dispatch = createEventDispatcher();

  export let steen: Steen;
  export let index: number;
  let cssClass: string;
  afterUpdate(() => (cssClass = classString()));

  function classString(): string {
    if (steen.joker) {
      return "steen joker";
    } else {
      return "steen kleur" + steen.kleur;
    }
  }
</script>

<button
  class={cssClass}
  on:click={() => {
    dispatch("steenKlikt", { steenIndex: index });
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

  .kleur0 {
    color: black;
  }

  .kleur0:hover {
    background-image: linear-gradient(30deg, black 5%, rgba(0, 0, 0, 0) 15%);
  }

  .kleur1 {
    color: red;
  }

  .kleur1:hover {
    background-image: linear-gradient(150deg, red 5%, rgba(0, 0, 0, 0) 15%);
  }

  .kleur2 {
    color: green;
  }

  .kleur2:hover {
    background-image: linear-gradient(210deg, green 5%, rgba(0, 0, 0, 0) 15%);
  }

  .kleur3 {
    color: blue;
  }

  .kleur3:hover {
    background-image: linear-gradient(330deg, blue 5%, rgba(0, 0, 0, 0) 15%);
  }
</style>
