
 -- INICI PKs
    alter table evi_evidencia add constraint evi_evidencia_pk primary key (evidenciaid);

    alter table evi_fitxer add constraint evi_fitxer_pk primary key (fitxerid);

    alter table evi_idioma add constraint evi_idioma_pk primary key (idiomaid);

    alter table evi_plugin add constraint evi_plugin_pk primary key (pluginid);

    alter table evi_traduccio add constraint evi_traduccio_pk primary key (traduccioid);

    alter table evi_traducciomap add constraint evi_traducmap_pk primary key (traducciomapid, idiomaid);

 -- FINAL PKs


 -- INICI FKs

    alter table evi_evidencia 
       add constraint evi_evidencia_fitxer_fitada_fk 
       foreign key (fitxeradaptatid) 
       references evi_fitxer;

    alter table evi_evidencia 
       add constraint evi_evidencia_fitxer_fitdoc_fk 
       foreign key (fitxeroriginalid) 
       references evi_fitxer;

    alter table evi_evidencia 
       add constraint evi_evidencia_fitxer_fitsig_fk 
       foreign key (fitxersignatid) 
       references evi_fitxer;

    alter table evi_traducciomap 
       add constraint evi_traducmap_traduccio_fk 
       foreign key (traducciomapid) 
       references evi_traduccio;
 -- FINAL FKs

