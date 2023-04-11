<script setup lang="ts">
import { ref } from 'vue'
import { RouterLink, RouterView } from 'vue-router'
import IconBurgerMenu from './components/icons/IconBurger.vue'

const showMenu = ref(false)
</script>

<template>
  <header>
    <nav>
      <button type="button" aria-label="Navigationsleiste öffnen" @click="showMenu = true">
        <IconBurgerMenu />
      </button>
      <h1>Stöbern</h1>
    </nav>
  </header>

  <div class="menu" v-if="showMenu">
    <nav>
      <h2>Vue Library</h2>
      <ul>
        <li>
          <RouterLink to="/">Home</RouterLink>
        </li>
        <li>
          <RouterLink to="/about">About</RouterLink>
        </li>
      </ul>
    </nav>
    <div role="presentation" @click="showMenu = false"></div>
  </div>

  <RouterView />
</template>

<style scoped>
header nav {
  align-items: center;
  background-color: var(--blue-primary-900);
  color: white;
  display: flex;
  gap: 1rem;
  padding: 1rem 0;
}

header nav h1 {
  font-size: 2rem;
  font-weight: 700;
}

header nav button {
  background-color: transparent;
  border: none;
  color: white;
}

header nav svg {
  height: 3rem;
  width: 3rem;
}

.menu {
  display: grid;
  grid-template-columns: 75% 25%;
  height: 100%;
  inset: 0 0 0 0;
  position: fixed;
  widows: 100%;
  z-index: 2000;
}

/* backdrop */
.menu div[role='presentation'] {
  background-color: rgb(0 0 0 / 50%);
}

.menu nav {
  background-color: white;
  padding: 1rem 0.5rem;
}

.menu nav h2 {
  margin-bottom: 2rem;
}
</style>
