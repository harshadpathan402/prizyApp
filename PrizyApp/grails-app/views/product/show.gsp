
<%@ page import="com.org.prizypricer.Product" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'product.label', default: 'Product')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-product" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-product" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list product">
			
				<g:if test="${productInstance?.barcode}">
				<li class="fieldcontain">
					<span id="barcode-label" class="property-label"><g:message code="product.barcode.label" default="Barcode" /></span>
					
						<span class="property-value" aria-labelledby="barcode-label"><g:fieldValue bean="${productInstance}" field="barcode"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${productInstance?.productName}">
				<li class="fieldcontain">
					<span id="productname-label" class="property-label"><g:message code="product.productname.label" default="Productname" /></span>
					
						<span class="property-value" aria-labelledby="productname-label"><g:fieldValue bean="${productInstance}" field="productName"/></span>
				</li>
				</g:if>
			
				<g:if test="${productInstance?.description}">
				<li class="fieldcontain">
					<span id="description-label" class="property-label"><g:message code="product.description.label" default="Description" /></span>
					
						<span class="property-value" aria-labelledby="description-label"><g:fieldValue bean="${productInstance}" field="description"/></span>
					
				</li>
				</g:if>
				<li class="fieldcontain">
					<span id="idealPrice-label" class="property-label" style="margin-left:100px"><b><g:message code="product.idealPrice.label" default="Ideal Price" /></b></span></td>
					<span class="property-value" aria-labelledby="description-label"><div id="idealPrice"></div></span>
				</li>
				
				<li class="fieldcontain" >
				<span style="text-align: right;" class="property-value" aria-labelledby="idealPrice-label"><g:formatNumber number="${price}" type="currency" currencyCode="USD"/></span>
				</li>
				<li class="fieldcontain">
				<g:formRemote  name="subForm" url="[controller:'product', action:'idealPrice']" update="idealPrice">
				 <span style="text-align: left;margin-left:250px" class="property-value" aria-labelledby="selectOption-label">
						<select name="formula">
							<option value="IDEAL_PRICE">Ideal Price</option>
							<option value="SIMPLE_PRICE">Simple Price</option>
							<option value="STANDERED_PRICE">Standard Price</option>
						</select>
					</span>
				<g:hiddenField name="id" value="${productInstance.barcode}"/></br><div style="text-align: left;margin-left:250px; size: 20px" ><g:submitButton class="buttons"  align="center" style="background-color: #abbf78; text-color:Red" name="Calculate" value="Calculate-Price" /></div>
			</g:formRemote>				
			</li> 
		</ol>
			<g:form url="[resource:productInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${productInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
