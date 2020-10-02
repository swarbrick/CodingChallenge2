window.onload = function() {
	var listTitle = document.getElementById("listTitle");
	var comments = document.getElementById("comments");
	var response = document.getElementById("response");
	var button = document.getElementById("button");
	button.addEventListener('click', buttonClick);
	
	
	function buttonClick() {
		console.log(listTitle.value);
		console.log(comments.value);
		listTitleV = listTitle.value;
		commentsV = comments.value;
	fetch(`/CodingChallenge2/JSON/grocery-list/createList?listTitle=${listTitleV}&comments=${commentsV}`)
	.then((response) => response.json())
		.then(function(data) {
			console.log(data);
			if(data) {
				response.innerHTML = "Creation successful";
			} else {
				resonse.innerHTML = "Creation not successful";
			}
		}); 
	}
}