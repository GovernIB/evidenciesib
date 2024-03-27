
--  Afegir camp a la taula de BD d'Evidència que sigui la propietat del json "login.properties.sha256" #33 
ALTER TABLE evi_evidencia ADD COLUMN loginpropertiessha256 character varying(255);