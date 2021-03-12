
import Vue from "vue";
import Router from "vue-router";

Vue.use(Router);

export default new Router({
    mode: "history",
    routes: [
        {
            path: "/",
            alias: "/list",
            name: "notes",
            component: () => import("./components/NoteList")
        },
        {
            path: "/note/:id",
            name: "note",
            component: () => import("./components/Note")
        },
        {
            path: "/add",
            name: "add",
            component: () => import("./components/AddNote")
        },
        {
            path: "/history/:id",
            name: "history",
            component: () => import("./components/NoteHistory")
        }
    ]
});