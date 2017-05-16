/**
 * 
 */
var appCliente = angular.module('clientes', [ 'ngRoute' ]);

appCliente.service('clientes', function($http) {
	this.listaClientes = function() {
		return $http({
			url : 'http://localhost:8080/EjemploJersey/ceballos/cliente',
			method : 'GET'
		});
	}
});

appCliente.controller('listaClientes', function($scope, clientes) {
	clientes.listaClientes().then(function success(data) {
		$scope.listaClientes = data.clienteJersey;
	});
});

appCliente.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/', {
		templateUrl : 'ListaCliente.html',
		controller : 'listaClientes'
	});
} ]);