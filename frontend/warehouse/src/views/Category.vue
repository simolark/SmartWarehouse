<template>
  <div id="app">
    <ButtonsImageGroup :buttonLinks="buttonLinks" :buttonPositions="buttonPositions" />
  </div>
</template>

<script>
import ButtonsImageGroup from '@/components/ButtonsImageGroup.vue';

export default {
  components: {
    ButtonsImageGroup,
  },
  data() {
    return {
      buttonLinks: [
      { link: '/news', image: require('@/assets/2.png') },
      { link: '/news', image: require('@/assets/2.png') },
      { link: '/news', image: require('@/assets/2.png') },
      { link: '/news', image: require('@/assets/2.png') },
      { link: '/news', image: require('@/assets/2.png') },
      { link: '/news', image: require('@/assets/2.png') },
      ],
      buttonPositions: [
        { top: 100, left: 300 },
        { top: 100, left: 600 },
        { top: 100, left: 900 },
        { top: 400, left: 300 },
        { top: 400, left: 600 },
        { top: 400, left: 900 },
      ],
    };
  },
};
</script>
