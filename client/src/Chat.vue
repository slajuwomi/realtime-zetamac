<script setup>

</script>

<template>
  <h1>Chat Page</h1>
  <div id="chat-area">
    <div class="connecting">
      Connecting...
    </div>
    <ul id="messageArea">

    </ul>
    <form id="messageForm" name="messageForm">
      <input type="text" id="message" placeholder="Type a message..."/>
      <br>
      <button type="submit">Send</button>
    </form>
  </div>
</template>

<style scoped>
#chat-area {
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  border: 2px solid gray;
  border-radius: 5px;
  padding: 15px;
  height: calc(100% - 60px);
  margin-left: auto;
  margin-right: auto;
  max-height: 600px;
  max-width: 600px;
}


</style>