import homeComponent from './home.component';

export default app => {
    app.config(($stateProvider, $urlRouterProvider) => {
        $urlRouterProvider.otherwise('/');

        $stateProvider
            .state('home', {
                url: '/',
                templateUrl: 'templates/home.html'
            })
            .state('policy', {
                url: '/policy',
                templateUrl: 'templates/app/policy.html'
            })
            .state('privacy', {
                url: '/privacy',
                templateUrl: 'templates/app/privacy.html'
            })
            .state('choices', {
                url: '/choices',
                templateUrl: 'templates/app/choices.html'
            })
            .state('cookies', {
                url: '/cookies',
                templateUrl: 'templates/app/cookies.html'
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
                template: '<t-logged></t-logged>'
            })
            .state('logged.policy', {
                url: '/policy',
                templateUrl: 'templates/app/policy.html'
            })
            .state('logged.privacy', {
                url: '/privacy',
                templateUrl: 'templates/app/privacy.html'
            })
            .state('logged.choices', {
                url: '/choices',
                templateUrl: 'templates/app/choices.html'
            })
            .state('logged.cookies', {
                url: '/cookies',
                templateUrl: 'templates/app/cookies.html'
            })
            .state('logged.yourOffer', {
                url: '/yourOffer',
                template: '<t-offers-view type="your"></t-offers-view>'
            })
            .state('logged.addOffer', {
                url: '/addOffer',
                template: '<t-add-offer></t-add-offer>'
            })
            .state('logged.viewOffer', {
                url: '/viewOffer',
                template: '<t-offers-view type="all"></t-offers-view>'
            })
            .state('logged.editOffer', {
                url: '/editOffer',
                templateUrl: 'templates/app/editOffer.html'
            })
            .state('logged.editUser', {
                url: '/editUser',
                templateUrl: 'templates/app/editUser.html'
            })
            .state('logged.newOffer', {
                url: '/newOffer',
                template: '<t-offers-view type="new"></t-offers-view>'
            })
    }).directive('home', homeComponent);

    if (ENVIRONMENT === 'test') {
        require('./home.test.js');
    }
}
