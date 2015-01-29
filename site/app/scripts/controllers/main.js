'use strict';

/**
 * @ngdoc function
 * @name magicSiteApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the magicSiteApp
 */
angular.module('magicSiteApp')
  .controller('MainCtrl', function ($scope, $http) {
    $scope.search = '';
    $scope.cards = {};
    $scope.timeout = 0;

    $scope.$watch('search', function (value) {
      clearTimeout($scope.timeout);
      if (value !== '') {
        $scope.timeout = setTimeout($scope.queryCards, 500);
      }
    });

    $scope.queryCards = function () {
      $http.get('/api/search', {
        params: {
          name: $scope.name
        }
      }).success(function (data) {

      }).error(function (error) {
        console.log('error!');
      });
    };

  });
