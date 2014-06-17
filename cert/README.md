Comandos utilizados
===================

1.- Para generar keystore:
	$ keytool -genkeypair -keystore keystore.jks

2.- Para generar petición de certificado
	$ keytool -certreq -file Cert1.csr -keystore keystore.jks

3.- Para importar un certificado al keystore 
	$ keytool -importcert -keystore keystore.jks -alias twitter -file ~/twitter.com.pem 

	NOTA: Previamente debe exportar el certificado (Ej. Twitter) desde el navegador en formato PEM

4.- Para consultar el keystore
	$ keytool -list -keystore keystore.jks 

5.- Generar un certificado auto-firmado (lo almacena dentro del keystore)
	$ keytool -genkey -alias mycert -keyalg RSA -keystore keystore.jks

5.- Extraer certificados (exportar) del keystore 
	$ keytool -export -alias mycert -keystore keystore.jks -file mycert.cer

7.- Extraer certificados del keystore JKS e importar keystore PKCS12
	$ keytool -importkeystore -srckeystore keystore.jks -destkeystore keystore.p12 -srcstoretype JKS -deststoretype PKCS12 
