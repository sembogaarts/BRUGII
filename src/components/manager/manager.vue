<template>
    <div>
        <div class="card-wrapper">
            <div class="card">
                <span class="card-header"> Business Rules </span>
                <span class="card-p"> Alle Business Rules onderhouden </span>
            </div>
            <table class="table">
                <thead class="table-header">
                <th> Business Rule</th>
                <th> Status</th>
                <th class="iconth"> Maintain</th>
                <th class="iconth"> Generate</th>
                </thead>
                <tbody>
                <tr v-for="businessrule in businessrules">
                    <td> {{businessrule.name}} </td>
                    <td> {{businessrule.status}} </td>
                    <td> <i class="far fa-edit"> </i> </td>
                    <td> <i @click="generateBusinessRule(businessrule.id)" class="fas fa-sync-alt"></i> </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</template>
<script src="./manager.js"></script>

