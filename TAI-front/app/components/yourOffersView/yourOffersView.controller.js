
export default class YourOffersViewController {
    constructor(offersService, usersService) {
        this.offersService = offersService;
        this.usersService = usersService;
        this.usersService.verifyAuthorization();
        this.getOffersList();
    }

    getOffersList() {
        this.offersService.getUserOffers(this.usersService.getUserSessionData().userId)
            .then(successResponse => {
                this.offersList = successResponse.data;
            });
    }

    deleteOffer(offer) {
        console.log("DUPA");
        console.log(offer);
        this.offersService.deleteOffer(offer.offerId)
            .then(success => {
                this.offersList = this.getOffersList();
            }, error => {
                console.log("ERROR")
            })
    }



}
