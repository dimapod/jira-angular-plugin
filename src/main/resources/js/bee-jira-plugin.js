console.log('HELLO BEE JIRA PLUGIN: Init');

AJS.toInit(function () {
    console.log('HELLO BEE JIRA PLUGIN: Loaded');

    angular.module('bee.jira.poc', []);

    angular.module('bee.jira.poc').controller('beeJiraCtrl', ['$scope', function ($scope) {
        $scope.beeWelcome = 'Hello Bee Plugin';

        $scope.hello = function () {
            alert($scope.beeWelcome);
        };
    }]);

});