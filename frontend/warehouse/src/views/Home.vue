<template>
  <div id="app">
    <JumpButton1 />
    <JumpButton2 />
    <JumpButtonImage1 />
  </div>
</template>

<script>
import JumpButton1 from '@/components/JumpButton1.vue' ;
import JumpButton2 from '@/components/JumpButton2.vue';
import JumpButtonImage1 from '@/components/JumpButtonImage1.vue';

export default {
  components: {
    JumpButton1,
    JumpButton2,
    JumpButtonImage1,
  }
}
</script>

