jar-signer-sample
=================

Proyecto de ejemplo para firmar y validar los jars

Desarrollado con MAVEN

Compilación y prueba de funcionamiento

mvn clean install -DFIRMADOR_KEYSTORE=${KEYSTORE_LOCATION_FILE} -DFIRMADOR_ALIAS=${CERT_ALIAS} -DFIRMADOR_STOREPASS=${KEYSTORE_PASSWORD} -DFIRMADOR_KEYPASS=${CERT_PASSWORD}
