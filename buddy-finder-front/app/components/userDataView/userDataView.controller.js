export default class UserDataViewController {

    getUsersData() {
        this.usersService.getUserSessionData((response) => {
            this.userData = response.user;
        })
    }

    constructor(usersService) {
        this.usersService = usersService;
        this.userData = {
            name: '',
            surname: '',
            email: ''
        };
        this.getUsersData();
    }


}
