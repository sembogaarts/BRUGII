<template>

    <div>

        <label :for="tag.name">{{ tag.name }}</label>

        <!-- String, Number, Boolean -->
        <input v-if="isString(tag.type)" :id="tag.name" type="text" v-model="tag.value[rowIndex]">
        <input v-if="isNumber(tag.type)" :id="tag.name" type="number" v-model="tag.value[rowIndex]">
        <input v-if="isBoolean(tag.type)" :id="tag.name" type="checkbox" v-model="tag.value[rowIndex]">

        <!-- Tables -->
        <select v-if="isTable(tag.type)" v-model="tag.value[rowIndex]" @change="columns()" :id="tag.name">
            <option selected value="" disabled>Selecteer een tabel</option>
            <option v-for="table in schema" :value="table.name">{{ table.name }}</option>
        </select>

        <!-- Columns -->
        <select v-if="isColumn(tag.type)" v-model="tag.value[rowIndex]" :id="tag.name">
            <option selected value="" disabled>Selecteer een kolom</option>
            <option v-for="column in columns()" :value="column.name" :data-type="column.type">{{ column.name }}</option>
        </select>

        <!-- Binders -->
        <select v-if="isBinder(tag.type)" v-model="tag.value[rowIndex]" :id="tag.name">
            <option selected value="" disabled>Selecteer een binder</option>
            <option v-for="binder in binders()" :value="binder">{{ binder }}</option>
        </select>

        <!-- Operators -->
        <select v-if="isOperator(tag.type)" v-model="tag.value[rowIndex]" :id="tag.name">
            <option selected value="" disabled>Selecteer een operator</option>
            <option v-for="operator in getOperatorsForEarlierField()" :value="operator">{{ operator }}</option>
        </select>

        <!-- Dynamic -->
        <dynamic v-if="isDynamic(tag.type)" :tag="tag" :type="getEarlierFieldType()"></dynamic>

    </div>

</template>

<script src="./loop.js"></script>
