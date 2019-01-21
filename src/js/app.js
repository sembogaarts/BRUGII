import Vue from '../../node_modules/vue/dist/vue';
import router from './router';
import axios from 'axios'
import VueAxios from 'vue-axios'

Vue.use(VueAxios, axios);

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
