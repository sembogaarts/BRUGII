<template>
    <div>

        <div class="card-wrapper">

            <div class="card">
                <span class="card-header"> Business Rules </span>
                <span class="card-p"> Alle Business Rules onderhouden </span>
            </div>

            <div v-if="loading" class="loader-wrapper">
                <i class="fas loader fa-sync fa-spin"></i>
            </div>

            <div v-if="error" class="loader-wrapper" @click="getBusinessRules()">
                <i class="fas loader fa-redo-alt"></i>
            </div>

            <table v-if="!loading && !error" class="table">
                <thead class="table-header">
                <th></th>
                <th> Business Rule</th>
                <th> Status</th>
                <th class="iconth"> Maintain</th>
                <th class="iconth"> Generate</th>
                </thead>
                <tbody>
                <tr v-for="(businessrule, index) in businessrules">

                    <td><input class="fancyCheck" :id="businessrule.name" type="checkbox"
                               @click="toggleCheckedBusinessRule(businessrule.id)">
                        <label :for="businessrule.name" class="check"> </label>
                    </td>

                    <td> {{businessrule.name}}</td>
                    <td class="center"> {{businessrule.status}}</td>
                    <td class="center">
                        <router-link :to="path(businessrule)">
                            <i class="far fa-edit"></i>
                        </router-link>
                    </td>
                    <td class="center">
                        <router-link :to="generateBusinessRules([businessrule.id])">
                            <i class="fas fa-sync-alt"></i>
                        </router-link>
                    </td>
                </tr>
                </tbody>
            </table>

        </div>

        <div class="toolbar" v-if="!error && !loading">

            <router-link :to="generateBusinessRules(checkedBusinessRules)">
                <button><i class="fa fa-sync-alt"></i> GENEREREN ({{ checkedBusinessRules.length }})</button>
            </router-link>

            <router-link :to="generateBusinessRules(checkedBusinessRules)">
                <button><i class="fa fa-trash"></i> VERWIJDEREN ({{ checkedBusinessRules.length }})</button>
            </router-link>

        </div>

    </div>
</template>
<script src="./manager.js"></script>

