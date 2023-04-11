<script setup lang="ts">
import BaseModal from '@/components/BaseModal.vue'
import { ref, watch } from 'vue'

export type FilterSettings = { onlyAvailable: boolean }

defineProps<{ show: boolean }>()

const emit = defineEmits<{
  (event: 'change', filterSettings: FilterSettings): void
  (event: 'close'): void
}>()

const initialSettings: FilterSettings = { onlyAvailable: false }
const previousSettings = ref<FilterSettings>({ ...initialSettings })
const settings = ref<FilterSettings>({ ...initialSettings })

watch(settings.value, () => {
  emit('change', settings.value)
})

function onReset() {
  settings.value = { ...initialSettings }
  previousSettings.value = { ...initialSettings }
}

function onDiscard() {
  settings.value = { ...previousSettings.value }
  emit('close')
}

function onSave() {
  previousSettings.value = { ...settings.value }
  emit('close')
}
</script>

<template>
  <BaseModal @close="$emit('close')" v-if="show">
    <form>
      <h2>Filter bearbeiten</h2>
      <ul>
        <li>
          <label for="only-available">Nur verfügbare Titel</label>
          <input name="only-available" type="checkbox" v-model="settings.onlyAvailable" />
        </li>
      </ul>
      <div class="button-group">
        <button class="primary" type="submit" @click.prevent="onSave">Ok</button>
        <button class="secondary" type="button" @click="onDiscard">Abbrechen</button>
        <button class="secondary" type="button" @click="onReset">Zurücksetzen</button>
      </div>
    </form>
  </BaseModal>
</template>

<style scoped>
form {
  position: absolute;
  inset: 0;
  padding: 1rem;
  background-color: white;
  display: flex;
  flex-direction: column;
}

form h2 {
  font-weight: 500;
  font-size: 1.5rem;
  padding-bottom: 1rem;
}

form ul {
  list-style: none;
  padding-bottom: 1rem;
}

form li {
  display: flex;
  justify-content: space-between;
}

button.primary,
button.secondary {
  display: block;
  font-weight: 500;
  letter-spacing: 0.25rem;
  text-transform: uppercase;
  padding: 0.5rem 1rem;
  border: none;
  background-color: inherit;
}

button.primary {
  color: var(--blue-primary-900);
}

button.secondary {
  color: var(--gray-700);
}

.button-group {
  display: grid;
  align-content: center;
  justify-content: end;
  row-gap: 0.5rem;
  justify-self: end;
  margin-top: auto;
}
</style>
