// Angular & Router ES6 Imports
import angular from 'angular';
import angularUIRouter from 'angular-ui-router';
import appComponents from './components/components.js';
import commonComponents from './common/components.js';
import appServices from './services/services.js';
import appConfiguration from './app.config';
import datepicker from 'angular-ui-bootstrap/src/datepicker';


// Single Style Entry Point
import './index.scss';

if (ENVIRONMENT === 'test') {
  console.log('ENV:', ENVIRONMENT);
  require('angular-mocks/angular-mocks');
}

const app = angular.module('app', ['ui.router', datepicker]);

// Components Entrypoint
appComponents(app);

// Common Components Entrypoint
commonComponents(app);

appConfiguration(app);

// App Services Entrypoint
appServices(app);

app.config(['$httpProvider', function($httpProvider) {
  $httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
}]);

// Router Configuration
// Components must be declared first since
// Routes reference controllers that will be bound to route templates.
