export default class UserDataViewController {

    getUsersData() {
        this.usersService.getUser(this.usersService.getUserSessionData().userId).then(successResponse => {
            this.userData = successResponse.data;
        })
    }

    constructor(usersService) {
        this.usersService = usersService;
        this.userData = {
            index: '',
            name: '',
            surname: '',
            academicYear: '',
            email: '',
            schedule: ''
        };
        this.getUsersData();
    }


}
