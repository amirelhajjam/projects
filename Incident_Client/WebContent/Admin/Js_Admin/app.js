/**
 * 
 */
'use strict';
 
var App = angular.module('myApp',["ui.router","ngStorage"]);
App.config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider) {
	$stateProvider
	.state('connexion', {
		url: "/connexion",
		templateUrl: "Admin/connexion.jsp",
		controller: "AdminController"
	})
	.state("AddFournisseur",{
		url: "/AddFournisseur",
		templateUrl: "Admin/AddFournisseur.jsp"
	})
	.state("index",{
		url: "/index",
		templateUrl: "Admin/Index_Admin.jsp",
		controller: "indexController"
	})
	
    
}]);