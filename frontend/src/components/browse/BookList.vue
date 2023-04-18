<script setup lang="ts">
import { ref, toRef } from 'vue'
import type { Book } from '@/types'
import FilterModal from '@/components/browse/FilterModal.vue'
import IconFunnel from '@/components/icons/IconFunnnel.vue'

import BookListItem from './BookListItem.vue'
import type { FilterSettings } from './FilterModal.vue'

const props = defineProps<{ books: Book[] }>()

const showFilterModal = ref(false)

const filteredBooks = ref(toRef(props, 'books'))

function filterBooks(filterSettings: FilterSettings) {
  if (filterSettings.onlyAvailable) {
    filteredBooks.value = props.books.filter((book) => !book.lentUntil)
    return
  }
  filteredBooks.value = props.books
}
</script>

<template>
  <FilterModal
    :show="showFilterModal"
    @close="showFilterModal = false"
    @change="filterBooks"
  ></FilterModal>
  <ul>
    <li>
      <button @pointerdown="showFilterModal = true" type="button">
        <IconFunnel></IconFunnel>
        <p>Liste filtern</p>
      </button>
    </li>
    <BookListItem v-for="book of filteredBooks" :key="book.id" :book="book"></BookListItem>
  </ul>
</template>

<style scoped>
li:first-child {
  display: grid;
  place-content: center;
  padding: 0.25rem 0;
}

li:first-child svg {
  width: 1.5rem;
  height: 1.5rem;
}

li:first-child button {
  border: none;
  align-items: center;
  color: var(--blue-primary-900);
  column-gap: 0.5rem;
  display: flex;
  font-size: 1rem;
  font-weight: 500;
  justify-content: center;
  background-color: inherit;
}

li:not(:last-child) {
  border-bottom: 1px var(--gray-300) solid;
}
</style>
