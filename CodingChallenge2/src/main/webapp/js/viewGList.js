window.onload = function() {
	var tableBody = document.querySelector("#tableBody");
	var header = document.getElementById("header");
	fetch('/CodingChallenge2/JSON/grocery-list/list?listId=4')
	.then((response) => response.json())
		.then(function(data) {
			console.log(data["listTitle"])
			header.innerHTML=data["listTitle"];
			console.log(data["groceriesOnList"]);
			for (i of data["groceriesOnList"]) {
					tableBody.innerHTML += `
					<tr>
				      <td>${i["itemName"]}</th>
				      <td>${i["groceryType"]}</td>
			      	  <td>${i["comments"]}</td>
				    </tr>	
					`;}
		}); 
}