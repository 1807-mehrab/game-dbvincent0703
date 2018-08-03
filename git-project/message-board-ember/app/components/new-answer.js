import Ember from 'ember';

export default Ember.Component.extend({
  actions: {
    saveAnswer(){
      var params = {
        content: this.get('answer-content'),
        author: this.get('answer-author'),
        date: this.get('answer-date'),
        question: this.get('question'),
        likes: 0,
        dislikes: 0
      };
      if (params.content !== undefined && params.author !== undefined && params.date !== undefined) {
        this.sendAction('saveAnswer', params);
        this.set('answer-content', '');
        this.set('answer-author', '');
        this.set('answer-date', '');
      } else {
        alert('Please fill out all fields.');
      }
    },
    cancelSaveAnswer(){
      this.set('answer-content', '');
      this.set('answer-author', '');
      this.set('answer-date', '');
    }
  }
});
