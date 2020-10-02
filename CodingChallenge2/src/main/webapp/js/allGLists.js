window.onload = function() {
	var table = document.querySelector("#table");
	var button = document.getElementById("button");
	var individual = document.getElementById("individual");
	var header = document.getElementById("header");

	button.addEventListener('click', viewIndividual);
	
	fetch('/CodingChallenge2/JSON/grocery-list')
	.then((response) => response.json())
		.then(function(data) {
			console.log(data);
			for (var l of data) {
					table.innerHTML += `
					<tr>
				      <td>${l['listId']}</td>
				      <td>${l['listTitle']}</td>
				    </tr>	
					`;
			}
		}); 
}

function viewIndividual() {
	var value = individual.value;
	fetch('/CodingChallenge2/JSON/grocery-list/list?listId='+individual.value)
	.then((response) => response.json())
	.then(function(data) {
		console.log(data);
		header.innerHTML = data["listTitle"];
		table.innerHTML = `
			<thead>
			<tr>
				<th>Item Name</th>
				<th>Grocery Type</th>
				<th>Comments</th>
			</tr>
		  </thead>	
			`;
		for (var l of data["groceriesOnList"]) {
				table.innerHTML += `
				<tr>
			      <td>${l['itemName']}</td>
			      <td>${l['groceryType']}</td>
			      <td>${l['comments']}</td>
			    </tr>	
				`;
		}
	}); 
	button.style.visibility="hidden";
	individual.style.visibility="hidden";
}