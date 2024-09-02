create sequence evi_evidencia_seq start with 1000 increment by  1;
create sequence evi_fitxer_seq start with 1000 increment by  1;
create sequence evi_plugin_seq start with 1000 increment by  1;
create sequence evi_traduccio_seq start with 1000 increment by  1;

    create table evi_evidencia (
       evidenciaid number(19,0) not null,
        callbackurl varchar2(255 char) default '/user/evidencia/list' not null,
        clickproperties varchar2(4000 char),
        datafi timestamp,
        datainici timestamp not null,
        deviceproperties varchar2(4000 char),
        estatcodi number(10,0) not null,
        estaterror varchar2(4000 char),
        estatexcepcio long,
        firmaidiomadocument varchar2(100 char),
        firmareason varchar2(255 char) default 'Rao de la firma' not null,
        firmatipusdocumental number(10,0) default 99 not null,
        fitxeradaptatid number(19,0),
        fitxeroriginalid number(19,0) not null,
        fitxersignatid number(19,0),
        localitzaciociutat varchar2(255 char),
        localitzaciocodipostal varchar2(100 char),
        localitzacioip varchar2(100 char),
        localitzaciolatitud varchar2(100 char),
        localitzaciolongitud varchar2(100 char),
        localitzaciopais varchar2(100 char),
        localitzacioregio varchar2(100 char),
        loginadditionalproperties long,
        loginauthmethod varchar2(255 char),
        logindata timestamp,
        loginid varchar2(255 char),
        loginpropertiessha256 varchar2(255 char) default 'NO_DEFINED',
        loginqaa varchar2(255 char),
        loginsubtype varchar2(255 char),
        logintype varchar2(255 char),
        nom varchar2(255 char) not null,
        personaemail varchar2(255 char),
        personallinatge1 varchar2(255 char),
        personallinatge2 varchar2(255 char),
        personamobil varchar2(100 char),
        personanif varchar2(100 char) not null,
        personanom varchar2(255 char),
        personausername varchar2(255 char),
        usuariaplicacio varchar2(255 char),
        usuaripersona varchar2(100 char),
        primary key (evidenciaid)
    );

    create table evi_fitxer (
       fitxerid number(19,0) not null,
        descripcio varchar2(1000 char),
        mime varchar2(255 char) not null,
        nom varchar2(255 char) not null,
        tamany number(19,0) not null,
        primary key (fitxerid)
    );

    create table evi_idioma (
       idiomaid varchar2(5 char) not null,
        nom varchar2(50 char) not null,
        ordre number(10,0) default 0 not null,
        suportat number(1,0) not null,
        primary key (idiomaid)
    );

    create table evi_plugin (
       pluginid number(19,0) not null,
        actiu number(1,0) not null,
        classe varchar2(255 char) not null,
        descripcio varchar2(255 char) not null,
        nom varchar2(255 char) not null,
        propietats long,
        tipus number(10,0) not null,
        primary key (pluginid)
    );

    create table evi_traduccio (
       traduccioid number(19,0) not null,
        primary key (traduccioid)
    );

    create table evi_traducciomap (
       traducciomapid number(19,0) not null,
        valor varchar2(4000 char),
        idiomaid varchar2(255 char) not null,
        primary key (traducciomapid, idiomaid)
    );
create index evi_evidencia_pk_i on evi_evidencia (evidenciaid);
create index evi_evidencia_fitxerorig_fk_i on evi_evidencia (fitxeroriginalid);
create index evi_evidencia_fitxeradap_fk_i on evi_evidencia (fitxeradaptatid);
create index evi_evidencia_fitxersign_fk_i on evi_evidencia (fitxersignatid);
create index evi_fitxer_pk_i on evi_fitxer (fitxerid);
create index evi_idioma_pk_i on evi_idioma (idiomaid);
create index evi_plugin_pk_i on evi_plugin (pluginid);
create index evi_traduccio_pk_i on evi_traduccio (traduccioid);

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
