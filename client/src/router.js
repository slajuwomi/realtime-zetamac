import {createMemoryHistory, createRouter} from 'vue-router'

import ChatView from "@/Chat.vue"
import GameView from "@/Game.vue"
import HomeView from "@/Home.vue"
import JoinChatView from "@/JoinChatView.vue";

const routes = [
    {path: '/', component: HomeView},
    {path: '/chat', component: ChatView},
    {path: '/game', component: GameView},
    {path: "/joinchat", component: JoinChatView}
]

const router = createRouter({
    history: createMemoryHistory(),
    routes,
})

export default router
