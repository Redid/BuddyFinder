export default class NavbarController {
  constructor(usersService, $location) {
    this.name = 'navbar';
    this.loggedIn = false;
    this.userName = "N/A";
    this.usersService = usersService
    this.$location = $location;

    this.usersService.getUserSessionData((response) => {
      this.loggedIn = response.authenticated;
      this.userName = response.user;
      $location.path('/logged');
    });
  }

  logout() {
    this.usersService.logout();
    this.loggedIn = false;
  }
}
