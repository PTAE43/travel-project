<template>
    <div style="margin:1rem 0;">
        <input v-model="text" placeholder="ค้นหาที่เที่ยว..." @keyup.enter="$emit('search', text)" />
        <button @click="$emit('search', text)">ค้นหา</button>
    </div>
</template>
<script setup>
import { ref } from "vue";
const props = defineProps({ q: String });
const text = ref(props.q || "");
</script>
