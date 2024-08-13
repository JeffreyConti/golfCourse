<script>
    import { BIconBatteryFull, BIconBagFill } from 'bootstrap-icons-vue';
    import { VRangeSlider } from 'vuetify/components';
    
    export default {
        components: {
            BIconBatteryFull,
            BIconBagFill,
            VRangeSlider
        },
        data() {
            return {
                ageRange: [18, 30]
            }
        },
    }
</script>
<template>
    <div class="information">
        <h1 id="aboutHeading">About</h1>
        <p class = 'about'>Idaho Links started while two friends were playing golf on a Saturday evening. The friends wanted to create a solution to finding the golf courses in the great state of Idaho.
            This is where 'Idaho Links' was born. 
        </p>
    </div>
</template>
<style>
.information{
    text-align: center;
    background-image:url('../src/img/Golf/WhiteCloudsPhoto.jpg');
    background-size: cover;
    height: 100vh;
    margin-top: -41px;
}
#aboutHeading{
    font-size: 50px;
}
.about{
    border: black solid 5px;
    padding: 48px;
   
    margin-top: 195px;

}
</style>

<!-- <h2>Third-party Component Demos</h2>
        

        <h3>Bootstrap Icon Demo</h3>
        <p>Here is a Bootstrap Icon: <b-icon-battery-full style="color: red" /><b-icon-bag-fill/></p>
        <p><a href="https://www.npmjs.com/package/bootstrap-icons-vue">Bootstrap Icons Vue Library</a></p> 
        <p><a href="https://icons.getbootstrap.com/">Bootstrap Icons Lookup Page</a></p>

        <h3>Vuetify Components Demo (Range Slider)</h3>
        <v-range-slider v-model="ageRange" thumb-label="always" />
        <p><a href="https://vuetifyjs.com/en/components/all/">Vuetify Components Page</a></p>

        <p>First Value: {{ Math.floor(ageRange[0]) }}</p>
        <p>Second Value: {{ Math.floor(ageRange[1]) }}</p> -->