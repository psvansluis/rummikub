<script lang="ts">
  import type { Steen } from "../../types/SpelStatus.type";

  export let steen: Steen;
</script>

<div class={"kleur" + steen.kleur}>{steen.cijfer}</div>

<style>
  div {
    font-size: larger;
    border: 2px solid black;
    border-radius: 10px;
    margin: 5px;
    padding: 10px;
    width: 30px;
    height: 50px;
    background-color: blanchedalmond;
    text-align: center;
    display: inline-block;
    vertical-align: middle;
    box-shadow: 2px 2px 3px black;
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
