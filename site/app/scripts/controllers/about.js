'use strict';

/**
 * @ngdoc function
 * @name magicSiteApp.controller:AboutCtrl
 * @description
 * # AboutCtrl
 * Controller of the magicSiteApp
 */
angular.module('magicSiteApp')
  .controller('AboutCtrl', function ($scope) {
    $scope.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];
  });
