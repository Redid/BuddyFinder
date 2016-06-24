class OffersService {
    /*@ngInject*/
    constructor($http, buddyServerUrl) {
        this.$http = $http;
        this.baseUrl = buddyServerUrl;

    }

    getUrl(url) {
        return `${this.baseUrl}/${url}`;
    }

    getOffer(offerId) {
        return this.$http({
            url: this.getUrl(`offers/${userId}`),
            method: "GET"
        });
    }
    getOffers() {
        return this.$http({
            url: this.getUrl(`offers/list`),
            method: "GET"
        });
    }
    getNewOffers() {
        return this.$http({
            url: this.getUrl(`offers/list`),
            method: "GET"
        });
    }
    getUserOffers(userId) {
        return this.$http({
            url: this.getUrl(`offers/list/mine`),
            method: "GET"
        });
    }
    createUserOffer(offerData) {
        return this.$http({
            url: this.getUrl(`offers/add`),
            method: "POST",
            data: offerData
        });
    }
    updateUserOffer(userId, offerId, offerData) {
        return this.$http({
            url: this.getUrl(`users/${userId}/offers/${offerId}/edit`),
            method: "PUT",
            data: offerData
        });
    }
    getUserOffer(userId, offerId) {
        return this.$http({
            url: this.getUrl(`users/${userId}/offers/${offerId}`),
            method: "GET"
        });
    }
    deleteUserOffer(userId, offerId) {
        return this.$http({
            url: this.getUrl(`users/${userId}/offers/${offerId}/delete`),
            method: "DELETE"
        });
    }
    deleteOffer(offerId) {
        return this.$http({
            url: this.getUrl(`offers/${offerId}/delete`),
            method: "DELETE"
        });
    }

}

export default OffersService;
