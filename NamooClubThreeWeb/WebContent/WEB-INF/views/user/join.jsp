<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
 <meta name="viewport" content="width=device-width, initial-scale=1">
<title>ȸ������</title>
<link href="${ctx}/resources/css/bootstrap.css" rel="stylesheet">
<link href="${ctx}/resources/css/bootswatch.min.css" rel="stylesheet">
</head>
<body>

<!-- Main Navigation ========================================================================================== -->
<div class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-responsive-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="./index.html">����Ŀ�´�Ƽ</a>
        </div>
    </div>
</div>

<!-- Header ========================================================================================== -->
<header>
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="jumbotron">
                    <h1>���� Ŀ�´�Ƽ�� �Բ�!</h1>
                    <p>���� Ŀ�´�Ƽ�� �Բ� Ư�� ��̿� ���ɻ�, Ư�� �׷� �Ǵ� ������ ���� ��ȭ�� �����ϼ���.</p>
                </div>
            </div>
        </div>
    </div>
</header>

<!-- Container ======================================================================================= -->
<div class="container">
    <div class="row">
        <div class="col-lg-12">

            <div class="page-header">
                <h2 id="container">ȸ�� �����ϱ�</h2>
            </div>

            <div class="well">
                <p>ȸ�������� ���� �Ʒ� ������� �ۼ��� �ּ���.</p>
                <form method="post" class="form-horizontal" action="./user/join.do">
                    <fieldset>
                        <div class="form-group">
                            <label class="col-lg-2 control-label">�̸�</label>

                            <div class="col-lg-10">
                                <input type="text" class="form-control" name="joinName" placeholder="�̸�">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-2 control-label">�̸���</label>

                            <div class="col-lg-10">
                                <input type="text" class="form-control" name="joinEmail" placeholder="�̸���">
                                <span class="help-block">�Է��Ͻ� �̸����� ȸ��ID�� ���˴ϴ�.</span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-2 control-label">��й�ȣ</label>

                            <div class="col-lg-10">
                                <input type="password" class="form-control" name="joinPassword" placeholder="��й�ȣ">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-2 control-label">��й�ȣ Ȯ��</label>

                            <div class="col-lg-10">
                                <input type="password" class="form-control" placeholder="��й�ȣ Ȯ��">
                            </div>
                        </div>
                        
                        <div class="form-group">
                            <div class="col-lg-10 col-lg-offset-2">
                                <button type="submit" class="btn btn-primary">Ȯ��</button>
                                <button onclick="location.href='${ctx}/login.xhtml'; return false;" class="btn btn-default">���</button>
                            </div>
                        </div>
                    </fieldset>
                </form>
            </div>
        </div>
    </div>
    
<!-- Footer ========================================================================================== -->
 <footer> 
   <div class="row">
            <div class="col-lg-12">
                <ul class="list-unstyled">
                    <li class="pull-right"><a href="#top">���� �̵�</a></li>
    				 <li><a href="#">Ŀ�´�Ƽ Ȩ</a>
                    </li>
                    <li><a href="#">RSS</a></li>
                    <li><a href="#">�̿���</a></li>
                    <li><a href="#">����</a></li>
                    <li><a href="#">ȸ��Ż��</a></li>
                </ul>
                 </div>
        </div>
    </footer>
    </div>
 <script src="./js/jquery-2.1.0.js"></script>
<script src="./js/bootstrap.min.js"></script>
<script src="./js/bootswatch.js"></script>
    
</body>
</html>