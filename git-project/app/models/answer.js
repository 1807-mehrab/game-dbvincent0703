import DS from 'ember-data';

export default DS.Model.extend({
  content: DS.attr(),
  author: DS.attr(),
  date: DS.attr(),
  question: DS.belongsTo('question', { async: true }),
  likes: DS.attr(),
  dislikes: DS.attr()
});
