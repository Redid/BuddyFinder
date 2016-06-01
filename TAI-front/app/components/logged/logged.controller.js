export default class LoggedController {
  constructor(usersService) {
    this.usersService = usersService;
    this.model = this.usersService.getUserSessionData();
    this.user = (this.model || {}).user;
    this.user = this.user || {};
  }
}
