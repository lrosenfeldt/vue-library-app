<script setup lang="ts">
defineEmits<{
  (e: 'close'): void
}>()
</script>

<template>
  <div class="modal-backdrop" @pointerdown.self="$emit('close')"></div>
  <div role="dialog">
    <slot />
  </div>
</template>

<style scoped>
div[role='dialog'],
.modal-backdrop {
  position: fixed;
}

div[role='dialog'] {
  z-index: 1500;
  inset: 4rem 2rem;
}
.modal-backdrop {
  background-color: rgb(0 0 0 / 50%);
  display: grid;
  height: 100%;
  inset: 0 0 0 0;
  place-content: center;
  width: 100%;
  z-index: 1000;
}
</style>
