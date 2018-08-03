import Ember from 'ember';

export default Ember.Component.extend({
  newQuestionRequest: true,
  actions: {
    saveQuestion(){
      var params = {
        content: this.get('content'),
        author: this.get('author'),
        date: this.get('date')
      };
      if (params.content !== undefined && params.author !== undefined && params.date !== undefined) {
        this.set('newQuestionRequest', false);
        this.sendAction('saveQuestion', params);
        this.set('content', '');
        this.set('author', '');
        this.set('date', '');
      } else {
        alert('Please fill out all fields.');
      }
    },
    cancelSaveQuestion(){
      this.set('newQuestionRequest', false);
      this.set('content', '');
      this.set('author', '');
      this.set('date', '');
      this.sendAction('transitionToHome');
    }
  }
});
