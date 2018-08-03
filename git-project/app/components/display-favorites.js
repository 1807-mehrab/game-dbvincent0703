import Ember from 'ember';

export default Ember.Component.extend({
  favoritesList: Ember.inject.service(),
  actions: {
      clear() {
        this.get('favoritesList').clearFavorites();
        this.sendAction('transitionToIndex');
      },
      like(answer) {
        this.sendAction('like', answer);
      },
      dislike(answer) {
        this.sendAction('dislike', answer);
      }
    }
});
