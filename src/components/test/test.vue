<template>
    <div>
        <input v-if="type === 'number'" type="number" @input="onChange($event)" :value="test">
        <input v-if="type === 'string'" type="text" @input="onChange($event)" :value="test">
    </div>
</template>

<script src="./test.js"></script>
