<script setup lang="ts">
import type { Book } from '@/types'
defineProps<{ book: Book }>()
</script>

<template>
  <li>
    <p class="author">{{ book.author }}</p>
    <p class="title">{{ book.title }}</p>
    <p class="info" v-if="book.lentUntil">
      Voraussichtlich verfügbar ab {{ new Intl.DateTimeFormat('de-DE').format(book.lentUntil) }}
    </p>
    <button v-else type="button">Ausleihen</button>
  </li>
</template>

<style scoped>
li {
  display: grid;
  row-gap: 1rem;
  padding: 0.25rem;
}

button {
  background-color: var(--blue-primary-900);
  color: white;
  font-weight: 700;
  padding: 0.5rem 1rem;
  justify-self: end;
  border: none;
}

.author,
.info {
  color: var(--gray-700);
}

.info {
  min-height: 2rem;
}

.title {
  font-size: 1.25rem;
  font-weight: 500;
}
</style>
