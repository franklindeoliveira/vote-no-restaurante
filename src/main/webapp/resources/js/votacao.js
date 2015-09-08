$(function() {
	
	var indexComparacoes = 0;
	var comparacoes = [];
	var votos = [];
	var restaurantes = [];
	
	$.ajax({
		url: 'restaurantes',
		success: function(data) {
			console.log('Restaurantes carregados com sucesso.');
			restaurantes = data;
			comparacoes = geraComparacoes(restaurantes);
			for (var i = 0; i < restaurantes.length; i++) {
				votos.push({id_restaurante: restaurantes[i].id, numero_votos: 0});
			}
			exibeRestauranteAB(comparacoes[indexComparacoes].restaurante_a, comparacoes[indexComparacoes].restaurante_b);
		},
		error: function() {
			console.log('Ocorreu um erro ao carregar os restaurantes.');
		}
	});
	
	$('#restauranteA').click(function(event) {
		console.log('Escolha: Restaurante A');
		if (indexComparacoes < comparacoes.length) {
			var id = $(event.currentTarget).attr('data-id');
			for (var i = 0; i < votos.length; i++) {
				if (id == votos[i].id_restaurante) {
					votos[i].numero_votos++;
					var porcentagem = indexComparacoes / comparacoes.length * 100 + '%';
					$('#progress-bar').width(porcentagem);
					$('#progress-bar').html(porcentagem);
					break;
				}
			}
			exibeRestauranteAB(comparacoes[indexComparacoes].restaurante_a, comparacoes[indexComparacoes].restaurante_b);
		} else {
			$('#restauranteA').remove();
			$('#restauranteB').remove();
			$('#progress').hide();
			
			$('#message').html('Salve suas preferencias que a seguir exibiremos seu ranking pessoal, juntamente com o ranking geral dos restaurante mais votados.');
			$('#cadastra').show();
			var result = quickSort(votos, 0, votos.length - 1);
			var ranking = '';
			for (var i = 0; i < result.length; i++) {
				var restaurante = getRestauranteById(result[i].id_restaurante);
				ranking += restaurante.id + ',' + i + ';'; 
			}
			$('#ranking').val(ranking);
		}
	});
	$('#restauranteB').click(function(event) {
		console.log('Escolha: Restaurante B');
		if (indexComparacoes < comparacoes.length) {
			var id = $(event.currentTarget).attr('data-id');
			for (var i = 0; i < votos.length; i++) {
				if (id == votos[i].id_restaurante) {
					votos[i].numero_votos++;
					var porcentagem = indexComparacoes / comparacoes.length * 100 + '%';
					$('#progress-bar').width(porcentagem);
					$('#progress-bar').html(porcentagem);
					break;
				}
			}
			exibeRestauranteAB(comparacoes[indexComparacoes].restaurante_a, comparacoes[indexComparacoes].restaurante_b);
		} else {
			$('#restauranteA').remove();
			$('#restauranteB').remove();
			$('#progress').hide();
			$('#cadastra').show();
			var result = quickSort(votos, 0, votos.length - 1);
			var ranking = '';
			for (var i = 0; i < result.length; i++) {
				var restaurante = getRestauranteById(result[i].id_restaurante);
				ranking += restaurante.id + ',' + i + ';';
			}
			$('#ranking').val(ranking);
		}
	});
	
	$('#cadastra').submit(function(event) {
		if ($('#nome').val().trim().length == 0  || $('#email').val().trim().length == 0) {
			event.preventDefault();
			$('#erroAlert').show();
		}
	});
	
	function getRestauranteById(id) {
		var restaurante = null;
		for (var i = 0; i < restaurantes.length; i++) {
			if (restaurantes[i].id == id) {
				restaurante = restaurantes[i];
			}
		}
		return restaurante;
	}
	
	// Algoritmo quicksort obtido de https://gist.github.com/marioluan/5605583
	function partition( array, left, right ) {
		var	pivot = array[Math.floor((left + right)/2)],
			i 	  = left,
			j 	  = right;

		
		while ( i <= j ) {

			while ( array[i].numero_votos >  pivot.numero_votos ) {
				i++;
			}

			while ( array[j].numero_votos <  pivot.numero_votos ) {
				j--;
			}

			if ( i <= j ) {
				swap(array, i, j);
				i++;
				j--;
			}
		}
		return i;
	}

	function swap( array, leftIndex, rightIndex ) {
		var left = array[leftIndex],
			right = array[rightIndex];

		array[leftIndex] = right;
		array[rightIndex] = left;
	}

	function quickSort( array, left, right ) {

	    var index;

	    if (array.length > 1) {

	        index = partition(array, left, right);

	        if (left < index - 1) {
	            quickSort(array, left, index - 1);
	        }

	        if (index < right) {
	            quickSort(array, index, right);
	        }

	    }

	    return array;
	}

	function exibeRestauranteAB(restauranteA, restauranteB) {
		$('#imgA').attr('src', restauranteA.logo);
		$('#nomeA').html(restauranteA.nome);
		$('#restauranteA').attr('data-id', restauranteA.id);

		$('#imgB').attr('src', restauranteB.logo);
		$('#nomeB').html(restauranteB.nome);
		$('#restauranteB').attr('data-id', restauranteB.id);
		
		indexComparacoes++;
	}

	// gera comparacoes dois a dois.
	function geraComparacoes(itens) {
		var comparacoes = [];
		var j;
		var k = 0;
		for (var i = 0; i < itens.length; i++) {
		   for (j = i+1; j < itens.length; j++) {
		      comparacoes.push({restaurante_a: itens[i], restaurante_b: itens[j]});
		   }
		}
		return comparacoes;
	}
});

