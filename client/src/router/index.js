import { createRouter, createWebHistory } from 'vue-router';
import Home from '../views/Home.vue';
import About from '../views/About.vue';
import Login from '../views/Login.vue';
import Register from '../views/Register.vue';
import WhiteClouds from '../views/WhiteClouds.vue'
// import TrailCreek from '../views/TrailCreek.vue'
// import Elkhorn from '../views/Elkhorn.vue'
// import Bigwood from '../views/Bigwood.vue'
import MessageBoard from '../views/MessageboardView.vue'


import { store } from '../main';

export function createAppRouter() {
    const router = createRouter({
        history: createWebHistory(),
        routes: [
            {
                path: '/',
                name: 'Home',
                component: Home,
                meta: {
                    requireAuth: true,
                }
            },
            {
                path: '/about',
                name: 'About',
                component: About,
                meta: {
                    requireAuth: true,
                }
            },
            {
                path: '/whiteclouds',
                name: 'WhiteClouds',
                component: WhiteClouds,
                meta: {
                    requireAuth: true,
                }
            },
            // {
            //     path: '/trailcreek',
            //     name: 'TrailCreek',
            //     component: TrailCreek,
            //     meta: {
            //         requireAuth: true,
            //     }
            // },
            // {
            //     path: '/elkhorn',
            //     name: 'Elkhorn',
            //     component: Elkhorn,
            //     meta: {
            //         requireAuth: true,
            //     }
            // },
            // {
            //     path: '/bigwood',
            //     name: 'Bigwood',
            //     component: Bigwood,
            //     meta: {
            //         requireAuth: true,
            //     }
            // },
            {
                path: '/messageboard',
                name: 'Messageboard',
                component: MessageBoard,
                meta: {
                    requireAuth: true,
                }
            },
            {
                path: '/login',
                name: 'Login',
                component: Login,
                meta: {
                    requireAuth: false,
                }
            },
            {
                path: '/register',
                name: 'Register',
                component: Register,
                meta: {
                    requireAuth: false,
                }
            }
        ]
    });

    router.beforeEach((to, from, next) => {
        if (to.meta.requireAuth  && store.state.token === null) {
            next('/login');
        } else {
            next();
        }
    });
    
    return router;
}