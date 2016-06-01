export default class LoginController {
  constructor(usersService, $state) {
    this.usersService = usersService;
    this.username = '';
    this.password = '';
    this.$state = $state;
    this.token = '';
  }

  login() {
    let data = {
      login: this.username,
      password: this.password
    };
    this.usersService.login(data).then(function successCallback(response) {
      this.usersService.setUserSessionData(response.data);
      this.token = response.data.token;
      console.log(this.usersService.getUserSessionData());
      console.log("good!");
      this.$state.go('logged');
    }.bind(this), function errorCallback(response) {
      this.token = response.data.token;
      console.log(response.data)
    }.bind(this));
  }
}
