
import controller from './offersView.controller';

export default {
    restrict: 'E',
    scope: {},
    bindings: {
        type: '@'
    },
    templateUrl: 'templates/app/viewOffer.html',
    controller,
    controllerAs: 'offersViewCtrl',
    bindToController: true
};
