<template>
    <div>

        <!-- Template Selector -->
        <select @change="getTemplateInformation()" v-model="selectedTemplate" name="templateSelector" id="templateSelector">
            <option disabled value="null" selected>Selecteer een template</option>
            <option v-for="template in templates" :value="template.id">{{ template.name }}</option>
        </select>

        <!-- Template Generator -->
        <div v-if="hasTemplate">

            <form @submit.prevent>

                <div v-for="(tag, index) in template.tags">

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

                    <div v-if="isLoop(tag.type)">

                        <div v-for="row in tag.rows">

                        <div v-for="field in row">
                            {{ field }}
                        </div>

                        </div>

                        <button @click="addLoopRow(index)">Addrow</button>
                    </div>


                </div>
                <button type="submit" @click="onSubmit()">Genereer</button>

            </form>

        </div>

    </div>
</template>

<script src="./generator.js"></script>
