#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<c:set var="app" value="${symbol_dollar}{pageContext.servletContext.contextPath}" />

<script src="https://code.jquery.com/jquery-2.2.4.min.js"
		integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44="
		crossorigin="anonymous"></script>

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
		integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
		crossorigin="anonymous"></script>

<script src="https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.10.13/js/dataTables.bootstrap.min.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/randomcolor/0.4.4/randomColor.js"
		integrity="sha256-ZZPmD/jyjhl0iLBOrKiOgbMCVEoSC9px6yVIR4rm4Tc="
		crossorigin="anonymous"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.4.0/Chart.js"
		integrity="sha256-HptdWaetAoQSrTP9GZVVxKovdIq1C3MmKazLYQ7JnL4="
		crossorigin="anonymous"></script>

<script src="${symbol_dollar}{app}/res/datejs/date.js"></script>
<script src="${symbol_dollar}{app}/res/bignumber/bignumber.js"></script>

<script src="${symbol_dollar}{app}/res/app/js/alerts.js"></script>
<script src="${symbol_dollar}{app}/res/app/js/app.js"></script>
<script src="${symbol_dollar}{app}/res/app/js/core.js"></script>
<script src="${symbol_dollar}{app}/res/app/js/domain.js"></script>
<script src="${symbol_dollar}{app}/res/app/js/jQueryDomBuilder.js"></script>

<script src="${symbol_dollar}{app}/res/app/js/models/mainNav.js"></script>
<script src="${symbol_dollar}{app}/res/app/js/views/mainNav.js"></script>
<script src="${symbol_dollar}{app}/res/app/js/controllers/mainNav.js"></script>