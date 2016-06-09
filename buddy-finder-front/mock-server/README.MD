SERWER

/login POST
{
    email: String,
    password: String
}

w zwrotce:
{
    token: String,
    userId: ID USERA
}
lub
{
    status: error,
    msgs: String (lista)
}


/logout POST
{
    token: String
}

w zwrotce: nic


WSZYSTKIE POSTY POZA LOGIN mają mieć parametr token=STRING_TOKENU

/users/:id GET #INFORMACJE O UZYTKOWNIKU
w zwrotce:
{
    email: String,
    lastname: String,
    firstname: String,
    login: String

}

/users/:id/edit POST #ZMIANA INFORMACJI
{
    email: String,
    firstname: String,
    lastname: String,
    login: String
}

w zwrotce:
{
    status: OK
}

lub

{
    status: error,
    msgs: String (lista)
}

/users/new POST #REJESTRACJA
{
    email: String,
    name: String,
    surname: String,
    login: String,
    password: String
}

w zwrotce:
{
    status: OK
}

lub
{
    status: error,
    title: String,
    detail:String
}

/offers/:id GET #OFERTA

w zwrotce:
{
    type: TypeOfOffer,
    user: OfferOwner,
    when: Date,
    where: Place,
    anotherInfo: StringWithInfo,
    prefferedSex: femaleOrMale,
    prefferedAge: AgeRange
}

/offers GET #LISTA WSZYSTKICH OFERT

w zwrotce:
{
    offers: [{
                 type: TypeOfOffer,
                 user: OfferOwner,
                 when: Date,
                 where: Place,
                 anotherInfo: StringWithInfo,
                 prefferedSex: femaleOrMale,
                 prefferedAge: AgeRange
             }],
    count: INTEGER #ILE JEST WSZYSTKICH
}

/offers?filter_date=01-01-2016 GET #LISTA OFERT OD ZALOGOWANIA
w zwrotce:
{
    offers: [{
                 type: TypeOfOffer,
                 user: OfferOwner,
                 when: Date,
                 where: Place,
                 anotherInfo: StringWithInfo,
                 prefferedSex: femaleOrMale,
                 prefferedAge: AgeRange
             }],
    count: INTEGER #ILE JEST WSZYSTKICH
}

/users/:id/offers GET #LISTA TWOICH OFERT
w zwrotce:
{
    offers: [{
                 type: TypeOfOffer,
                 user: OfferOwner,
                 when: Date,
                 where: Place,
                 anotherInfo: StringWithInfo,
                 prefferedSex: femaleOrMale,
                 prefferedAge: AgeRange
             }],
    count: INTEGER #ILE JEST WSZYSTKICH
}

/users/:id/offers/new POST #DODAJ OFERTE
{
                 type: TypeOfOffer,
                 user: OfferOwner,
                 when: Date,
                 where: Place,
                 anotherInfo: StringWithInfo,
                 prefferedSex: femaleOrMale,
                 prefferedAge: AgeRange
}

w zwrotce:
{
    status: OK
}

lub

{
    status: error,
    title: String,
    detail:String
}

/users/:id/offers/:offerId/edit POST #EDYCJA OFERTY
{
                 type: TypeOfOffer,
                 user: OfferOwner,
                 when: Date,
                 where: Place,
                 anotherInfo: StringWithInfo,
                 prefferedSex: femaleOrMale,
                 prefferedAge: AgeRange
}

w zwrotce:
{
    status: OK
}

lub

{
    status: error,
    title: String,
    detail:String
}

/users/:id/offers/:offerId DELETE #USUNIECIE OFERTY
w zwrotce:
{
    status: OK
}

lub

{
    status: error,
    title: String,
    detail:String
}
