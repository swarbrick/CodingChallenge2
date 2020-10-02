window.onload = function() {
	var itemName = document.getElementById("itemName");
	var comments = document.getElementById("comments");
	var groceryType = document.getElementById("groceryType");
	var itemId = document.getElementById("itemId");
	var response = document.getElementById("response");
	var button = document.getElementById("button");
	var buttonD = document.getElementById("buttonD");
	button.addEventListener('click', buttonClick);
	buttonD.addEventListener('click', clickDelete);
	
	function buttonClick() {
		console.log(itemName.value);
		console.log(comments.value);
		console.log(groceryType.value);
		console.log(itemId.value);
		itemNameV = itemName.value;
		commentsV = comments.value;
		groceryTypeV = groceryType.value;
		itemIdV = itemId.value;
	fetch(`/CodingChallenge2/JSON/grocery-list/updateItem?itemName=${itemNameV}&groceryType=${groceryTypeV}&comments=${commentsV}&itemId=${itemIdV}`)
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
		console.log(itemId.value);
		itemIdV = itemId.value;

		fetch(`/CodingChallenge2/JSON/grocery-list/deleteItem?itemId=${itemIdV}`)
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