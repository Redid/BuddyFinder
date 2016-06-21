export default class LoggedController {
  constructor(usersService) {
    this.usersService = usersService;
    this.usersService.getUserSessionData((response) => {
      this.user = (response || {}).user;
    });
  }
}
