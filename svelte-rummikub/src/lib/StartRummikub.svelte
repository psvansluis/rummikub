<script lang="ts">
  let aantalSpelers = 1;
</script>

<h1>TO DO</h1>

<label>
  Aantal spelers: <input type="number" bind:value={aantalSpelers} min="1" />
</label>
<button>Start spel</button>
<p>Een spel met {aantalSpelers} speler{aantalSpelers != 1 ? "s" : ""}.</p>
