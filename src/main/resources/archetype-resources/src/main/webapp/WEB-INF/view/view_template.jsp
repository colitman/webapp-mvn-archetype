#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<c:set var="app" value="${symbol_dollar}{pageContext.servletContext.contextPath}" />

<!DOCTYPE html>
<html lang="en">
	<head>
		<c:import url="/imports/head?pageTitle=[[title]]"></c:import>
	</head>
	
	<body data-page="[[page_id]]">
		<div class="container">
			<c:import url="/imports/mainNav?root=[[is_root]]"></c:import>
			
			<main>
				
			</main>
			
			<c:import url="/imports/mainFooter"></c:import>
		</div>

		<div class="hd-modals"></div>

		<c:import url="/imports/scripts"></c:import>

	</body>
</html>