

INSERT INTO evi_plugin(pluginid, nom, descripcio, classe, tipus, propietats, actiu) VALUES (1002, 'Plugin de Login Mock', 'Plugin de Login Mock', 'es.caib.evidenciesib.pluginsib.login.class=org.fundaciobit.pluginsib.login.mock.PluginLoginMock', 1, '# Exemple de Persona Física
es.caib.evidenciesib.pluginsib.login.mock.logininfo={"username":"pfuster","name":"Pep","surname1":"Fuster","surname2":"Gonella","administrationID":"30000056Y","authenticationMethod":"None","qaa":1,"identityProvider":"MOCK","business":false}


# Exemple Persona Jurídica 1
#es.caib.evidenciesib.pluginsib.login.mock.logininfo={"username":"","name":"MyBusiness","administrationID":"87654321Z","authenticationMethod":"None","qaa":1,"identityProvider":"MOCK","business":false,"representative":{"name":"Pep","surname1":"Gonella","surname2":"Fuster","administrationID":"30000056Y"}}', false);
INSERT INTO evi_plugin(pluginid, nom, descripcio, classe, tipus, propietats, actiu) VALUES (1001, 'Plugin de Login de LoginIB', 'Plugin de Login de LoginIB', 'org.fundaciobit.pluginsib.login.loginibswagger.PluginLoginLoginIBSwagger', 1, '# =========  PLUGIN DE LOGIN  LOGINIB
es.caib.evidenciesib.pluginsib.login.loginibswagger.metodos_auth=CLAVE_CERTIFICADO;CLAVE_MOVIL;CLAVE_PERMANENTE
es.caib.evidenciesib.pluginsib.login.loginibswagger.entidad=A04003003
es.caib.evidenciesib.pluginsib.login.loginibswagger.aplicacion=CLIENT_TEST
es.caib.evidenciesib.pluginsib.login.loginibswagger.aplicaciondescripcion=CARPETA
es.caib.evidenciesib.pluginsib.login.loginibswagger.nivel_qaa=2
es.caib.evidenciesib.pluginsib.login.loginibswagger.url=[=SP["es.caib.evidenciesib.pluginsib.login.loginibswagger.url"]]
es.caib.evidenciesib.pluginsib.login.loginibswagger.user=[=SP["es.caib.evidenciesib.pluginsib.login.loginibswagger.user"]]
es.caib.evidenciesib.pluginsib.login.loginibswagger.pass=[=SP["es.caib.evidenciesib.pluginsib.login.loginibswagger.pass"]]', true);


