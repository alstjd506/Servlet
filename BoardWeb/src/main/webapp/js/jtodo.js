/**
 * todo.js
 */
// Create a "close" button and append it to each list item
$(document).ready(function() {

	$('li').each(function() {
		var span = $('<span></span>').addClass('close').text('\u00D7');
		$(this).append(span);
	});

	$(document).on('click', '.close', function() {
		$(this).parent().hide();
	});

	$('ul').on('click', 'li', function() {
		$(this).toggleClass('checked');
	})

	$('#addBtn').on('click', function() {
		var inputValue = $('#myInput').val();
		if (inputValue === '') {
			alert("You must write something!");
		} else {
			var li = $('<li></li>').text(inputValue);
			var span = $('<span></span>').addClass('close').text('\u00D7');
			li.append(span);
			$('#myUL').append(li);
		}
		$('#myInput').val('');
	});
})
