<template>
    <article class="card" @click="$emit('open', trip.id)">
        <img v-if="trip?.photos?.length" :src="trip.photos[0]" alt="" />
        <div>
            <h3>{{ trip.title }}</h3>
            <p>{{ trip.description }}</p>
            <small>{{ trip.province }}</small>
        </div>
    </article>
</template>

<script setup>
defineProps({
    trip: { type: Object, required: true },
});
defineEmits(["open"]);
</script>

<style>
.card {
    display: flex;
    gap: 12px;
    cursor: pointer;
    padding: 8px;
    border: 1px solid #eee;
    border-radius: 8px;
}

.card img {
    width: 160px;
    height: 110px;
    object-fit: cover;
    border-radius: 8px;
}
</style>
