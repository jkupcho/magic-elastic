'use strict';

/**
 * @ngdoc function
 * @name magicSiteApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the magicSiteApp
 */
angular.module('magicSiteApp')
  .controller('MainCtrl', function ($scope) {
    $scope.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];
  });
