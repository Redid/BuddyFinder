export default class EditUserController {
    constructor(usersService, $state) {
        this.usersService = usersService;
        this.$state = $state;
        this.err = '';
        this.name = '';
        this.surname = '';
        this.email = '';
        this.login = '';
        this.password = '';
        this.repeatedPassword = '';
        this.sex = 'male';
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
            /*password: this.password,
            sex: this.sex*/
        };
        console.log(registrationData);
        //if (this.validate()) {
            this.usersService.edit(registrationData).then(successResponse => {
                console.log(successResponse);
            }, errorResponse => {
                console.log(errorResponse);
            });
        //}
    }
}
