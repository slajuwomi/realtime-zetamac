import {createMemoryHistory, createRouter} from 'vue-router'

import ChatView from "./Chat.vue"
import GameView from "./Game.vue"
import HomeView from "./Home.vue"

const routes = [
    {path: '/chat', component: ChatView},
    {path: '/game', component: GameView},
    {path: '/', component: HomeView},
]

const router = createRouter({
    history: createMemoryHistory(),
    routes,
})

export default router
