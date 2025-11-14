<script setup>
import { RouterLink, RouterView } from "vue-router";

// ใช้แค่โชว์ base API เผื่อเช็คตอน dev
const BASE_API = import.meta.env.VITE_BASE_API || "http://localhost:8080/api";
</script>

<template>
    <div class="app">
        <header class="nav">
            <nav class="container">
                <RouterLink to="/" class="brand">🌴 เที่ยวไหนดี</RouterLink>
                <div class="links">
                    <a :href="BASE_API + '/health'" target="_blank" rel="noopener">API Health</a>
                    <a href="https://github.com/PTAE43/travel-project" target="_blank" rel="noopener">GitHub</a>
                </div>
            </nav>
        </header>

        <section class="container">
            <RouterView />
        </section>

        <footer class="footer">
            <div class="container">
                <small>© 2025 Travel App · API: {{ BASE_API }}</small>
            </div>
        </footer>
    </div>
</template>

<style scoped>
.app {
    min-height: 100dvh;
    display: flex;
    flex-direction: column;
}

.container {
    max-width: 980px;
    margin: 0 auto;
    padding: 0 16px;
}

.nav {
    border-bottom: 1px solid #eee;
    background: #fff;
    position: sticky;
    top: 0;
    z-index: 10;
}

.nav nav {
    display: flex;
    align-items: center;
    justify-content: space-between;
    height: 60px;
}

.brand {
    font-weight: 700;
    text-decoration: none;
    color: #0d6efd;
    font-size: 20px;
}

.links a {
    margin-left: 14px;
    color: #444;
    text-decoration: none;
}

.links a:hover {
    text-decoration: underline;
}

.footer {
    margin-top: auto;
    padding: 16px 0;
    border-top: 1px solid #eee;
    background: #fafafa;
    color: #666;
}
</style>
