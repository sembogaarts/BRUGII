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

            <!--<table v-if="!loading" class="table">-->
                <!--<thead class="table-header">-->
                <!--<th></th>-->
                <!--<th> Business Rule</th>-->
                <!--<th> Status</th>-->
                <!--<th class="iconth"> Maintain</th>-->
                <!--<th class="iconth"> Generate</th>-->
                <!--</thead>-->
                <!--<tbody>-->
                <!--<tr v-for="(businessrule, index) in businessrules">-->
                    <!--<td><div class="fancyCheckbox"> <input id="fancyCheckboxInput" type="checkbox" @click="toggleCheckedBusinessRule(businessrule.id)"> <label for="fancyCheckboxInput"> </label> </div> </td>-->
                    <!--<td> {{businessrule.name}}</td>-->
                    <!--<td> {{businessrule.status}}</td>-->
                    <!--<td><router-link :to="path(businessrule)"><i class="far fa-edit"></i></router-link></td>-->
                    <!--<td @click="generateBusinessRule(businessrule.id)"><i class="fas fa-sync-alt"></i></td>-->
                <!--</tr>-->
                <tr>
                    <td><input id="fancyCheckboxInput" type="checkbox" > <label for="fancyCheckboxInput" class="check">
                        <svg width="18px" height="18px" viewBox="0 0 18 18">
                            <path d="M1,9 L1,3.5 C1,2 2,1 3.5,1 L14.5,1 C16,1 17,2 17,3.5 L17,14.5 C17,16 16,17 14.5,17 L3.5,17 C2,17 1,16 1,14.5 L1,9 Z"></path>
                            <polyline points="1 9 7 14 15 4"></polyline>
                        </svg>
                    </label> </td>
                    <td> Test </td>
                    <td> Test </td>
                    <td> link </td>
                    <td> <i class="fas fa-sync-alt"></i> </td>
                </tr>
                <tr>
                </tr>
                </tbody>
            </table>

        </div>
    </div>
</template>
<script src="./manager.js"></script>

