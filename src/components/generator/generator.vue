<template>
    <div>

        <div class="template-type-selector">
            <!-- Template Selector -->
            <label for="templateSelector">Selecteer een template type</label>
            <select @change="getTemplateInformation()" v-model="selectedTemplate" name="templateSelector"
                    id="templateSelector">
                <option disabled value="null" selected>Selecteer een template</option>
                <option v-for="template in templates" :value="template.id">{{ template.name }}</option>
            </select>
        </div>

        <!-- Template Generator -->
        <div v-if="hasTemplate">

            <form @submit.prevent>

                <div v-for="(tag, index) in template.tags">

                    <!-- Render the field -->

                    <field :tag="tag" :tags="template.tags" :index="index" :schema="schema"></field>

                    <!-- Render Loop -->
                    <div v-if="isLoop(tag.type)">

                        <div v-for="(row, rowIndex) in getLoopRows(tag)" class="group">
                            <div v-for="(field, index) in row" class="groupinputbox">
                                <!-- Render the field -->
                                <loop :tag="field" :tags="template.tags" :loop="row" :rowIndex="rowIndex" :index="index"
                                      :schema="schema"></loop>
                            </div>
                        </div>

                        <button @click="addLoopRow(tag)"><i class="fas fa-plus-circle"></i> Addrow</button>

                    </div>


                </div>
                <button type="submit" @click="onSubmit()"><i class="fas fa-sync-alt"></i> Genereer</button>

            </form>
            <div class="template-raw"> <pre> <code> test </code> </pre> </div>

            {{ template.tags }}

        </div>

    </div>
</template>

<script src="./generator.js"></script>
