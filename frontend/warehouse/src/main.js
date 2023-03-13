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

const app = createApp(App)
    .use(store)
    .use(router)
    .use(ElementPlus, {size: 'small' })
    .mount('#app')
app.echarts = echarts
