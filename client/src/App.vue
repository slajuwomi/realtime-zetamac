<script setup>

</script>

<template>
  <nav>
    <RouterLink to="/">Go to Home</RouterLink>
    <RouterLink to="/chat">Go to Chat</RouterLink>
    <RouterLink to="/game">Go to Game</RouterLink>
  </nav>
  <main>
    <RouterView/>
  </main>
</template>

<style scoped>
nav > a + a {
  margin-left: 10px;
}
</style>
