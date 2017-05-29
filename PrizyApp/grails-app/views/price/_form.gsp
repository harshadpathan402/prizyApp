<%@ page import="com.org.prizypricer.Price" %>
<%@ page import="com.org.prizypricer.Product" %>


<div class="fieldcontain ${hasErrors(bean: priceInstance, field: 'price', 'error')} required">
	<label for="price">
		<g:message code="price.price.label" default="Price" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="price" value="${fieldValue(bean: priceInstance, field: 'price')}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: priceInstance, field: 'storeName', 'error')} required">
	<label for="storeName">
		<g:message code="price.storeName.label" default="Store Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="storeName" maxlength="25" required="" value="${priceInstance?.storeName}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: priceInstance, field: 'note', 'error')} ">
	<label for="note">
		<g:message code="price.note.label" default="Note" />
		
	</label>
	<g:textArea name="note" cols="40" rows="5" maxlength="500" value="${priceInstance?.note}"/>

</div>

<div class="fieldcontain">
	<label for="barcode">
		<g:message code="productPrice.barcode.label" default="Barcode" />
	</label>
	<g:select id="barcode" name='barcode' value="${product?.barcode}" 
    noSelection="${['null':'Select Barcode...']}"
    from='${Product.list()}'
    optionKey="barcode" ></g:select>
</div>

