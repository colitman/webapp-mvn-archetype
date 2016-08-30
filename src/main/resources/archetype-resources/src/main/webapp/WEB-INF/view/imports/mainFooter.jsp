#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<c:set var="app" value="${symbol_dollar}{pageContext.servletContext.contextPath}" />

<footer class="hd-main-footer navbar-fixed-bottom">
	<p class="text-center text-muted">
		[[app_name]] |
		<a href="https://ua.linkedin.com/in/dmytro-romenskyi-87035524">Dmytro Romenskyi</a> |
		HobbyDev | [[year]] |
		<a href="${symbol_dollar}{app}/swagger-ui.html">API Reference</a>
	</p>
</footer>