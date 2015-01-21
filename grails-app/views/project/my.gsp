<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Мои проекты</title>
	</head>
	<body>
		<table class="table">
			<g:each in="${userProjects}" var="userProjectItem">
				<tr>
					<td>
						<g:link controller="project" action="view" id="${userProjectItem.project.id}">${userProjectItem.project.title}</g:link>
					</td>
					<td>
						${userProjectItem.project.status.title}
					</td>
					<td>
						${userProjectItem.role.title}
					</td>
				</tr>
			</g:each>
		</table>
		<g:link controller="project" action="create">Создать новый проект</g:link>
	</body>
</html>
