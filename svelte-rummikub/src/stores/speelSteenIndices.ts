import { writable, type Writable } from "svelte/store";

export const doelContainerIndex: Writable<number> = writable(null);
export const bronIndices: Writable<{ container: number; steen: number }> =
  writable(null);
