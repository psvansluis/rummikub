<script lang="ts">
  import type { Steen } from "../../types/SpelStatus.type";

  export let steen: Steen;
</script>

<div class={"kleur" + steen.kleur}>{steen.cijfer}</div>

<style>
  div {
    border: 1px solid black;
    border-radius: 3px;
    margin: 1px;
    padding: 10px;
    width: 30px;
    height: 50px;
    background-color: blanchedalmond;
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
