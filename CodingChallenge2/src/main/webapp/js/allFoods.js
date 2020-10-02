window.onload = function() {
	var table = document.querySelector("#table");
	fetch('/CodingChallenge2/JSON/getAllFoods')
	.then((response) => response.json())
		.then(function(data) {
			console.log(data);
			for (var f of data) {
					table.innerHTML += `
					<tr>
				      <th scope="row">${f["dishName"]}</th>
				      <td>${f["calories"]}</td>
				    </tr>	
					`;
			}
		}); 
}