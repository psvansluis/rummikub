<script lang="ts">
  import type { Steen } from "../../types/SpelStatus.type";

  export let steen: Steen;
</script>

<button class={"steen kleur" + steen.kleur}>{steen.cijfer}</button>

<style>
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
