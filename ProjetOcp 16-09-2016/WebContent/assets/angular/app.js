app = angular.module('myApp', [])

app.controller("empctrl",function($scope,$http){
	 $scope.employee = [];
	    $scope.loadData = function(employes)
	    {
	        $scope.employee = JSON.parse(employes);
	        console.log(employes[0].nom);
	    };
	    
})

app.controller("fournctrl",function($scope,$http){
	 $scope.fournisseurs = [];
	    $scope.loadData = function(fourn)
	    {
	        $scope.fournisseurs = JSON.parse(fourn);
	        
	    };
	    
})
