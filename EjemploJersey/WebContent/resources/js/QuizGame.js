/**
 * 
 */

var quiz= angular.module('quizModule', []);

quiz.controller('quizController', function($scope){
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
	
	$scope.correctAnswers = 0;
	$scope.userState = '';
	
	$scope.validate = function(question) {
		if(question.correctAnswer == question.userAnswer) {
			$scope.correctAnswers++;
			question.state = 'ok';
		} else {
			if(question.state == 'ok' && $scope.correctAnswers > 0) {
				$scope.correctAnswers--;
			}
			question.state = 'error';
		}
		userState();
	};
	
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