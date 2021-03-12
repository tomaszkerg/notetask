import http from "../http-common";

class NoteService {
    getAll() {
        return http.get("/note/list");
    }

    get(id) {
        return http.get(`/note/${id}`);
    }

    getHistory(id) {
        return http.get(`/note/history/${id}`);
    }

    create(data) {
        return http.post("/note/add", data);
    }

    update(id, data) {
        return http.post(`/note/edit/${id}`, data);
    }

    delete(id) {
        return http.post(`/note/delete/${id}`, id);
    }
}

export default new NoteService();