<template>
    <main class="container">
        <h1>🌴 เที่ยวไหนดี</h1>

        <SearchBar :q="q" @search="load" />
        <div v-if="loading">กำลังโหลด...</div>
        <p v-if="error" style="color:#d33;margin:.5rem 0;">❌ {{ error }}</p>

        <section v-else class="grid">
            <TripCard v-for="t in trips" :key="t.id" :trip="t" @open="goDetail" />
        </section>
    </main>
</template>

<script setup>
import { ref, onMounted } from "vue";
import http from "../api/http";
import SearchBar from "../components/SearchBar.vue";
import TripCard from "../components/TripCard.vue";
import { useRouter } from "vue-router";

const router = useRouter();
const trips = ref([]);
const q = ref("");
const loading = ref(false);
const error = ref("");

async function load(query = "") {
    loading.value = true;
    error.value = "";
    try {
        const url = query
            ? `/trips/search?q=${encodeURIComponent(query)}`
            : `/trips`;
        const { data } = await http.get(url);
        if (Array.isArray(data)) {
            trips.value = data;
        } else {
            throw new Error("API did not return JSON array");
        }
    } catch (e) {
        console.error(e);
        error.value = e?.message || "โหลดข้อมูลไม่สำเร็จ";
        trips.value = [];
    } finally {
        loading.value = false;
    }
}

function goDetail(id) {
    router.push(`/trips/${id}`);
}

onMounted(() => load());
</script>

<style>
.container {
    max-width: 900px;
    margin: 2rem auto;
    padding: 0 1rem;
}

.grid {
    display: grid;
    gap: 16px;
}
</style>
