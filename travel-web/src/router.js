import { createRouter, createWebHistory } from "vue-router";
import HomePage from "./pages/HomePage.vue";
import TripDetail from "./pages/TripDetail.vue";

export default createRouter({
    history: createWebHistory(),
    routes: [
        { path: "/", component: HomePage },
        { path: "/trips/:id", component: TripDetail, props: true },
    ],
});