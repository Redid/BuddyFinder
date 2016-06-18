class UserService {
    /*@ngInject*/
    constructor($http, buddyServerUrl, AuthorizationToken) {
        this.$http = $http;
        this.baseUrl = buddyServerUrl;
        this.userSessionData = {
            'userId' : '',
            'token' : AuthorizationToken.NO_AUTH
        };
    }

    getUrl(url) {
        return `${this.baseUrl}/${url}`;
    }

    login(loginData) {
        let fData = new FormData();
        fData.append("username", loginData.login);
        fData.append("password", loginData.password);
        return this.$http({
            url: this.getUrl('login'),
            method: "POST",
            data: fData,
            headers : {
                'Content-Type': 'multipart/form-data'
            }
        });
    }

    logout() {
        return this.$http({
            url: this.getUrl('logout'),
            method: "POST"
        });
    }

    register(userData) {
        return this.$http({
            url: this.getUrl('register'),
            method: "POST",
            data: userData
        });
    }

    edit(userId, userData) {
        return this.$http({
            url: this.getUrl(`users/${userId}/edit`),
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


    setUserSessionData(userSessionData){
        this.userSessionData = userSessionData;
    }
    getUserSessionData(){
        return this.userSessionData;
    }
}

export default UserService;
