<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Reponse di tipo Model And View : 
<pre>
* modelAndView.addObject("test", "messagio di prova"):
  messagioTest[${test}]
* modelAndView.addObject("miModelo",miModelo):
  ip[${miModelo.ip}] 
  lang[${miModelo.lang}] 
  tipoChiamta[${miModelo.tipoChiamata}]
* ErrorDTO
  codice[${errorDTO.codice}]
  descrizione[${errorDTO.descrizione}] 
* Request
  Ip Locale : ${requestDetailsDTO.ipAddressLocale}
  Ip Remote : ${requestDetailsDTO.ipAddressRemote};	
  Method : ${requestDetailsDTO.method};
  Uri : ${requestDetailsDTO.requestUri}
  Content Type : ${requestDetailsDTO.contentType};
  Params Query : ${requestDetailsDTO.paramsQuery};
  Tempo Esecuzione : ${requestDetailsDTO.executeTimeDTO.executeTime}  
  
</pre>

</body>
</html>