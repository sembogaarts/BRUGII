<template>
    <div>

        <div v-if="loading" class="loader-wrapper">
            <i class="fas loader fa-sync fa-spin"></i>
        </div>

        <!-- Template Generator -->
        <div v-if="hasTemplate && !loading">

            <form @submit.prevent>

                <div v-for="(tag, index) in template.tags">

                    <!-- Render the field depending on type -->
                    <field
                            :value.sync="tag.value"
                            :tag="tag"
                            :tags="template.tags"
                            :index="index"
                            :schema="schema">
                    </field>


                    <!-- Render Loop -->
                    <div v-if="isLoop(tag.type)">

                        <div v-for="(row, rowIndex) in getLoopRows(tag)" class="group">

                            <div v-for="(field, fieldIndex) in row" class="groupinputbox">

                                <!-- Render the field depending on type -->
                                <field
                                        :value.sync="field.value[rowIndex]"
                                        :tag="field"
                                        :tags="template.tags"
                                        :index="index"
                                        :fieldIndex="fieldIndex"
                                        :schema="schema"
                                        :rowIndex="rowIndex"
                                        :loop="row">
                                </field>

                            </div>
                        </div>

                        <button @click="addLoopRow(tag)"><i class="fas fa-plus-circle"></i> Addrow</button>

                    </div>

                </div>

                <button type="submit" @click="onSubmit()"><i class="fas fa-sync-alt"></i> Genereer</button>

            </form>

        </div>

    </div>
</template>

<script src="./editor.js"></script>
