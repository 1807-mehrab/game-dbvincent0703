import Ember from 'ember';

export default Ember.Component.extend({
  favoritesList: Ember.inject.service(),
  checkForFavorite: Ember.computed('favoritesList', 'question', function() {
    if ((this.get('favoritesList')).favorites.includes(this.get('question'))) {
      return true;
    }
  }),
  actions: {
    addToFavorites(question) {
      this.get('favoritesList').saveToFavorites(question);
      this.set('checkForFavorite', true);
    }
  }
});
