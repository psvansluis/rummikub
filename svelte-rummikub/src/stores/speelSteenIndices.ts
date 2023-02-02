import { writable, type Writable } from "svelte/store";
import type { Steen } from "../types/SpelStatus.type";

export const doelContainerIndex: Writable<number> = writable(null);
export const bronIndices: Writable<{
  container: number;
  steen: number;
  steenObject: Steen;
}> = writable(null);
