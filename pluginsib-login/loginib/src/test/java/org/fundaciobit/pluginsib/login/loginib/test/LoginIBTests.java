package org.fundaciobit.pluginsib.login.loginib.test;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.fundaciobit.pluginsib.login.loginib.PluginLoginLoginIB;

import es.caib.loginib.rest.api.v1.REvidenciasAutenticacion;

/**
 * 
 * @author anadal
 *
 */
public class LoginIBTests {

    public static void main(String[] args) {

        try {

            final String propertyKeyBase = "es.caib.evidenciesib.";

            Properties properties = new Properties();

            properties.load(new FileInputStream(new File("test.properties")));

            PluginLoginLoginIB plugin = new PluginLoginLoginIB(propertyKeyBase, properties);

            String sessionID = properties.getProperty("sessionid");

            REvidenciasAutenticacion evis = plugin.getEvidencies(sessionID);

            System.out.println(evis.getHuellaElectronica());
            
            System.out.println(evis.getEvidencias());

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }

}
