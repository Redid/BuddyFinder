export default app => {
  app.config([configFn]);
  app.constant('termityServerUrl', 'http://localhost:3333');
  app.constant('AuthorizationToken', {
    'ADMIN' : 'ADMIN',
    'USER' : 'USER',
    'NO_AUTH' : 'NO_AUTH'});
  function configFn() {

  }
}
