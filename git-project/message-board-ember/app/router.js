import Ember from 'ember';
import config from './config/environment';

const Router = Ember.Router.extend({
  location: config.locationType,
  rootURL: config.rootURL
});

Router.map(function() {
  this.route('about');
  this.route('contact');
  this.route('admin');
  this.route('question', {path: '/question/:question_id'});
  this.route('index', {path: '/'}, function() {
  this.route('new-question', {path: '/new-question'});
  });
  this.route('my-favorites');
});

export default Router;
