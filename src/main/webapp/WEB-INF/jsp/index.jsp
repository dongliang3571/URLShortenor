<html lang="en">
<head>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>

<body>
	<table>
			<tr>
				<th colspan="2">Add URL</th>
			</tr>
			<tr>
			<td><label path="url">URL:</label></td>
			<td><input id="urlInput" size="70"></input></td>
			</tr>
			<tr>
				<td colspan="2"><input id="submit" type="submit" class="blue-button" /></td>
			</tr>
	</table>

	</hr>

	<p id="urlP">Your encoded url will be shown here.</p>

<script>
	$("#submit").click(function() {
		$.ajax({
			url: "/addUrl",
			dataType: 'json',
			type: 'POST',
			contentType: 'application/json',
			data: JSON.stringify({ url: $("#urlInput").val()}),
			success: onSuccess,
			error: onFailure
		});
	});

	function onSuccess(data) {
		console.log(data);

		var url = null;
		if (data.data === null) {
			url = "error code: " + data.errors.errorCode + " | error message: " + data.errors.errorMessage;
		} else {
			url = data.data.hostname + data.data.endpoint;
		}

		$("#urlP").html(url);
	}

	function onFailure(data) {
		console.log(data);
		$("#urlP").html("Errors!");
	}
</script>
</body>
</html>