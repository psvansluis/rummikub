import { writable, type Writable } from "svelte/store";

export const doelContainerIndex: Writable<number> = writable(null);
export const bronIndex: Writable<{ container: number; steen: number }> =
  writable(null);
