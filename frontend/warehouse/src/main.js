import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import ElementPlus from 'element-plus';
import 'element-plus/lib/theme-chalk/index.css';
// import 'dayjs/locale/zh-cn'
// import locale from 'element-plus/lib/locale/lang/zh-cn'
import * as echarts from 'echarts'
import '@/assets/css/global.css'

import { library } from '@fortawesome/fontawesome-svg-core';
import { faArrowRight } from '@fortawesome/free-solid-svg-icons';
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome';

library.add(faArrowRight);

// Vue.component('font-awesome-icon', FontAwesomeIcon);

const app = createApp(App)
    .use(store)
    .use(router)
    .use(ElementPlus, {size: 'small' })
    .component("font-awesome-icon", FontAwesomeIcon)
    .mount('#app')
app.echarts = echarts
