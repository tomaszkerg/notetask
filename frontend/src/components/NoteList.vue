<template>
  <div class="list row">
    <div class="col-md-6">
      <h4>Notes List</h4>
      <ul class="list-group">
        <li class="list-group-item"
            :class="{ active: index == currentIndex }"
            v-for="(note, index) in notes"
            :key="index"
            @click="setActiveNote(note, index)"
        >
          {{ note.title }}
        </li>
      </ul>
      <router-link :to="'/list'" class="badge badge-warning">View all notes</router-link>
    </div>
    <div class="col-md-6">
      <div v-if="currentNote">
        <h4>Note</h4>
        <div>
          <label><strong>Title:</strong></label> {{ currentNote.title }}
        </div>
        <div>
          <label><strong>Content:</strong></label> {{ currentNote.content }}
        </div>
        <div>
          <label><strong>Created:</strong></label> {{ currentNote.created }}
        </div>
        <div>
          <label><strong>Modified:</strong></label> {{ currentNote.modified }}
        </div>
        <router-link :to="'/note/' + currentNote.id" class="badge badge-warning">Edit</router-link>
      </div>
      <router-link :to="'/history/' + currentNote.id" class="badge badge-warning">View History</router-link>
    </div>

    <div>
      <br/>
      <p>click on note</p>
    </div>

  </div>

</template>

<script>
import NoteService from "../services/NoteService";

export default {
  name: "notes-list",
  data() {
    return {
      notes: [],
      currentNote: null,
      currentIndex: -1,
      title: "",
      previousNotes: []
    };
  },
  methods: {
    retrieveNotes() {
      NoteService.getAll()
          .then(response => {
            this.notes = response.data;
            console.log(response.data);
          })
          .catch(e => {
            console.log(e);
          });
    },
    refreshList() {
      this.retrieveNotes();
      this.currentNote = null;
      this.currentIndex = -1;
    },
    setActiveNote(note, index) {
      this.currentNote = note;
      this.currentIndex = index;
    }
  },
  mounted() {
    this.retrieveNotes();
  }
};
</script>

<style>
.list {
  text-align: right;
  max-width: 600px;
  margin: auto;
}
</style>