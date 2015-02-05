'use strict';

describe('Directive: cardListItem', function () {

  // load the directive's module
  beforeEach(module('magicSiteApp'));

  var element,
    scope;

  beforeEach(inject(function ($rootScope) {
    scope = $rootScope.$new();
  }));

  it('should make hidden element visible', inject(function ($compile) {
    element = angular.element('<card-list-item></card-list-item>');
    element = $compile(element)(scope);
    expect(element.text()).toBe('this is the cardListItem directive');
  }));
});
