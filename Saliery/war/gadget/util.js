function $(id) {
	return document.getElementById(id);
}

function random(maxExclusive) {
	return Math.floor(Math.random() * maxExclusive);
}

function show(element) {
	element.style.display = "";
}

function hide(element) {
	element.style.display = "none";
}