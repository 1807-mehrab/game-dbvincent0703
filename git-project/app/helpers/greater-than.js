import Ember from 'ember';

const greaterThanOne = (params) => params[0] >= 0.5;

export default Ember.Helper.helper(greaterThanOne);
