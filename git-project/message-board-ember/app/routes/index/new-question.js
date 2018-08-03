import Ember from 'ember';

export default Ember.Route.extend({
  newQuestionRequest: false,
  actions: {
    saveQuestion(params) {
      var newQuestion = this.store.createRecord('question', params);
      newQuestion.save();
      this.transitionTo('index');
    }
  }
});
