window.onload = function() {
	var listTitle = document.getElementById("listTitle");
	var comments = document.getElementById("comments");
	var listId = document.getElementById("listId");
	var response = document.getElementById("response");
	var button = document.getElementById("button");
	var buttonD = document.getElementById("buttonD");
	button.addEventListener('click', buttonClick);
	buttonD.addEventListener('click', clickDelete);
	
	
	function buttonClick() {
		console.log(listTitle.value);
		console.log(comments.value);
		console.log(listId.value);
		listTitleV = listTitle.value;
		commentsV = comments.value;
		listIdV = listId.value;

	fetch(`/CodingChallenge2/JSON/grocery-list/updateList?listId=${listIdV}&listTitle=${listTitleV}&comments=${commentsV}`)
	.then((response) => response.json())
		.then(function(data) {
			console.log(data);
			if(data) {
				response.innerHTML = "Update successful";
			} else {
				resonse.innerHTML = "Update not successful";
			}
		}); 
	}
	
	function clickDelete() {
		console.log(listId.value);
		listIdV = listId.value;

		fetch(`/CodingChallenge2/JSON/grocery-list/deleteList?listId=${listIdV}`)
		.then((response) => response.json())
			.then(function(data) {
				console.log(data);
				if(data) {
					response.innerHTML = "Delete successful";
				} else {
					resonse.innerHTML = "Delete not successful";
				}
			}); 
		
	}
}