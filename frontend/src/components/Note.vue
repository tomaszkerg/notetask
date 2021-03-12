<template>
  <div v-if="currentNote" class="edit-form">
    <h4>Note</h4>
    <form>
      <div class="form-group">
        <label for="title">Title</label>
        <input type="text" class="form-control" id="title" v-model="currentNote.title"/>
      </div>
      <div class="form-group">
        <label for="content">Content</label>
        <input type="text" class="form-control" id="content" v-model="currentNote.content"/>
      </div>

    </form>

    <button class="badge badge-danger mr-2"
            @click="deleteNote"
    >
      Delete
    </button>

    <button type="submit" class="badge badge-success" @click="updateNote">
      Update
    </button>
    <p>{{ message }}</p>
  </div>

  <div>
    <br/>
    <p>click on note</p>
  </div>
</template>

<script>
import NoteService from "../services/NoteService";

export default {
  name: "note",
  data() {
    return {
      currentNote: null,
      message: ''
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
    updateNote() {
      NoteService.update(this.currentNote.id, this.currentNote)
          .then(response => {
            console.log(response.data);
            this.message = 'successfully updated the note!';
          })
          .catch(e => {
            console.log(e);
          });
    },
    deleteNote() {
      NoteService.delete(this.currentNote.id)
          .then(response => {
            console.log(response.data);
            this.$router.push({name: "notes"});
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
.edit-form {
  max-width: 250px;
  margin: auto;
}
</style>