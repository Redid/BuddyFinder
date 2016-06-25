export default function () {
    function link(scope, element) {

    }
    return {
        scope: {
            address: '=',
        },
        restrict: "AE",
        link: link,
        template: 'Address: <input type="text"/>',
        controller: function($scope, $element){
            const autocomplete = new google.maps.places.Autocomplete($element.find('input')[0], {types: ['geocode']});

            autocomplete.addListener('place_changed', () => {
                var place = autocomplete.getPlace();
                $scope.address = place.formatted_address;
            });
        }
    };
};
