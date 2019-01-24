import Vue from '../../node_modules/vue/dist/vue';
import router from './router';
import axios from 'axios'
import VueAxios from 'vue-axios'
import FieldComponent from '../components/field/field.vue';

Vue.use(
    VueAxios,
    axios
);

// Register Components
Vue.component('field', FieldComponent);

var app = new Vue({
    router,
    el: '#app',
    data: {},
    computed: {
        routes() {
            return this.$router.options.routes;
        },
        pageName() {
            return this.$route.name;
        }
    }
}).$mount('#app');
