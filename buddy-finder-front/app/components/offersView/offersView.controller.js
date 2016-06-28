
export default class OffersViewController {
    constructor(offersService, usersService, $state) {
        this.offersService = offersService;
        this.usersService = usersService;
        this.$state = $state;
        this.offersList = [];
        this.searchModel = {
            sexEnabled: false,
            whereEnabled: false,
            where: '',
            sex: 'female'
        };
    }

    init() {
        this.getOffersList();
    }

    search() {
        const params = {};
        if(this.searchModel.sexEnabled) {
            params.sex = this.searchModel.sex;
        }
        if(this.searchModel.whereEnabled) {
            params.where = this.searchModel.where;
        }
        console.log(this.searchModel);
        console.log(params);
        this.offersService.searchOffers(params).then((successResponse) => {
            this.offersList = successResponse.data;
        });
    }

    getOffersList() {
        this.usersService.getUserSessionData((response) => {
            let userId = response.user.name;
            let offers = null;
            switch (this.type) {
                case "new":
                    offers = this.offersService.getNewOffers();
                    break;
                case "your":
                    offers = this.offersService.getUserOffers(userId);
                    break;
                case "all":
                default:
                    offers = this.offersService.getOffers();
                    break;
            }
            offers.then((successResponse) => {
                console.log(successResponse);
                this.offersList = successResponse.data.offers;
            });
        });
    }

    getRandomSpan() {
        return Math.floor(Math.random()*50+15);
    }

}
