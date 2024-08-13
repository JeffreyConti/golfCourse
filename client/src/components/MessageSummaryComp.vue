<template>
    <section class='bodyTemple'>
        <div class='form'>
            <h1>Message Board</h1>
            <form @submit.prevent="submitMessage">
                <input id='title' v-model="newMessage.title" placeholder="Title" required />
                <textarea id='text' v-model="newMessage.message" placeholder="Your Message" required></textarea>
                <button type="submit">Post Message</button>
            </form>
            <ul class='message'>
                <li v-for="message in messages" :key="message.id">
                    <strong>{{ message.title }}</strong>
                    <p>{{ message.message }}</p>
                    <button id='deleteBTN' @click.prevent="deleteMessage(message.message_id)">Delete</button>
                </li>

            </ul>
        </div>
    </section>
</template>

<script>
import MessageBoardService from '../services/MessageBoardService.js'

export default {
    data() {
        return {
            messages: [],
            newMessage: {
                title: '',
                message: '',
            },
        };
    },
    async created() {
        this.messages = (await MessageBoardService.messageList()).data;
    },
    methods: {
        async submitMessage() {
            const response = await MessageBoardService.postMessage(this.newMessage);
            this.messages.unshift(response.data);
            this.newMessage.title = '';
            this.newMessage.message = '';
        },
        // Working on this
        async deleteMessage(messageId) {
            await MessageBoardService.deleteMessage(messageId);
            this.messages = this.messages.filter(message => message.id !== id);
        }
    },

};
</script>

<style>
.bodyTemple{
    height: 100vh;
    background-color: lightcyan;
}
.message li {
    background: rgb(245, 245, 245);
    border: solid 4px rgba(0, 0, 0, 0.5);
    border-radius: 10px;
    margin-bottom: 10px;
    padding: 15px;
    /* text-shadow: 0 1px 1px rgba(255, 255, 255, 0.8); */
    word-wrap: break-word;
    cursor: pointer;
    list-style-type: none;
}

form {
    display: flex;
    align-items: center;
    justify-content: center;
    flex-direction: column;
    gap: 20px;
}

#title {
    width: 10%;
    padding: 15px;
}

#text {
    padding: 100px;
}

/* #delete {
    text-align: right;
} */

button {
    cursor: pointer;
}

strong {
    border-bottom: black 3px solid;
}

h1 {
    color: black;
    text-align: center;
}


#deleteBTN {}
</style>
