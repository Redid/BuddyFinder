export default class LoginController {
  constructor(usersService, $state) {
    this.usersService = usersService;
    this.username = '';
    this.password = '';
    this.$state = $state;
    this.token = '';
  }
}
