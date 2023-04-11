import type { Book } from './types'

// helper
async function waitFor<T>(value: T, delay = 300): Promise<T> {
  return new Promise<T>((resolve) => setTimeout(() => resolve(value), delay))
}

// dummy api
export async function getAllBooks(): Promise<Book[]> {
  return waitFor([
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
}
