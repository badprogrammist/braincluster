<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Все проекты</title>
	</head>
	<body>
		<table class="table">
			<g:each in="${projects}" var="projectItem">
				<tr>
					<td>
						<g:link controller="project" action="view" id="${projectItem.id}">${projectItem.title}</g:link>
					</td>
					<td>
						${projectItem.status.title}
					</td>
				</tr>
			</g:each>
		</table>
		<g:link controller="project" action="create">Создать новый проект</g:link>
	</body>
</html>
