'use strict';

/**
 * @ngdoc directive
 * @name magicSiteApp.directive:cardListItem
 * @description
 * # cardListItem
 */
angular.module('magicSiteApp')
  .directive('cardListItem', function () {
    return {
      templateUrl: 'views/directives/cardListItem.html',
      restrict: 'E',
      scope: {
        card: '='
      }
    };
  });
