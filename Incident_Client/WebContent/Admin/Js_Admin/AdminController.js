

App.controller('AdminController', ['$scope','$rootScope', 'AdminService', function($scope,$rootScope, AdminService) {
	
	$scope.t={login:'',password:''};
	//$scope.user={id_user: null, nom: '', prenom: '', telephone: '', login: '', password: '', user_type: '', etat:true, addBy: null};
	console.log($scope.message)
	$scope.connexion=function(){
		 
	        AdminService.connexion($scope.t);
	        console.log("heeeerrree "+$rootScope.user);
	        
	        
	    }
	
	console.log($scope.t);
	
}]);

App.controller('indexController',['$scope','$rootScope', 'AdminService', function($scope, AdminService,$rootScope){
	
}]);
App.controller('sideBarController',['$scope','$rootScope', 'AdminService', function($scope, AdminService,$rootScope){

}]);


