window.onload = function() {
	var itemName = document.getElementById("itemName");
	var comments = document.getElementById("comments");
	var groceryType = document.getElementById("groceryType");
	var listId = document.getElementById("listId");
	var response = document.getElementById("response");
	var button = document.getElementById("button");
	button.addEventListener('click', buttonClick);
	
	
	function buttonClick() {
		console.log(itemName.value);
		console.log(comments.value);
		console.log(groceryType.value);
		console.log(listId.value);
		itemNameV = itemName.value;
		commentsV = comments.value;
		groceryTypeV = groceryType.value;
		listIdV = listId.value;
	fetch(`/CodingChallenge2/JSON/grocery-list/createItem?itemName=${itemNameV}&groceryType=${groceryTypeV}&comments=${commentsV}&listId=${listIdV}`)
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