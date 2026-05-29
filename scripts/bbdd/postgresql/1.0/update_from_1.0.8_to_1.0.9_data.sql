
-- ====================================================================================================
-- ====================================================================================================
-- == Gestio de Plugins: Poder gestionar Plugins de Login i de Signatura en Servidor des de Back #36 ==
-- ====================================================================================================
-- ====================================================================================================


INSERT INTO evi_plugin(pluginid, nom, descripcio, classe, tipus, propietats, actiu) VALUES (nextval('evi_plugin_seq'), 'Plugin de Login de LoginIB', 'Plugin de Login de LoginIB', 'org.fundaciobit.pluginsib.login.loginibswagger.PluginLoginLoginIBSwagger', 1, '# =========  PLUGIN DE LOGIN  LOGINIB
es.caib.evidenciesib.pluginsib.login.loginibswagger.metodos_auth=CLAVE_CERTIFICADO;CLAVE_MOVIL;CLAVE_PERMANENTE
es.caib.evidenciesib.pluginsib.login.loginibswagger.entidad=A04003003
es.caib.evidenciesib.pluginsib.login.loginibswagger.aplicacion=CLIENT_TEST
es.caib.evidenciesib.pluginsib.login.loginibswagger.aplicaciondescripcion=CARPETA
es.caib.evidenciesib.pluginsib.login.loginibswagger.nivel_qaa=2
es.caib.evidenciesib.pluginsib.login.loginibswagger.url=[=SP["es.caib.evidenciesib.pluginsib.login.loginibswagger.url"]]
es.caib.evidenciesib.pluginsib.login.loginibswagger.user=[=SP["es.caib.evidenciesib.pluginsib.login.loginibswagger.user"]]
es.caib.evidenciesib.pluginsib.login.loginibswagger.pass=[=SP["es.caib.evidenciesib.pluginsib.login.loginibswagger.pass"]]', true);



INSERT INTO evi_plugin(pluginid, nom, descripcio, classe, tipus, propietats, actiu) VALUES (nextval('evi_plugin_seq'), 'Plugin de Login Mock', 'Plugin de Login Mock', 'es.caib.evidenciesib.pluginsib.login.class=org.fundaciobit.pluginsib.login.mock.PluginLoginMock', 1, '# Exemple de Persona Física
es.caib.evidenciesib.pluginsib.login.mock.logininfo={"username":"pfuster","name":"Pep","surname1":"Fuster","surname2":"Gonella","administrationID":"30000056Y","authenticationMethod":"None","qaa":1,"identityProvider":"MOCK","business":false}


# Exemple Persona Jurídica 1
#es.caib.evidenciesib.pluginsib.login.mock.logininfo={"username":"","name":"MyBusiness","administrationID":"87654321Z","authenticationMethod":"None","qaa":1,"identityProvider":"MOCK","business":false,"representative":{"name":"Pep","surname1":"Gonella","surname2":"Fuster","administrationID":"30000056Y"}}', false);


INSERT INTO evi_plugin(pluginid, nom, descripcio, classe, tipus, propietats, actiu) VALUES (nextval('evi_plugin_seq'), 'Plugin firma en Servidor Cridant Ws de PortaFIB', 'Plugin firma en Servidor Cridant Ws de PortaFIB', 'es.caib.evidenciesib.logic.firmaviaapi.PluginFirmaEnServidorViaApiPortaFIB', 2, '# Propietats per les Firmes Utilitzant Api Firma Simple en Servidor de PortaFIB 
# https://HOST/portafib/common/rest/apifirmaenservidorsimple/v1/ 
es.caib.evidenciesib.apifirmaenservidor.url=[=SP["es.caib.evidenciesib.apifirmaenservidor.url"]]
es.caib.evidenciesib.apifirmaenservidor.username=[=SP["es.caib.evidenciesib.apifirmaenservidor.username"]]
es.caib.evidenciesib.apifirmaenservidor.password=[=SP["es.caib.evidenciesib.apifirmaenservidor.password"]]

es.caib.evidenciesib.apifirmaenservidor.profile=PROFILE_PADES
es.caib.evidenciesib.apifirmaenservidor.defaultaliascertificate=afirmades-firma', false);



INSERT INTO evi_plugin(pluginid, nom, descripcio, classe, tipus, propietats, actiu) VALUES (nextval('evi_plugin_seq'), 'Plugin firma en Servidor Cridant WS d''UtilitatsFirma', 'Plugin firma en Servidor Cridant WS d''UtilitatsFirma', 'es.caib.evidenciesib.logic.firmaviaapi.PluginFirmaEnServidorViaApiUtilitatsFirma', 2, '# Propietats per les Firmes Utilitzant Api V2 d''UtilitatsFirma
# https://HOST/utilitatsfirmaapi/interna
es.caib.evidenciesib.utilitatsfirma.url=[=SP["es.caib.evidenciesib.utilitatsfirma.url"]]
es.caib.evidenciesib.utilitatsfirma.username=[=SP["es.caib.evidenciesib.utilitatsfirma.username"]]
es.caib.evidenciesib.utilitatsfirma.password=[=SP["es.caib.evidenciesib.utilitatsfirma.password"]]

es.caib.evidenciesib.utilitatsfirma.profile=PROFILE_PADES
es.caib.evidenciesib.utilitatsfirma.defaultaliascertificate=afirmades-firma

# Indica si s´ha d´utilitzar segell de temps en la firma. Només farà cas a aquest valor si la
# Configuració de Firma d´UtilitstasFirma té definit en el camp "Politica de Segell de Temps"
# el valor "L´usuari elegirà si vol segellat de temps" (default si o default no)
# es.caib.evidenciesib.utilitatsfirma.usetimestamp=true

', true);


