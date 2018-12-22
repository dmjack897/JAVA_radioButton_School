<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	//リクエストから入力データを受け取る
    	String nm = (String)request.getAttribute("nm");
    	//エラー番号を受け取る
    	int intErr = (Integer)request.getAttribute("Err");
    	String strGender="";
    	//エラー毎にメッセージを設定
    	if(intErr==0||intErr==-1)
    	{
    		//ラジオボタンの値を取得
    		strGender = request.getParameter("gender");
    		if(strGender.equals("m"))
    		{
    			strGender="<span class=\"male\">男性</span>";
    		}
    		else
    		{
    			strGender="<span class=\"female\">女性</span>";
    		}
    	}
    	else
    	{
    		//ラジオボタン未設定
    		strGender="<span class=\"err\">性別が選択されていませんよ！</span>";
    	}
    	if(intErr==0)
    	{
    		nm="<span class=\"nm\">"+nm+"</span>";
    		//ラジオボタンの値を取得
    	}
    	else if(intErr == -1 || intErr ==3)
    	{
    		nm="<span class=\"err\">名前が入力されていませんよ！</span>";
    	}
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>自己紹介</title>
<style type="text/css">
	.err{
		color:red;
	
	}
	.nm{
			color:blue;
		}
	.male{
		color:navi;
	}
	.female{
		color:pink;
	}
</style>
</head>
<body>
	<h1>自己紹介</h1>
	<h2>あなたのお名前 :<%= nm %></h2>
	<h2>あなたの性別 : <%= strGender %></h2>
</body>
</html>