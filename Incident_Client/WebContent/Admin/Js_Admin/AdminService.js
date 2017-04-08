'use strict';
 
App.factory('AdminService', ['$http', '$q','$state','$rootScope', function($http, $q,$state,$rootScope,$sessionStorage){
 
    var REST_SERVICE_URI = 'http://localhost:8888/IncidentApp';
     $rootScope.message='';
     var user;
     
    var factory = {
        connexion:connexion,
        index:index
    };
    return factory;
    
    function connexion(t) {
        var deferred = $q.defer();
        console.log("this function execute");
        $http({url: REST_SERVICE_URI+'/connexion',method: 'post',contentType: "application/json",data: t})
            .then(
            function (response) {
            	console.log("this is the responses "+response.status)
            	user = JSON.stringify(response.data);
            	//$sessionStorage.SessionMessage ="this is for test";
            	console.log($sessionStorage.counter)
            	$state.go("index",user);
            	$rootScope.user=user;
            	return user;
               
                
            },
            function(errResponse){
            	console.log("this is the responses 1 "+errResponse.status)
                console.log('Error while creating the information');
                
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
    
    function index(){
    	
    }
}]);
 
