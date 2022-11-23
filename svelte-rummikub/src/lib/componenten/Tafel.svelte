<script lang="ts">
  import type { Set } from "../../types/SpelStatus.type";
  export let sets: Set[];
</script>

<div id="tafel" />

<style>
  #tafel {
    border: 2px solid black;
    border-radius: 5px;
    margin: 0 auto;
    padding: 5px;
    background-color: var(--color-two);
    background-image: url("../../assets/black-linen.png");
    height: 500px;
    min-width: 600px;
    width: 80%;
  }
</style>
