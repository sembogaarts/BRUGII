<template>

    <div class="preview">
        <div class="toolbar" v-if="!error && !loading">

            <button @click="deployBusinessRules()"> Deploy </button>

        </div>
        <div v-if="loading" class="loader-wrapper">
            <i class="fas loader fa-sync fa-spin"></i>
        </div>

        <div v-if="error" class="loader-wrapper" @click="getBusinessRules()">
            <i class="fas loader fa-redo-alt"></i>
        </div>
        <div v-for="template of templates">
            <div class="card-wrapper">
                <div class="card">
                    <span class="card-header"> {{template.name}} </span>
                </div>
                <div v-if="loading" class="loader-wrapper">
                    <i class="fas loader fa-sync fa-spin"></i>
                </div>

                <div v-if="error" class="loader-wrapper" @click="getBusinessRules()">
                    <i class="fas loader fa-redo-alt"></i>
                </div>

                <table v-if="!loading && !error" class="table table-preview">
                    <thead class="table-header">
                        <th> CODE </th>
                    </thead>
                    <tbody>
                        <tr>
                            <td> <pre> <code> {{template.code}} </code></pre></td>
                        </tr>
                    </tbody>
                </table>

            </div>
        </div>
        <div class="toolbar" v-if="!error && !loading">

            <button @click="deployBusinessRules()"> Deploy </button> <br>

        </div>
    </div>

</template>

<script src="./preview.js"></script>
