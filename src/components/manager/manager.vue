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

            <table v-if="!loading" class="table">
                <thead class="table-header">
                <th> Business Rule</th>
                <th> Status</th>
                <th class="iconth"> Maintain</th>
                <th class="iconth"> Generate</th>
                </thead>
                <tbody>
                <tr v-for="businessrule in businessrules">
                    <td> {{businessrule.name}}</td>
                    <td> {{businessrule.status}}</td>
                    <td><router-link :to="path(businessrule)"><i class="far fa-edit"></i></router-link></td>
                    <td @click="generateBusinessRule(businessrule.id)"><i class="fas fa-sync-alt"></i></td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</template>
<script src="./manager.js"></script>

