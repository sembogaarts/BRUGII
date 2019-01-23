import Vue from '../../node_modules/vue/dist/vue';
import VueRouter from '../../node_modules/vue-router/dist/vue-router';
// Components
import GeneratorComponent from '../components/generator/generator.vue';
import ManagerComponent from '../components/manager/manager.vue';

Vue.use(VueRouter);

// Create the router
const router = new VueRouter({

    routes: [
        {
            path: '/',
            name: 'Manager',
            icon: 'fa-columns',
            component: ManagerComponent
        },
        {
            path: '/creator',
            name: 'Creator',
            icon: 'fa-database',
            component: GeneratorComponent
        },
    ]

});

export default router;
