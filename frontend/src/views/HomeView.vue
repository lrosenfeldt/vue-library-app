<script setup lang="ts">
import { onMounted, ref } from 'vue'
import BookList from '../components/browse/BookList.vue'

const books = ref([
  {
    id: 1,
    title: 'Leviathan fällt',
    author: 'James Corey',
    lentUntil: null
  },
  {
    id: 2,
    title: 'Supernova',
    author: 'Cixin Liu',
    lentUntil: new Date('2023-04-09')
  },
  {
    id: 3,
    title: 'Stalker',
    author: 'Boris Strugazki',
    lentUntil: null
  },
  {
    id: 4,
    title: '1984',
    author: 'George Orwell',
    lentUntil: new Date('2023-04-20')
  }
])

onMounted(() => {
  setTimeout(() => {
    books.value = [
      ...books.value,
      {
        id: 5,
        title: 'Hyperion',
        author: 'Dan Simmons',
        lentUntil: null
      }
    ]
  }, 1_000)
})
</script>

<template>
  <main>
    <BookList :books="books" />
  </main>
</template>
