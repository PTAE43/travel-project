<template>
    <main class="container" v-if="trip">
        <h1>{{ trip.title }}</h1>
        <p>{{ trip.description }}</p>
        <div class="photos">
            <img v-for="(p, i) in trip.photos" :key="i" :src="p" />
        </div>
        <p><b>จังหวัด:</b> {{ trip.province }}</p>
    </main>
</template>

<script setup>
import { ref, onMounted } from "vue";
import http from "../api/http";
import { useRoute } from "vue-router";
const route = useRoute();
const trip = ref(null);

onMounted(async () => {
    const { data } = await http.get(`/trips/${route.params.id}`);
    trip.value = data;
});
</script>

<style>
.container {
    max-width: 900px;
    margin: 2rem auto;
    padding: 0 1rem;
}

.photos {
    display: grid;
    grid-template-columns: repeat(auto-fill, minmax(220px, 1fr));
    gap: 12px;
}

.photos img {
    width: 100%;
    height: 160px;
    object-fit: cover;
    border-radius: 8px;
}
</style>
