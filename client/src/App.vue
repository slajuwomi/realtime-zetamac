<!--<script setup>-->
<!--import HelloWorld from './components/HelloWorld.vue'-->
<!--import TheWelcome from './components/TheWelcome.vue'-->
<!--</script>-->

<!--<template>-->
<!--  <header>-->
<!--    <img alt="Vue logo" class="logo" src="./assets/logo.svg" width="125" height="125" />-->

<!--    <div class="wrapper">-->
<!--      <HelloWorld msg="You did it!" />-->
<!--    </div>-->
<!--  </header>-->

<!--  <main>-->
<!--    <TheWelcome />-->
<!--  </main>-->
<!--</template>-->

<!--<style scoped>-->
<!--header {-->
<!--  line-height: 1.5;-->
<!--}-->

<!--.logo {-->
<!--  display: block;-->
<!--  margin: 0 auto 2rem;-->
<!--}-->

<!--@media (min-width: 1024px) {-->
<!--  header {-->
<!--    display: flex;-->
<!--    place-items: center;-->
<!--    padding-right: calc(var(&#45;&#45;section-gap) / 2);-->
<!--  }-->

<!--  .logo {-->
<!--    margin: 0 2rem 0 0;-->
<!--  }-->

<!--  header .wrapper {-->
<!--    display: flex;-->
<!--    place-items: flex-start;-->
<!--    flex-wrap: wrap;-->
<!--  }-->
<!--}-->
<!--</style>-->
<script setup>
import {ref, watch} from 'vue'

let firstNumber = ref(0)
let secondNumber = ref(0)
let signs = ["+", "-", "*", "/"]
let sign = ref("")
let correctAnswer = 0
let userAnswer = ref()

function generateNewProblem() {
  firstNumber.value = Math.floor(Math.random() * 10)
  secondNumber.value = Math.floor(Math.random() * 10)
  sign.value = signs[Math.floor(Math.random() * 4)]
  userAnswer.value = ""
  generateCorrectAnswer()
}

function generateCorrectAnswer() {
  if (sign.value === "+") {
    correctAnswer = firstNumber.value + secondNumber.value
  } else if (sign.value === "*") {
    correctAnswer = firstNumber.value * secondNumber.value
  } else if (sign.value === "/") {
    correctAnswer = Math.floor(firstNumber.value / secondNumber.value)
  } else if (sign.value === "-") {
    correctAnswer = firstNumber.value - secondNumber.value
  }
}

// console.log("correct answer", correctAnswer)
watch(userAnswer, (v) => {
  // console.log(Number(v))
  if (Number(v) === correctAnswer) {
    // console.log("here")
    generateNewProblem()
  }
})

generateNewProblem()

</script>
<template>
  <div id="vue-3">
    <div id="input-container">
      <label for="answer-box">{{ firstNumber }} {{ sign }} {{ secondNumber }}</label>
      <input v-model="userAnswer" type="text" id="answer-box" name="answer-box" value=""/>
    </div>
  </div>
</template>
<style>
#app {
  width: 100%;
}

body {
  height: 90vh;
  display: flex;
  align-items: center;
  justify-content: center;
  width: 100%;
  font-size: 48px;
}

#vue-3 {
  display: flex;
  align-items: center;
  justify-content: center;
  width: 100%;
}

#input-container {
  display: flex;
  background-color: #dddddd;
  padding: 5px;
  width: 100%;
  justify-content: center;
}

#input-container label {
  margin-right: 15px;
}

input {
  width: 180px;
  font-size: 48px;
}
</style>
