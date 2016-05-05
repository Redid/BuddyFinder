import homeComponent from './home.component';

export default app => {
    app.config(($stateProvider, $urlRouterProvider) => {
        $urlRouterProvider.otherwise('/');

        $stateProvider
            .state('home', {
                url: '/',
                templateUrl: 'templates/home.html'
            })
            .state('login', {
                url: '/login',
                template: '<t-login></t-login>'
                //templateUrl: 'templates/login.html'
            })
            .state('register', {
                url: '/register',
                template: '<t-register></t-register>'
            })
            .state('logged', {
                url: '/logged',
                templateUrl: 'templates/logged.html'
            })
            .state('logged.yourOffer', {
                url: '/yourOffer',
                templateUrl: 'templates/app/yourOffer.html'
            })
            .state('logged.addOffer', {
                url: '/addOffer',
                templateUrl: 'templates/app/addOffer.html'
            })
            .state('logged.viewOffer', {
                url: '/viewOffer',
                templateUrl: 'templates/app/viewOffer.html'
            })
            .state('logged.editOffer', {
                url: '/editOffer',
                templateUrl: 'templates/app/editOffer.html'
            })
            .state('logged.newOffer', {
                url: '/newOffer',
                templateUrl: 'templates/app/newOffer.html'
            })
    }).directive('home', homeComponent);

    if (ENVIRONMENT === 'test') {
        require('./home.test.js');
    }
}
