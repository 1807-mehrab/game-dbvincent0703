import Ember from 'ember';

export default Ember.Component.extend({
  sortBy: ['likes:desc'],
  sortedAnswers: Ember.computed.sort('answers', 'sortBy'),
  actions: {
    destroyQuestion(question) {
      if (confirm('Are you sure you want to delete this question?')) {
        this.sendAction('destroyQuestion', question);
      }
    },
    like(answer, question) {
      this.sendAction('like', answer, question);
    },
    dislike(answer, question) {
      this.sendAction('dislike', answer, question);
    }
  }
});
