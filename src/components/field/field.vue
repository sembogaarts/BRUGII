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
            <option v-for="table in schema" :value="table.name">{{ table.name }}</option>
        </select>

        <!-- Columns -->
        <select v-if="isColumn(tag.type)" v-model="tag.value" :id="tag.name">
            <option selected value="" disabled>Selecteer een kolom</option>
            <option v-for="column in columns()" :value="column.name" :data-type="column.type">{{ column.name }}</option>
        </select>

        <!-- Binders -->
        <select v-if="isBinder(tag.type)" :id="tag.name">
            <option selected value="" disabled>Selecteer een binder</option>
            <option v-for="binder in binders()" :value="binder">{{ binder }}</option>
        </select>

        <!-- Operators -->
        <select v-if="isOperator(tag.type)" :id="tag.name">
            <option selected value="" disabled>Selecteer een operator</option>
            <option v-for="operator in getOperatorsForEarlierField()" :value="operator">{{ operator }}</option>
        </select>

        <!-- State -->
        <select v-if="isState(tag.type)" v-model="tag.value" :id="tag.name">
            <option selected value="" disabled>Selecteer een state</option>
            <option value="BEFORE">BEFORE</option>
            <option value="AFTER">AFTER</option>
        </select>

        <!-- Event -->
        <select v-if="isEvent(tag.type)" v-model="tag.value" :id="tag.name">
            <option selected value="" disabled>Selecteer een event</option>
            <option value="INSERT">INSERT</option>
            <option value="UPDATE">UPDATE</option>
        </select>

    </div>

</template>

<script src="./field.js"></script>
