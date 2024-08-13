import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:8080"
  });

  export default {

    messageList() {
      return http.get(`/messageboard`);
    },
    details(messageId){
        return http.get(`/messageboard/${messageId}`)
    },
    postMessage(data){
        return http.post('/messageboard', data);
    },
    updateMessage(messageId,data){
        return http.put(`/messageboard/${messageId}`,data);
    },
    deleteMessage(messageId){
        return http.delete(`/messageboard/${messageId}`);
    }
  }