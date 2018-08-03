import Ember from 'ember';

export default Ember.Service.extend({
  favorites: [],
  saveToFavorites(question) {
    if (!(this.favorites.includes(question))) {
      this.get('favorites').pushObject(question);
    }
  },
  clearFavorites() {
    this.set('favorites', []);
  }
});
