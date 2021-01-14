<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<section id="data-mgt">
    <table class="my-tab" id="mgr-tab">
    	<tr>
    		<th style="width: 30%">통계 자료</th><th id="result-form">성적 리스트</th>
    	</tr>
    	<tr>
			<td>
			<table>
			<tr>
    			<td>모든 점수의 합</td>
    			<td> 점</td>
    		</tr>
    		<tr>
    			<td>최고 점수</td>
    			<td>점</td>
    		</tr>
    		<tr>
    			<td>최하 점수</td>
    			<td>점</td>
    		</tr>
    		<tr>
    			<td>점수별 내림차순 정렬</td>
    			<td></td>
    		</tr>
    		<tr>
    			<td>이름별 오름차순 정렬</td>
    			<td></td>
    		</tr>
    		<tr>
    			<td>중복없이 수강과목 나열</td>
    			<td></td>
    		</tr>
    		<tr>
    			<td>ㅇㅇㅇ이 시험을 보았는가?</td>
    			<td></td>
    		</tr>
    		</table>
			</td>
    		<td>
    			<div id="mgr-data-mgt-stu"></div>
    		</td>
    	</tr>
    </table>
    
</section>
<script src="${mgr}/js/mgr.js"></script>
<script src="${stu}/js/stu.js"></script>
<script>
tea.grade_mgmt({ctx: `${ctx}`,
	pageSize: `10`,
	pageNum: `1`,
	subNum: `4`,
	examDate: `2020-11-30`})
</script>