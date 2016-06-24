import homeComponent from './home/home';
import loginComponent from './login/login';
import registerComponent from './register/register';
import addOfferComponent from './addOffer/addOffer';
import editUserComponent from './editUser/editUser';
import offersViewComponent from './offersView/offersView';
import userDataViewComponent from './userDataView/userDataView';
import loggedComponent from './logged/logged';
import offersDetails from './offersDetails/offersDetails';

export default app => {
  INCLUDE_ALL_MODULES([homeComponent,
    addOfferComponent,
    loginComponent,
    registerComponent,
    offersViewComponent,
    editUserComponent,
    userDataViewComponent,
    loggedComponent,
    offersDetails], app);
}
