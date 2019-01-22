<template>
    <div>
        <!-- String, Number, Boolean -->
        <input v-if="isString(type)" :id="tag.name" type="text" v-model="tag.value[rowIndex]">
        <input v-if="isNumber(type)" :id="tag.name" type="number" v-model="tag.value[rowIndex]">
        <input v-if="isBoolean(type)" :id="tag.name" type="checkbox" v-model="tag.value[rowIndex]">
        <p style="margin-bottom: 10px;" v-if="noType">Geen kolom geselecteerd.</p>
    </div>
</template>

<script src="./dynamic.js"></script>
