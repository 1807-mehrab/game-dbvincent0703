import Ember from 'ember';

export default Ember.Component.extend({
  updateQuestionForm: false,
  actions: {
    updateQuestionForm() {
      this.set('updateQuestionForm', true);
    },
    update(question) {
      var params = {
        content: this.get('update-content'),
        author: this.get('update-author'),
        date: this.get('update-date')
      };
      this.set('updateQuestionForm', false);
      this.sendAction('update', question, params);
      this.set('update-content', '');
      this.set('update-author', '');
      this.set('update-date', '');

    },
    cancelUpdateQuestion(){
      this.set('updateQuestionForm', false);
      this.set('update-content', '');
      this.set('update-author', '');
      this.set('update-date', '');
    }
  }
});
