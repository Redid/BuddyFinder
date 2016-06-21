
export default class OffersViewController {
    constructor(offersService, usersService, $state) {
        this.offersService = offersService;
        this.usersService = usersService;
        this.$state = $state;
        this.offersList = [];
    }

    init() {
        this.getOffersList();
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

}
