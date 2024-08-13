<template>
    <section class='whiteCloudsBody'>
        <section class="top">
            <div class="title">
                <h1>White Clouds</h1>
                <h2>Stats Below</h2>
                <ul>
                    <li v-for="course in courses" :key="course.id">{{ course.name }}</li>
                </ul>
                <!-- Attempt at video for each course -->

                <!-- <video id="background-video" autoplay loop muted>
                <source src="../video/White Clouds.mp4" type="video/mp4">
                Your browser does not support the video tag.
            </video> -->

            </div>
        </section>
        <section class="middle">
            <h2>this is middle | stats here</h2>

        </section>
        <section class="bottom">
            <h2>this is bottom</h2>
        </section>
    </section>
</template>

<script>
import WhiteCloudsService from '../services/WhiteCloudsService.js';


export default {
    data() {
        return {
            courses: []
        };
    },
    methods: {
       getTopics() {
            WhiteCloudsService.courseList()
            .then(response => {
                this.courses = response.data;
            });
        },
    },
};
</script>

<style>
.whiteCloudsBody {
    margin: 0;
    padding: 0;
    height: 50%;
    width: 100%;
    display: grid;
    grid-template-rows: 1fr 1fr 1fr;
    grid-template-columns: 1fr;
    grid-template-areas:
        "top"
        "middle"
        "bottom"
    ;


}

.top {

    border-bottom: 5px solid black;
    background-image: url('../img/Golf/WhiteCloudsPhoto.jpg');

    text-align: center;
    padding: 200px;

    height: 10px;
    background-repeat: no-repeat;
    background-size: cover;
    background-position: center center;
    grid-area: top;

}

h1,
h2 {
    color: white;

}

.top h1,
h2 {}

.middle {
    text-align: center;
    grid-area: middle;
    border-bottom: 5px black solid;

}

.middle h2 {
    color: black;
}

.bottom {
    grid-area: bottom;
    text-align: center;

}

.bottom h2 {
    color: black;
}


/* #background-video {
    height: 100vh;
    width: 100vw;
    position: fixed;
    left: 0;
    right: 0;
    top: 0;
    bottom: 100%;
    z-index: -1;
} */

/* video {
    height: auto;
    width: 100%;
} */

/* @media (min-aspect-ratio: 16/9) {
    #background-video {
        width: 100%;
        height: auto;
    }
}

@media (max-aspect-ratio: 16/9) {
    #background-video {
        width: auto;
        height: 100%;
    }
} */
</style>