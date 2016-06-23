class UserService {
    /*@ngInject*/
    constructor($http, $location, buddyServerUrl, AuthorizationToken) {
        this.$http = $http;
        this.$location = $location;
        this.baseUrl = buddyServerUrl;
        this.userSessionData = {
            'userId': '',
            'token': AuthorizationToken.NO_AUTH
        };
    }

    getUrl(url) {
        return `${this.baseUrl}/${url}`;
    }

    logout() {
        return this.$http.post(this.getUrl('logout'), {}).success(() => {
            self.authenticated = false;
            this.$location.path("/");
        }).error((data) => {
            console.log("Logout failed")
            this.authenticated = false;
        });
    }

    register(userData) {
        return this.$http({
            url: this.getUrl('register'),
            method: "POST",
            data: userData
        });
    }

    edit(userData) {
        return this.$http({
            url: this.getUrl(`users/edit`),
            method: "POST",
            data: userData
        });
    }

    getUser(userId) {
        return this.$http({
            url: this.getUrl(`users/${userId}`),
            method: "GET"
        });
    }

    deleteUser(userId) {
        return this.$http({
            url: this.getUrl(`users/${userId}/delete`),
            method: "DELETE"
        });
    }

    getUserSessionData(callback) {
        return this.$http.get(this.getUrl("user")).success((data) => {
            if (data.name) {
                this.user = data.name;
                this.userInfo = data,
                    this.authenticated = true;
            } else {
                this.user = "N/A";
                this.authenticated = false;
            }
            if (callback) {
                callback({
                    user: this.user,
                    userInfo: data,
                    authenticated: this.authenticated
                });
            }
        }).error(function () {
            this.user = "N/A";
            this.authenticated = false;

            callback({
                user: this.user,
                authenticated: this.authenticated
            });
        });
    }
}

export default UserService;
