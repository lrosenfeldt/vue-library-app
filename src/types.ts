export type Book = {
  id: number
  title: string
  author: string
  lentUntil: null | Date
}

export type FilterSettings = {
  onlyAvailable: boolean
}
