var quiz= angular.module('quizModule', []);

quiz.controller('quizController', function($scope){
	/*Arreglo con las preguntas*/
	$scope.questions = [{
		id:1,
		text: 'Pregunta 1',
		correctAnswer: 1,
		userAnswer: null,
		state:'',
		answers: [{id:1, text: 'Respuesta 1.1'}, 
				  {id:2, text: 'Respuesta 1.2'},
				  {id:3, text: 'Respuesta 1.3'}]
	}, {
		id:2,
		text: 'Pregunta 2',
		correctAnswer: 2,
		userAnswer: null,
		state:'',
		answers: [{id:1, text: 'Respuesta 2.1'}, 
				  {id:2, text: 'Respuesta 2.2'},
				  {id:3, text: 'Respuesta 2.3'}]
	}, {
		id:3,
		text: 'Pregunta 3',
		correctAnswer: 3,
		userAnswer: null,
		state:'',
		answers: [{id:1, text: 'Respuesta 3.1'}, 
				  {id:2, text: 'Respuesta 3.2'},
				  {id:3, text: 'Respuesta 3.3'}]
	}];
	
	/*Variables auxiliares para calificar las respuestas*/
	$scope.correctAnswers = 0;
	$scope.userState = '';
	$scope.showResult = false;
	
	/*Función para validar las respuestas*/
	$scope.validate = function() {
		$scope.correctAnswers = 0;
		
		/*Recorrer el arreglo comparando las respuestas*/
		$scope.questions.forEach(function(question) {
			if(question.correctAnswer == question.userAnswer) {
				$scope.correctAnswers++;
				question.state = 'ok';
			} else {				
				question.state = 'error';
			}
		});		
		/*Organizar la salida en pantalla con el resultado*/
		userState();
		
		/*Mostrar el resultado*/
		$scope.showResult = true;
	};
		
	/*Función para calcular el numero de respuestas correctas y definir el icono a mostrar*/
	function userState() {
		var total = $scope.correctAnswers / $scope.questions.length;
		
		switch(total) {
		case 0: 
			$scope.userState = "looser";
			break;
		case 1:
			$scope.userState = "guru";
			break;
		default:
			$scope.userState = "poor";				
		}
	};
});