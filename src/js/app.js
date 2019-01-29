import Vue from '../../node_modules/vue/dist/vue';
import router from './router';
import axios from 'axios'
import VueAxios from 'vue-axios'
import FieldComponent from '../components/field/field.vue';
import GeneratorComponent from '../components/generator/generator.vue';
import ManagerComponent from '../components/manager/manager.vue';
import EditorComponent from '../components/editor/editor.vue';
import sweetalert from 'sweetalert2';

Vue.use(
    VueAxios,
    axios
);

window.sw = sweetalert;

// Register Components
Vue.component('field', FieldComponent);
Vue.component('editor', EditorComponent);
Vue.component('manager', ManagerComponent);
Vue.component('generator', GeneratorComponent);

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
