<template>
  <div class="list row">
    <div class="col-md-6">
      <div v-if="currentNote">
        <h4>Note History</h4>
        {{ getPreviousNotes() }}
        <li v-for="note in previousNotes" :key="note.id">

          <div>
            <label><strong>Title:</strong></label> {{ note.title }}
          </div>
          <div>
            <label><strong>Content:</strong></label> {{ note.content }}
          </div>
          <div>
            <label><strong>Created:</strong></label> {{ note.created }}
          </div>
          <div>
            <label><strong>Modified:</strong></label> {{ note.modified }}
          </div>
        </li>
      </div>

      <div>
        <br/>
        <p>click on note</p>
      </div>
    </div>
  </div>
</template>

<script>
import NoteService from "../services/NoteService";

export default {
  name: "note",
  data() {
    return {
      currentNote: null,
      message: '',
      previousNotes: []
    };
  },
  methods: {
    getNote(id) {
      NoteService.get(id)
          .then(response => {
            this.currentNote = response.data;
            console.log(response.data);
          })
          .catch(e => {
            console.log(e);
          });
    },
    getPreviousNotes() {
      NoteService.getPreviousNotes(this.currentNote.original)
          .then(response => {
            this.previousNotes = response.data;
            console.log(response.data);
          })
          .catch(e => {
            console.log(e);
          });
    }
  },
  mounted() {
    this.message = '';
    this.getNote(this.$route.params.id);
  }
};
</script>

<style>
.edit-form{
  max-width: 200px;
  margin: auto;
}
</style>