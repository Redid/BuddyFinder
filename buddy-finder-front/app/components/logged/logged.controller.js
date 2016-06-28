export default class LoggedController {
  constructor(usersService, $location) {
    this.usersService = usersService;
    this.usersService.getUserSessionData((response) => {
      this.user = (response || {}).userInfo;
      if(!response.authenticated) {
        $location.path('/login');
      }
    }, (err) => {
      console.log(err);
    });
  }
}
