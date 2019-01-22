import Vue from '../../node_modules/vue/dist/vue';
import router from './router';
import axios from 'axios'
import VueAxios from 'vue-axios'
import FieldComponent from '../components/field/field.vue';
import LoopComponent from '../components/loop/loop.vue';
import DynamicComponent from '../components/dynamic/dynamic.vue';
import hljs from 'highlight.js';
import importSQL from 'highlight.js/lib/languages/sql';
hljs.registerLanguage('sql', importSQL);


Vue.use(
    VueAxios,
    axios
);

// Register Components
Vue.component('field', FieldComponent);
Vue.component('loop', LoopComponent);
Vue.component('dynamic', DynamicComponent);

var app = new Vue({
    router,
    el: '#app',
    data: {
    },
    computed: {
        routes () {
            return this.$router.options.routes;
        },
        pageName () {
            return this.$route.name;
        }
    }
}).$mount('#app');
