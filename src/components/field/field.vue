<template>

    <div>

        <label :for="tag.name">{{ tag.name }}</label>

        <!-- String, Number, Boolean -->
        <input v-if="isString(tag.type)" :id="tag.name" type="text" v-model="tag.value">
        <input v-if="isNumber(tag.type)" :id="tag.name" type="number" v-model="tag.value">
        <input v-if="isBoolean(tag.type)" :id="tag.name" type="checkbox" v-model="tag.value">

        <!-- Tables -->
        <select v-if="isTable(tag.type)" v-model="tag.value" @change="columns()" :id="tag.name">
            <option selected value="" disabled>Selecteer een tabel</option>
            <option v-for="(table, index) in schema" :value="index">{{ table.name }}</option>
        </select>

        <!-- Columns -->
        <select v-if="isColumn(tag.type)" :id="tag.name">
            <option selected value="" disabled>Selecteer een kolom</option>
            <option v-for="column in columns()" value="">{{ column.name }}</option>
        </select>

        <!-- Columns -->
        <select v-if="isBinder(tag.type)" :id="tag.name">
            <option selected value="" disabled>Selecteer een binder</option>
            <option v-for="binder in binders()" :value="binder">{{ binder }}</option>
        </select>

    </div>

</template>

<script src="./field.js"></script>
