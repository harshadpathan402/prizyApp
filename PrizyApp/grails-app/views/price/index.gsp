
<%@ page import="com.org.prizypricer.Price" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'price.label', default: 'Price')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-price" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-price" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="price" title="${message(code: 'price.price.label', default: 'Price')}" />
					
						<g:sortableColumn property="storeName" title="${message(code: 'price.storeName.label', default: 'Store Name')}" />
					
						<g:sortableColumn property="note" title="${message(code: 'price.note.label', default: 'Note')}" />
					
						<th><g:message code="price.product.label" default="Product" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${priceInstanceList}" status="i" var="priceInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${priceInstance.id}">${fieldValue(bean: priceInstance, field: "price")}</g:link></td>
					
						<td>${fieldValue(bean: priceInstance, field: "storeName")}</td>
					
						<td>${fieldValue(bean: priceInstance, field: "note")}</td>
					
						<td>${fieldValue(bean: priceInstance, field: "product")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${priceInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
