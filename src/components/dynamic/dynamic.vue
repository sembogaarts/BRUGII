<template>
    <div>
        <!-- String, Number, Boolean -->
        <input v-if="isString(type)" :id="tag.name" type="text" :value="field" @input="onInput($event)">
        <input v-if="isNumber(type)" :id="tag.name" type="number" :value="field" @input="onInput($event)">
        <input v-if="isBoolean(type)" :id="tag.name" type="checkbox" :value="field" @input="onInput($event)">
        <!-- Show error -->
        <p style="margin-bottom: 10px;" v-if="noType">Geen kolom geselecteerd.</p>
    </div>
</template>

<script src="./dynamic.js"></script>
