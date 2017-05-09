var module = angular.module('myModule', []);

module.controller('myController', [ '$scope', function($scope) {
	$scope.list = [{text:'Prueba 1', checked:true}, 
				   {text:'Prueba 2', checked:false}];
	
	$scope.add = function() {
		if(!$scope.texto) {
			alert("Debe digitar el texto");
			return;
		}
		$scope.list.push({text:$scope.texto, checked:false})
		$scope.texto = "";
	};
	
	$scope.delete = function() {
		var num = $scope.list.length;		
		while(num--){			
			if($scope.list[num].checked){
				
				$scope.list.splice(num,1);
			}
		}		
	}
} ])