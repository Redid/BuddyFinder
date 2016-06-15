
export default class AddOfferController {
    constructor(offersService, usersService) {
        this.offersService = offersService;
        this.usersService = usersService;

        this.when = [];
        this.where = '';
        this.anotherInfo = '';
        this.preferredSex = '';
        this.preferredAge = '';
    }

    validate() {
        let valid = true;
        valid = valid && this.when;
        valid = valid && this.where;
        valid = valid && this.anotherInfo;
        valid = valid && this.preferredSex;
        valid = valid && this.preferredAge;

        if(valid) {
            valid = valid && this.when.length > 0;
            valid = valid && this.where.length > 0;
            valid = valid && this.anotherInfo.length > 0;
            valid = valid && this.preferredSex.length > 0;
            valid = valid && this.preferredAge.length > 0;
        }

        if(!valid) {
            this.err = "All fields must be set";
            return false;
        }

        this.err = '';
        return true;
    }

    addOffer() {
        let registrationData = {
            when: this.when,
            where: this.where,
            anotherInfo: this.anotherInfo,
            preferredSex: this.preferredSex,
            preferredAge: this.preferredAge
        };
        registrationData.user = this.usersService.getUserSessionData().userId;
        console.log(registrationData);
        if (this.validate()) {
            this.offersService.createUserOffer(registrationData).then(successResponse => {
                this.err = "Added!";
            }, errorResponse => {
                this.err = 'Error!';
            });
        }
    }
}
