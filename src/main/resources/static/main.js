var app = angular.module("ParkingManagement", []);

// Controller Part
app.controller("ParkingController", function($scope, $http) {

    $scope.parkings = [];
    $scope.parking = {
        id: 1,
        name: "",
        coordinateX: 0.0,
        coordinateY: 0.0
    };

    // Now load the data from server
    _refreshParkingData();

    // HTTP POST/PUT methods for add/edit employee
    $scope.submitParking = function() {

        var method = "";
        var url = "";

        if ($scope.parking.id === -1) {
            method = "POST";
            url = '/parking';
        } else {
            method = "PUT";
            url = '/parking';
        }

        $http({
            method: method,
            url: url,
            data: angular.toJson($scope.parking),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(_success, _error);
    };

    $scope.createParking = function() {
        _clearFormData();
    }

    // HTTP DELETE- delete parking by Id
    $scope.deleteParking = function(parking) {
        $http({
            method: 'DELETE',
            url: '/parking/' + parking.id
        }).then(_success, _error);
    };

    // In case of edit
    $scope.editParking = function(parking) {
        $scope.parking.id = parking.id;
        $scope.parking.name = parking.name;
        $scope.parking.coordinateX = parking.coordinateX;
        $scope.parking.coordinateY = parking.coordinateY;
    };

    // Private Method
    // HTTP GET- get all parking collection
    function _refreshParkingData() {
        $http({
            method: 'GET',
            url: '/parkings'
        }).then(
            function(res) { // success
                $scope.parkings = res.data;
            },
            function(res) { // error
                console.log("Error: " + res.status + " : " + res.data);
            }
        );
    }

    function _success(res) {
        _refreshParkingData();
        _clearFormData();
    }

    function _error(res) {
        var data = res.data;
        var status = res.status;
        var header = res.header;
        var config = res.config;
        alert("Error: " + status + ":" + data);
    }

    // Clear the form
    function _clearFormData() {
        $scope.parking.id = "";
        $scope.parking.name = "";
        $scope.parking.coordinateX = "";
        $scope.parking.coordinateY = ""
    }
});