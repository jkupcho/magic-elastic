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
      },
      link: function (scope, element, attrs) {
        scope.rarity = function () {
          var rarity = scope.card.rarity[0].toLowerCase();
          if (rarity !== 'c' ||
              rarity !== 'u' ||
              rarity !== 'r' ||
              rarity !== 'm' ||
              rarity !== 's') {
            rarity = 'c';
          }
          return rarity;
        }
      }
    };
  });
