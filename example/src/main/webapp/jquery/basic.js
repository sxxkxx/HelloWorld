/**
 * 
 */
//document.addEventListener("DOMContentLoaded", loadFunc);

//$(document).ready(loadFunc);
$(loadFunc);

function loadFunc() {
	var p = document.createElement('p'); //dom
	var txt = document.createTextNode("곽튜브");
	p.appendChild(txt);
	document.querySelector('body').appendChild(p);
	var pTag = $('<p />'); // jquery 객체
	pTag.text("빠니보틀");
	$('.bdy').append(pTag);

	console.log(p);
	console.log(pTag);
	//
	var li = document.createElement('li');
	li.innerText = '느그키';
	document.querySelector('body ul#list1').appendChild(li);

	$('body ul#list2').append($('<li/>').text('황디다스'));
}