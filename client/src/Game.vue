<script setup>
import {ref, watch, onMounted} from 'vue'
import apiClient from '@/services/api'

let firstNumber = ref(0)
let secondNumber = ref(0)
let signs = ["+", "-", "*", "/"]
let sign = ref("")
let correctAnswer = 0
let userAnswer = ref()
const departmentList = ref([])

const formData = ref({
  departmentName: "",
  departmentAddress: "",
  departmentCode: ""
})


const fetchDepartments = async () => {
  try {
    const response = await apiClient.get('/departments')
    departmentList.value = response.data
  } catch (error) {
    console.error("Axios Error:", error.message)
  }
}

const handleSubmit = async () => {
  try {
    const response = await apiClient.post('/departments', formData.value)
    console.log("Post Successful:", response)
  } catch (error) {
    console.error("Post Failed:", error.message)
  }
}

onMounted(() => {
  fetchDepartments()
})

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

watch(userAnswer, (v) => {
  if (Number(v) === correctAnswer) {
    generateNewProblem()
  }
})

generateNewProblem()
</script>

<template>
  <h1>Game Page</h1>
  <div id="vue-3">
    <div id="input-container">
      <label for="answer-box">{{ firstNumber }} {{ sign }} {{ secondNumber }}</label>
      <input v-model="userAnswer" type="text" id="answer-box" name="answer-box" value=""/>
    </div>
  </div>
  <form @submit.prevent="handleSubmit">
    <label>Department Name:</label><input v-model="formData.departmentName"><br>
    <label>Department Address:</label><input v-model="formData.departmentAddress"><br>
    <label>Department Code:</label><input v-model="formData.departmentCode"><br>
    <button type="submit">Submit</button>
  </form>
  <button @click="fetchDepartments">Fetch Departments</button>
  <br>
  <ul>
    <li v-for="dep in departmentList">
      Department ID: {{ dep.departmentId }}
      <br/>
      Department Name: {{ dep.departmentName }}
      <br/>
      Department Address: {{ dep.departmentAddress }}
      <br/>
      Department Code: {{ dep.departmentCode }}
      <br>
      <br>
    </li>
  </ul>
  <main>
    <RouterView/>
  </main>
</template>

<style scoped>


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

button {
  font-size: 24px;
}
</style>
