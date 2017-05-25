/**
 * 
 */
var appCliente = angular.module('clientes', [ 'ngRoute', 'ngCookies' ]);

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
			params : {
				identificacion : cliente.cedula,
				nombres : cliente.nombre,
				apellidos : cliente.apellidos,
				correo : cliente.email,
				usuarioCrea : 'elver'
			}
		});
	};
});

appCliente.service('usuarios', function($http, $cookies, $location) {
	this.autenticar = function(usuario, passwd) {
		return $http({
			url : 'localhost:8080/EjemploJersey/ceballos/usuario',
			method : 'GET',
			params : {
				login : usuario,
				pass : passwd
			}
		});
	}

	this.validarEstado = function() {
		if (typeof ($cookies.nombreUsuario) == 'undefined'
				|| $cookies.nombreUsuario == "") {
			$location.url('/');
			return false;
		}
		if($location.url() == '/') {
			
		}
		return true;
	}
});

appCliente.controller('listaClientes', function($scope, $location, clientes,
		usuarios) {

	if (usuarios.validarEstado()) {
		clientes.listaClientes().then(function success(data) {
			$scope.listaClientes = data.data.clienteJersey;
		});
	}
	$scope.agregar = function() {
		$location.url('/nuevo');
	}
});

appCliente.controller('clienteController',
		function($scope, $location, clientes) {
			$scope.cliente = {
				nombre : '',
				apellidos : '',
				cedula : '',
				email : ''
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
		usuarios.autenticar($scope.nombreUsuario, $scope.passwd).then(
				function success(data) {
					alert(data.data);
					if (data.data != '') {
						alert(data.data);
						$scope.nombreUsuario = '';
						$scope.passwd = '';
						return;
					}
					$cookies.nombreUsuario = $scope.nombreUsuario;
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

/*Capturar eventos*/
appCliente.run(function($rootScope, usuarios) {
	$rootScope.$on('$routeChangeStart', function() {
		usuarios.validarEstado();
	});
})