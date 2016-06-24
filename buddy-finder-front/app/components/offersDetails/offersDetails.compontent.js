
import controller from './offersDetails.controller';

export default {
    restrict: 'E',
    scope: {},
    bindings: {
        type: '@'
    },
    templateUrl: 'templates/app/viewOfferDetails.html',
    controller,
    controllerAs: 'offerDetailsCtrl',
    bindToController: true
};
