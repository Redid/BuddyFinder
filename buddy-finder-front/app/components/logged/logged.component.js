import controller from './logged.controller.js';

export default {
  restrict: 'E',
  scope: {},
  templateUrl: 'templates/logged.html',
  controller,
  controllerAs: 'loggedCtrl',
  bindToController: true
};
