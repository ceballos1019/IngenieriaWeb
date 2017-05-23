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
	};
	
	this.guardar = function(cliente) {
		return $http({
			url : 'http://localhost:8080/EjemploJersey/ceballos/cliente',
			method : 'POST',
			params: {
				identificacion: cliente.cedula,
				nombres:cliente.nombre,
				apellidos:cliente.apellidos,
				correo: cliente.email,
				usuarioCrea: 'elver'
			}
		});
	};
});

appCliente.service('usuarios', function($http) {
	this.autenticar = function(usuario, passwd) {
		return $http({
			url: 'localhost:8080/EjemploJersey/ceballos/usuario',
			method: 'GET',
			params: {
				login: usuario,
				pass: passwd
			}
		});
	}
});

appCliente.controller('listaClientes', function($scope, $location, clientes) {
	clientes.listaClientes().then(function success(data) {
		$scope.listaClientes = data.data.clienteJersey;
	});
	
	$scope.agregar = function() {
		$location.url('/nuevo');
	}
});

appCliente.controller('clienteController', function($scope, $location, clientes) {
	$scope.cliente = {
			nombre:'',
			apellidos:'',
			cedula:'',
			email:''
	};
	
	$scope.guardar = function() {
		clientes.guardar($scope.cliente).then(function success(data) {
			alert('Cliente creado');
			$location.url('/listaClientes');
		});
	}
});

appCliente.controller('login', function($scope, $location, usuarios) {
	$scope.nombreUsuario = '';
	$scope.passwd = '';
	$scope.login = function() {
		usuarios.autenticar($scope.nombreUsuario, $scope.passwd).then(function success(data) {
			$location.url('/listaClientes');
		},
		
		function failure(data) {
			console.log(data);
		})
	}
})

appCliente.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/listaClientes', {
		templateUrl : 'ListaCliente.html',
		controller : 'listaClientes'
	});
	
	$routeProvider.when('/', {
		templateUrl : 'Login.html',
		controller : 'login'
	});
	
	$routeProvider.when('/nuevo', {
		templateUrl : 'Cliente.html',
		controller : 'clienteController'
	});
} ]);