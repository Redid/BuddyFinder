
export default class YourOffersViewController {
    constructor(offersService, usersService) {
        this.offersService = offersService;
        this.usersService = usersService;
        this.getOffersList();
    }

    getOffersList() {
        this.usersService.getUserSessionData((response) => {
            let userId = response.user.name;
            this.offersService.getUserOffers(userId)
                .then(successResponse => {
                    this.offersList = successResponse.data;
                });
        });
    }

    deleteOffer(offer) {
        this.offersService.deleteOffer(offer.offerId)
            .then(success => {
                this.offersList = this.getOffersList();
            }, error => {
                console.log("ERROR")
            })
    }



}
