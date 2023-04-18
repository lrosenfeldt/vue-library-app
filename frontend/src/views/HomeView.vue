<script setup lang="ts">
import { onBeforeMount, ref } from 'vue'
import * as api from '@/api'
import BookList from '../components/browse/BookList.vue'
import type { Book } from '@/types'

const books = ref<Book[]>([])

async function fetchBooks() {
  const booksFromServer = await api.getExampleBooks()
  books.value = booksFromServer.map((book) => ({ ...book, lentUntil: null }))
}

onBeforeMount(async () => {
  await fetchBooks()
})
</script>

<template>
  <main>
    <BookList :books="books" />
  </main>
</template>
