<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <hr/>
	<%
	try {
	    org.me.calculator.CalculatorWS_Service service = new org.me.calculator.CalculatorWS_Service();
	    org.me.calculator.CalculatorWS port = service.getCalculatorWSPort();
	     // TODO initialize WS operation arguments here
	    int i = 20;
	    int j = 10;
	    // TODO process result here
	    int result = port.add(i, j);
	    out.println("Result = "+result);
	} catch (Exception ex) {
	    // TODO handle custom exceptions here
	}
	%>
    <hr/>
    </body>
</html>
