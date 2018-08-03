import Ember from 'ember';

export default Ember.Component.extend({
  answerIsHidden: true,
  avgLiking: Ember.computed('answer.likes', 'answer.dislikes', function() {
    var likes = this.get('answer.likes');
    var dislikes = this.get('answer.dislikes');
    var score = this.get('answer.likes') / this.get('answer.dislikes');
    if ((score && isFinite(score)) || (likes === 0 && dislikes !== 0)) {
      return score;
    } else if (score || (likes === 0 && dislikes === 0)) {
      return 1;
    } else {
      return 0;
    }
  }),
  actions: {
    like(answer, question) {
      this.sendAction('like', answer, question);
    },
    dislike(answer, question) {
      this.sendAction('dislike', answer, question);
    },
    showAnswer(){
      this.set('answerIsHidden', false);
    }
  }
});
