package org.fundaciobit.pluginsib.login.api;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.fundaciobit.pluginsib.core.utils.AbstractPluginProperties;



/**
 * 
 * @author anadal
 *
 */
public abstract class AbstractPluginLogin extends AbstractPluginProperties implements IPluginLogin {
    
    protected final Logger log = Logger.getLogger(this.getClass());
    
    public AbstractPluginLogin() {
        super();
      }

      /**
       * @param propertyKeyBase
       */
      public AbstractPluginLogin(String propertyKeyBase) {
        super(propertyKeyBase);
      }

      /**
       * @param propertyKeyBase
       * @param properties
       */
      public AbstractPluginLogin(String propertyKeyBase, Properties properties) {
        super(propertyKeyBase, properties);
      }

}
