export default class NavbarController {
  constructor(usersService) {
    this.name = 'navbar';
    this.loggedIn = false;
    this.usersService = usersService

    console.log('test');
    this.usersService.getUserSessionData((response) => {
      console.log(response.user);
      this.loggedIn = response.logged;
    });
  }

  logout() {
    this.usersService.logout();
  }
}
