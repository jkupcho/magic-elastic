'use strict';

/**
 * @ngdoc function
 * @name magicSiteApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the magicSiteApp
 */
angular.module('magicSiteApp')
  .controller('MainCtrl', function ($scope, $timeout, $http) {
    $scope.search = '';
    $scope.cards = [];
    $scope.timeoutPromise = 0;
    $scope.maxSize = 5;
    $scope.pageUpdatable = false;
    $scope.currentPage = 1;

    $scope.$watch('search', function (value) {
      $timeout.cancel($scope.timeoutPromise);
      if (value !== '') {
        $scope.timeoutPromise = $timeout($scope.queryCards, 500);
      } else {
        $scope.pageUpdatable = false;
        $scope.cards = [];
        $scope.totalItems = 0;
        $scope.itemsPerPage = 0;
      }
    });

    $scope.$watch('currentPage', function (value) {
      if ($scope.pageUpdatable) {
        $scope.queryCards(true);
      }
    });

    $scope.queryCards = function (pageUpdate) {
      $scope.pageUpdatable = false;
      if (!pageUpdate) { 
        $scope.numPages = 0;
        $scope.currentPage = 1; 
      }
      $http.get('/api/search', {
        params: {
          name: $scope.search,
          // Elasticsearch's pages are 0 based, so subtract 1.
          page: $scope.currentPage - 1
        }
      }).success(function (data) {
        $scope.cards = data.content;
        $scope.totalItems = data.totalElements;
        $scope.itemsPerPage = data.size;
        $scope.pageUpdatable = true;
      }).error(function (error) {
        console.log('error!');
      });
    };

  });
