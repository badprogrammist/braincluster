<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>${projectItem.title}</title>
	</head>
	<body>
		<h2>${projectItem.title}</h2>
		<g:if test="${isPossibleToJoin}">
			<g:link controller="project" action="join" id="${projectItem.id}">Присоединится</g:link>
		</g:if>
	</body>
</html>
