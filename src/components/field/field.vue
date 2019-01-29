<template>

    <div>

        <label :for="tag.name">{{ tag.name }}</label>

        <!-- String, Number, Boolean -->
        <input v-if="isString(tag.type)" :id="tag.name" type="text" :v-model="value" @input="onInput($event)" required>
        <input v-if="isNumber(tag.type)" :id="tag.name" type="number" :value="value" @input="onInput($event)" required>
        <input v-if="isBoolean(tag.type)" :id="tag.name" type="checkbox" :value="value" @input="onInput($event)" required>

        <!-- Tables -->
        <select v-if="isTable(tag.type)" :value="value" @input="onInput($event)" :id="tag.name" required>
            <option selected value="" disabled>Selecteer een tabel</option>
            <option v-for="table in schema" :value="table.name">{{ table.name }}</option>
        </select>

        <!-- Columns -->
        <select v-if="isColumn(tag.type)" :value="value" @input="onInput($event)" :id="tag.name" required>
            <option selected value="" disabled>Selecteer een kolom</option>
            <option v-for="column in getColumnForEarlierTable()" :value="column.name" :data-type="column.type">{{
                column.name }}
            </option>
        </select>

        <!-- Binders -->
        <select v-if="isBinder(tag.type)" :value="value" @input="onInput($event)" :id="tag.name" required>
            <option selected value="" disabled>Selecteer een binder</option>
            <option v-for="binder in binders()" :value="binder">{{ binder }}</option>
        </select>

        <!-- Operators -->
        <select v-if="isOperator(tag.type)" :value="value" @input="onInput($event)" :id="tag.name" required>
            <option selected value="" disabled>Selecteer een operator</option>
            <option v-for="(operator, index) in getOperatorsForEarlierField(getEarlierFieldType())" :key="index" :value="operator">{{ operator }}</option>
        </select>

        <!-- State -->
        <select v-if="isState(tag.type)" :value="value" @input="onInput($event)" :id="tag.name" required>
            <option selected value="" disabled>Selecteer een state</option>
            <option value="BEFORE">BEFORE</option>
            <option value="AFTER">AFTER</option>
        </select>

        <!-- Event -->
        <select v-if="isEvent(tag.type)" :value="value" @input="onInput($event)" :id="tag.name" required>
            <option selected value="" disabled>Selecteer een event</option>
            <option value="INSERT">INSERT</option>
            <option value="UPDATE">UPDATE</option>
        </select>

        <!-- Dynamic -->
        <div v-if="isDynamic(tag.type)">
            <p class="error" v-if="!getEarlierFieldType()">Selecteer eerst een kolom.</p>
            <!-- String, Number, Boolean -->
            <input v-if="isString(getEarlierFieldType())" :id="tag.name" type="text" :value="value"
                   @input="onInput($event)" required>
            <input v-if="isNumber(getEarlierFieldType())" :id="tag.name" type="number" :value="value"
                   @input="onInput($event)" required>
            <input v-if="isBoolean(getEarlierFieldType())" :id="tag.name" type="checkbox" :value="value"
                   @input="onInput($event)" required>
        </div>

        <div v-if="isList(tag.type)">

            <p class="error" v-if="!getEarlierFieldType()">Selecteer eerst een kolom.</p>

            <!-- String, Number, Boolean -->
            <div v-for="(test, index) in value">
                <input v-if="isString(getEarlierFieldType())" :id="tag.name" type="text" v-model="value[index]" required>
                <input v-if="isNumber(getEarlierFieldType())" :id="tag.name" type="number" v-model="value[index]" required>
                <input v-if="isBoolean(getEarlierFieldType())" :id="tag.name" type="checkbox" v-model="value[index]" required>
            </div>
            <button @click="addListInput(tag)">Voeg rij toe</button>
        </div>

    </div>

</template>

<script src="./field.js"></script>
