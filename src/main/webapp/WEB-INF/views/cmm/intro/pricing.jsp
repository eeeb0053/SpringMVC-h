<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!-- Container (Pricing Section) -->
<div id="pricing" class="container-fluid">
  <div class="text-center">
    <h2>사용자 등록</h2>
    <h4>Choose a payment plan that works for you</h4>
  </div>
  <div class="row slideanim">
    <div class="col-sm-4 col-xs-12">
      <div class="panel panel-default text-center">
        <div class="panel-heading">
          <h1>학 생</h1>
        </div>

        <div class="panel-footer">
          <button id="stu-join-btn" class="btn btn-lg">Sign Up</button>
          <button id="stu-login-btn" class="btn btn-lg">Sign In</button>
        </div>
      </div>      
    </div>     
    <div class="col-sm-4 col-xs-12">
      <div class="panel panel-default text-center">
        <div class="panel-heading">
          <h1>교강사</h1>
        </div>

        <div class="panel-footer">
          <button id="tea-join-btn" class="btn btn-lg">Sign Up</button>
          <button id="tea-login-btn" class="btn btn-lg">Sign In</button>
        </div>
      </div>      
    </div>       
    <div class="col-sm-4 col-xs-12">
      <div class="panel panel-default text-center">
        <div class="panel-heading">
          <h1>관리자</h1>
        </div>

        <div class="panel-footer">
          <button id="mgr-join-btn" class="btn btn-lg">Sign Up</button>
          <button id="mgr-login-btn" class="btn btn-lg">Sign In</button>
        </div>
      </div>      
    </div>    
  </div>
</div>
<script>
$(`#mgr-login-btn`).click(function(){
	location.href = `${ctx}/admin/mgr/access`
})
$(`#tea-login-btn`).click(function(){
	location.href = `${ctx}/admin/tea/access`
})
</script>
