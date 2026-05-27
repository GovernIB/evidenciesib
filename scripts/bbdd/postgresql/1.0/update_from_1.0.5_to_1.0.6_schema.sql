
--  Mantenir Idioma entre pantalla Selecció de Mòdul de firma i Evidències IB #77
ALTER TABLE evi_evidencia ADD COLUMN languageui character varying(50) DEFAULT 'ca' NOT NULL;