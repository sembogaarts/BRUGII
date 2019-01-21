<template>
    <div>

        <!-- Template Selector -->
        <select @change="getTemplateInformation()" v-model="selectedTemplate" name="templateSelector"
                id="templateSelector">
            <option disabled value="null" selected>Selecteer een template</option>
            <option v-for="template in templates" :value="template.id">{{ template.name }}</option>
        </select>

        <!-- Template Generator -->
        <div v-if="hasTemplate">

            <form @submit.prevent>

                <div v-for="(tag, index) in template.tags">

                    <!-- Render the field -->
                    <field :tag="tag" :tags="template.tags" :index="index" :schema="schema"></field>

                    <!-- Render Loop -->
                    <div v-if="isLoop(tag.type)">

                        <div v-for="row in getLoopRows(tag)">

                            test

                        </div>

                        <!--<div v-for="row in tag.fields">-->

                            <!--<div v-for="value in row.value">-->

                                <!--&lt;!&ndash; Render the field &ndash;&gt;-->
                                <!--<field :tag="row" :tags="template.tags" :index="index" :schema="schema"></field>-->

                            <!--</div>-->


                        <!--</div>-->

                        <button @click="addLoopRow(tag)">Addrow</button>

                    </div>


                </div>
                <button type="submit" @click="onSubmit()">Genereer</button>

            </form>

        </div>

    </div>
</template>

<script src="./generator.js"></script>
