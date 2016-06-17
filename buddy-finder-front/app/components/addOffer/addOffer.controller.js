
export default class AddOfferController {
    constructor(offersService, usersService) {
        this.offersService = offersService;
        this.usersService = usersService;

        this.when = [];
        this.where = '';
        this.anotherInfo = '';
        this.preferredSex = 'female';
        this.preferredAge = {
            min: '',
            max: ''
        };
        this.date = new Date();
    }

    validate(model) {
        let valid = true;
        valid = valid && !!model.when;
        valid = valid && !!model.where;
        valid = valid && !!model.anotherInfo;
        valid = valid && !!model.preferredSex;
        valid = valid && !!model.preferredAge;

        if(valid) {
            valid = valid && model.when.length > 0;
            valid = valid && model.where.length > 0;
            valid = valid && model.anotherInfo.length > 0;
            valid = valid && model.preferredSex.length > 0;
            valid = valid && model.preferredAge.length > 0;
        }

        if(!valid) {
            this.err = "All fields must be set";
            return false;
        }

        this.err = '';
        return true;
    }

    addOffer() {
        console.log(this);
        let registrationData = {
            when: [{
                date: [this.date.getFullYear(), this.date.getMonth(), this.date.getDate()],
                from: "00:00",
                to: "00:00",
            }],
            where: this.where,
            anotherInfo: this.anotherInfo,
            preferredSex: this.preferredSex,
            preferredAge: `${this.preferredAge.min} - ${this.preferredAge.max}`
        };
        registrationData.user = this.usersService.getUserSessionData().userId;
        console.log(registrationData);
        if (this.validate(registrationData)) {
            this.offersService.createUserOffer(registrationData).then(successResponse => {
                this.err = "Added!";
            }, errorResponse => {
                this.err = 'Error!';
            });
        }
    }
}
