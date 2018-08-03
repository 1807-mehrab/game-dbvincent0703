import Ember from 'ember';

export default Ember.Route.extend({
  actions: {
    like(answer) {
      var currentLikes = answer.get('likes');
      var totalLikes = currentLikes += 1;
      answer.setProperties({ likes: totalLikes });
      answer.save();
      this.transitionTo('my-favorites');
    },
    dislike(answer) {
      var currentDislikes = answer.get('dislikes');
      var totalDislikes = currentDislikes += 1;
      answer.setProperties({ dislikes: totalDislikes });
      answer.save();
      this.transitionTo('my-favorites');
    },
    transitionToIndex() {
      this.transitionTo('index');
    }
  }
});
