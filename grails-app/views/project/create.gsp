<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Новый проект</title>
	</head>
	<body>
		<g:form controller="project" action="save">
			<label for="title">Название</label>
			<g:textField id="title" name="title"/>
			<label for="description">Описание</label>
			<g:textArea id="description" name="description"/>
			<g:submitButton name="save" value="Создать"/>
		</g:form>
	</body>
</html>
