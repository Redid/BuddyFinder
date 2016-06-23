export default class EditUserController {
    constructor(usersService, $state, $location) {
        this.usersService = usersService;
        this.$state = $state;
        this.$location = $location;
        this.err = '';
        this.name = '';
        this.surname = '';
        this.email = '';
        this.login = '';
        this.age = 1;
        this.sex = 'female';

        this.usersService.getUserSessionData((response) => {
            const user = response.userInfo;
            console.log(user);
            this.age = user.age;
            this.email = user.email;
            this.name = user.firstName;
            this.surname = user.lastName;
            this.login = user.name;
            this.sex = user.sex;
            console.log(this);
        });
    }

    validate() {
        let valid = true;
        valid = valid && this.name;
        valid = valid && this.login;
        valid = valid && this.surname;
        valid = valid && this.email;
        valid = valid && this.password;
        valid = valid && this.repeatedPassword;
        valid = valid && this.sex;

        if(valid) {
            valid = valid && this.name.length > 0;
            valid = valid && this.login.length > 0;
            valid = valid && this.surname.length > 0;
            valid = valid && this.email.length > 0;
            valid = valid && this.password.length > 0;
            valid = valid && this.repeatedPassword.length > 0;
            valid = valid && this.sex.length > 0;
        }

        if(!valid) {
            this.err = "All fields must be set";
            return false;
        }

        if(this.password !== this.repeatedPassword) {
            this.err = "Passwords do not match";
            return false;
        }
        this.err = '';
        return true;
    }

    submit() {
        let registrationData = {
            //login: this.login,
            firstname: this.name,
            lastname: this.surname,
            email: this.email,
            /*password: this.password,*/
            sex: this.sex,
            age: this.age
        };
        console.log(registrationData);
        //if (this.validate()) {
            this.usersService.edit(registrationData).then(successResponse => {
                console.log(successResponse);
                this.$location.path('/logged');
            }, errorResponse => {
                console.log(errorResponse);
            });
        //}
    }
}
