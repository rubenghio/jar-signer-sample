jar-signer-sample
=================

Proyecto de ejemplo para firmar y validar los jars

Requisitos

	JAVA 1.6 (o superior)
	MAVEN 2 (o superior)

Compilación y prueba de funcionamiento

	mvn clean install -DFIRMADOR_KEYSTORE=${KEYSTORE_LOCATION_FILE} -DFIRMADOR_ALIAS=${CERT_ALIAS} -DFIRMADOR_STOREPASS=${KEYSTORE_PASSWORD} -DFIRMADOR_KEYPASS=${CERT_PASSWORD}
