<template>
  <div class="submit-form">
    <div v-if="!submitted">
      <div class="form-group">
        <label for="title">Title</label>
        <input type="text" class="form-control" id="title" required v-model="note.title" name="title"
        />
      </div>

      <div class="form-group">
        <label for="content">Content</label>
        <input class="form-control" id="content" required v-model="note.content" name="content"
        />
      </div>
      <button
          @click="saveNote" class="btn btn-success">Submit
      </button>
    </div>
    <div v-else>
      <h4>You submitted successfully!</h4>
      <button class="btn btn-success"
              @click="newNote">Add
      </button>
    </div>
  </div>
</template>
<script>
import NoteService from "../services/NoteService";

export default {
  name: "addNote",
  data() {
    return {
      note: {
        id: null,
        title: "",
        content: ""
      },
      submitted: false
    }
  },
  methods: {
    saveNote() {
      let data = {
        title: this.note.title,
        content: this.note.content
      };
      NoteService.create(data)
          .then(response => {
            this.note.id = response.data.id;
            console.log(response.data);
            this.submitted = true;
          })
          .catch(e => {
            console.log(e);
          });
    },

    newNote() {
      this.submitted = false;
      this.note = {};
    }
  }
};
</script>

<style>
.submit-form {
  max-width: 250px;
  margin: auto;
}
</style>