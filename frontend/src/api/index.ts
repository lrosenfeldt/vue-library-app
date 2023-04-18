export type ExampleBook = {
  id: number
  author: string
  title: string
}

const API_BASE_URL = 'http://localhost:8080'

function callApi(url: string, options?: RequestInit) {
  return fetch(new URL(url, API_BASE_URL), { mode: 'cors', ...options })
}

export async function getExampleBooks(): Promise<ExampleBook[]> {
  const res = await callApi('/example-books', { method: 'GET' })
  return res.json()
}
