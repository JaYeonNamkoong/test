<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!-- 2023. 1. 17. / Kosmo -->
<article>
	<header>
		<h1>ȸ��ã��</h1>
	</header>
	<ul class="list-unstyled">
		<li class="border-top my-3"></li>
	</ul>

	<div id="container">
		<div id="row">
			<button id="listBtn">Click</button>
			<div class="row justify-content-center">
				<table class="table">
					<thead>
						<tr>
							<td>num</td>
							<td>ID</td>
							<td>Name</td>
							<td>Age</td>
							<td>Gender</td>
						</tr>
					</thead>
					<tbody id="target">

					</tbody>

				</table>
			</div>
		</div>
	</div>
</article>

<script>
	//ȸ�� ��ü�� ����ϴ� 
	//JQuery ����
	$(function() {
		//alert("Test");
		$('#listBtn').click(
				function() {
					$.ajaxSetup({ //ajax ĳ�� ����
						cache : false
					});
					$.ajax({
						url : "../memberlistView",
						success : function(jsonData) {
							$('#target').html(""); //����
							console.log(jsonData);
							//[{��}, {��}, {��}, {��}, {��}, {��}, {��}, {��}, {��}, {��}, {��}, {��}, {��}, {��}, {��}, {��}]
							//�迭���·� ����
							//
							
							$.each(jsonData, function(member,v) {
								//�迭�ȿ� {��} ��ü�ϳ�
								console.log(member);
								console.log(v);
								
								let tags = "<tr>"; //����ϳ� �� <tr~/tr>
								$.each(v, function(key, val) {
									//{}��ü�ȿ� ������ => num : 20
									console.log(key + " : " + val);
									
									//null�� ����
									if(val !== null)
									tags += "<td>" + val + "</td>";
								});
								tags += "</tr>";
								$('#target').append(tags);
							});
								
						}
					});
				});
	});
</script>
