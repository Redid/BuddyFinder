
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
        this.offersService.getOffers()
            .then(successResponse => {
                console.log(successResponse);
                this.offersList = successResponse.data.offers;
            });
    }

}
