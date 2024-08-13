<template>
  <section class="entire">
    <section class="topHalf">
      <div>
        <h1 class='homeTitle'>Idaho Links</h1>
        <h2 id="h2">Find your course below:</h2>
        <form class='homeForm'>
          <input v-model="filter.name" id='courseSearch' placeholder="Course">
          <input v-model="filter.city" id='citySearch' placeholder="City">
          <!-- <input v-model="filter.holes" id='holeSearch' placeholder="Holes"> -->
          <input v-model="filter.open" id='publicOrPrivate' placeholder="Public or Private">
        </form>
        <ul v-if="results.length > 0">
          <li id='searchResultCourse' v-for="result in filteredList" :key="result.courseId">
            <strong>Course:</strong> {{ result.name }} |
            <strong>{{ result.open }}</strong> |
            <strong>Holes:</strong> {{ result.holes }} |
            <strong>Par:</strong> {{ result.par }} |
            <strong>Length:</strong> {{ result.length }} |
            <strong>Slope:</strong>{{ result.slope }} |
            <strong>Rating:</strong>{{ result.rating }}
          </li>
        </ul>
        <p v-else> No results found</p>
      </div>
    </section>
    <section class="bottomHalf">

      <button id='addBTN' @click='toggle = !toggle'>Add Course</button>

      <form v-show="toggle" id="addNewCourse">
        <div class="field">
          <input type="text" id="courseName" name="courseName" required placeholder="CourseName" v-model="newCourse.name" />
          <input type="text" id="courseCity" name="courseCity" placeholder="City" v-model="newCourse.city" />
          <input type="text" id="courseState" name="courseState" placeholder="State" v-model="newCourse.state" />
          <input type="text" id="courseDesigner" name="courseDesigner" placeholder="Designer" v-model="newCourse.designer" />    
          <input type="text" id="courseOpen" name="courseOpen" placeholder="Public or Private" v-model="newCourse.open" />
          <input type="text" id="courseHoles" name="courseHoles" placeholder="Number of Holes" v-model="newCourse.holes" />
          <input type="text" id="courseLength" name="courseLength" placeholder="Course length in yards" v-model="newCourse.length" />
          <input type="text" id="courseRating" name="courseRating" placeholder="Rating" v-model="newCourse.rating" />
          <input type="text" id="courseSlope" name="courseSlope" placeholder="Slope" v-model="newCourse.slope" />
        </div>
        <button type="submit" class="btn save" @click.prevent="submitCourse">Save Course</button>
      </form>
    </section>
  </section>
</template>


<script>
import HomeService from '../services/HomeService.js'
import { BIconConeStriped } from 'bootstrap-icons-vue';

export default {
  data() {
    return {
      filter: {
        name: "",
        city: "",
        holes: "",
        open: ""
      },
      newCourse: {
        courseId: null,
        name: "",
        city: "",
        state: "",
        designer: "",
        open: "",
        holes: "",
        par: "",
        length: "",
        rating: "",
        slope: "",
      },
      nextCourseId: 24,
      results: [],
      course: [],
      toggle: false
    };
  },
  methods: {
    async searchData() {
      try {
        const response = await HomeService.getCourses();
        this.$store.state.courses = response.data;
        this.results = response.data;
      } catch (error) {
        console.error('Error fetching search results', error);
        this.results = [];
      }
    },
    getCourses() {
      HomeService.getCourses().then(results => {
        console.log(results.data);
        this.$store.state.courses = results.data;
      })
    },
    async submitCourse() {
      const response = await HomeService.postCourse(this.newCourse);
      this.newCourse.name = '';
      this.newCourse.city = '';
      this.newCourse.state = '';
      this.newCourse.designer = '';
      this.newCourse.open = '';
      this.newCourse.holes = '';
      this.newCourse.par = '';
      this.newCourse.length = '';
      this.newCourse.rating = '';
      this.newCourse.slope = '';
    }
  },

  computed: {
    filteredList() {

      let filteredResults = this.$store.state.courses;
      if ((this.filter.name == "") && (this.filter.city == "") && (this.filter.open == "")) {
        return [];
      }
      if (this.filter.name != "") {
        filteredResults = filteredResults.filter((result) => {
          return result.name
            .toLowerCase()
            .includes(this.filter.name.toLowerCase())
        }
        );
      }
      if (this.filter.city != "") {
        filteredResults = filteredResults.filter((result) => {
          return result.city
            .toLowerCase()
            .includes(this.filter.city.toLowerCase())
        }
        );
      }
      if (this.filter.open != "") {
        filteredResults = filteredResults.filter((result) => {
          return result.open
            .toLowerCase()
            .includes(this.filter.open)
        }
        );
      }
      return filteredResults;
    }
  },
  created() {
    this.getCourses();
    this.searchData();
  }
}
</script>

<style>
.entire {
  position: relative;
  height: 100vh;
  width: 100%;
  display: flex;
  align-items: center;
  justify-content: center;

  display: grid;

}

.entire::before {
  content: "";
  background-image: url('../img/Golf/HomePhoto.jpg');
  background-size: cover;
  position: absolute;
  top: 0px;
  right: 0px;
  bottom: 0px;
  left: 0px;
  opacity: 0.65;
}

.homeTitle {
  font-size: 120px;
  text-transform: uppercase;
  font-family: 'Gambetta', serif;
  letter-spacing: -3px;
  transition: 700ms ease;
  font-variation-settings: 311;
  margin-bottom: 0.8rem;
  color: black;
  outline: none;
  text-align: center;

  position: relative;
  line-height: 0.9;
  text-align: center;
}

.homeTitle:hover {
  font-variation-settings: 800;
  letter-spacing: 1px;
}

#h2 {
  font-size: 1.2em;
  line-height: 150%;
  text-align: center;
  color: black;
  letter-spacing: .5px;

  position: relative;
}

#searchResultCourse {
  color: black;
  background-color: wheat;
  border: black 3px solid;
  list-style-type: none;
  text-align: center;
  margin: 4px;
  opacity: .9;
  position: relative;
  border-radius: 7px;

}

.homeForm {
  position: relative;
}
.topHalf{
  margin-top: 250px;
}

.bottomHalf {
  display: grid;
  position: relative;
  cursor: pointer;
}
#addNewCourse{
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;

  margin-bottom: 100px;

}
#addNewCourse > input{
  color: blue;
}
#addBTN{
  padding: 15px;
  margin-left: 300px;
  margin-right: 300px;
  margin-bottom: 200px;
}
#courseName,
#courseCity,
#courseState,
#courseDesigner,
#courseOpen, 
#courseHoles, 
#courseLength, 
#courseRating, 
#courseSlope
{
padding: 10px;
}
.field{
  gap:50px;
}
footer{
  margin-top: -50px;
}
</style>