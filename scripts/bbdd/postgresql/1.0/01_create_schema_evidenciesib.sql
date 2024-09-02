--
-- PostgreSQL database dump
--

-- Dumped from database version 9.3.25
-- Dumped by pg_dump version 9.3.25
-- Started on 2023-09-01 13:41:23

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 1 (class 3079 OID 11750)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2006 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


--
-- TOC entry 178 (class 1259 OID 114480)
-- Name: evi_evidencia_seq; Type: SEQUENCE; Schema: public; Owner: evidenciesib
--

CREATE SEQUENCE public.evi_evidencia_seq
    START WITH 1000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.evi_evidencia_seq OWNER TO evidenciesib;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 177 (class 1259 OID 114477)
-- Name: evi_evidencia; Type: TABLE; Schema: public; Owner: evidenciesib; Tablespace: 
--

CREATE TABLE public.evi_evidencia (
    evidenciaid bigint DEFAULT nextval('public.evi_evidencia_seq'::regclass) NOT NULL,
    nom character varying(255) NOT NULL,
    personanom character varying(255),
    personallinatge1 character varying(255),
    personallinatge2 character varying(255),
    personanif character varying(100) NOT NULL,
    fitxeroriginalid bigint NOT NULL,
    datainici timestamp without time zone NOT NULL,
    datafi timestamp without time zone,
    usuariaplicacio character varying(255),
    usuaripersona character varying(100),
    estatcodi integer NOT NULL,
    estaterror character varying(255),
    estatexcepcio text,
    personamobil character varying(100),
    logintype integer DEFAULT 0 NOT NULL,
    loginid character varying(255),
    logindata timestamp without time zone,
    localitzacioip character varying(100),
    localitzaciocodipostal character varying(100),
    personaemail character varying(255),
    localitzaciolongitud character varying(100),
    localitzaciolatitud character varying(100),
    localitzaciociutat character varying(255),
    localitzacioregio character varying(100),
    localitzaciopais character varying(100),
    firmareason character varying(255) DEFAULT 'Rao de la firma'::character varying NOT NULL,
    fitxeradaptatid bigint,
    fitxersignatid bigint,
    firmatipusdocumental integer DEFAULT 99 NOT NULL,
    firmaidiomadocument character varying(100),
    loginsubtype character varying(255),
    loginqaa character varying(255),
    loginauthmethod character varying(255),
    loginadditionalproperties text,
    callbackurl character varying(255) DEFAULT '/user/evidencia/list'::character varying NOT NULL,
    personausername character varying(255)
);


ALTER TABLE public.evi_evidencia OWNER TO evidenciesib;

--
-- TOC entry 171 (class 1259 OID 114429)
-- Name: evi_fitxer_seq; Type: SEQUENCE; Schema: public; Owner: evidenciesib
--

CREATE SEQUENCE public.evi_fitxer_seq
    START WITH 1000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.evi_fitxer_seq OWNER TO evidenciesib;

--
-- TOC entry 173 (class 1259 OID 114433)
-- Name: evi_fitxer; Type: TABLE; Schema: public; Owner: evidenciesib; Tablespace: 
--

CREATE TABLE public.evi_fitxer (
    fitxerid bigint DEFAULT nextval('public.evi_fitxer_seq'::regclass) NOT NULL,
    descripcio character varying(1000) DEFAULT NULL::character varying,
    mime character varying(255) NOT NULL,
    nom character varying(255) NOT NULL,
    tamany bigint NOT NULL
);


ALTER TABLE public.evi_fitxer OWNER TO evidenciesib;

--
-- TOC entry 174 (class 1259 OID 114441)
-- Name: evi_idioma; Type: TABLE; Schema: public; Owner: evidenciesib; Tablespace: 
--

CREATE TABLE public.evi_idioma (
    idiomaid character varying(5) NOT NULL,
    nom character varying(50) NOT NULL,
    suportat boolean DEFAULT true NOT NULL,
    ordre integer DEFAULT 0 NOT NULL
);


ALTER TABLE public.evi_idioma OWNER TO evidenciesib;

--
-- TOC entry 179 (class 1259 OID 114487)
-- Name: evi_plugin_seq; Type: SEQUENCE; Schema: public; Owner: evidenciesib
--

CREATE SEQUENCE public.evi_plugin_seq
    START WITH 1000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.evi_plugin_seq OWNER TO evidenciesib;

--
-- TOC entry 180 (class 1259 OID 114489)
-- Name: evi_plugin; Type: TABLE; Schema: public; Owner: evidenciesib; Tablespace: 
--

CREATE TABLE public.evi_plugin (
    pluginid bigint DEFAULT nextval('public.evi_plugin_seq'::regclass) NOT NULL,
    nom character varying(255) NOT NULL,
    descripcio character varying(255) NOT NULL,
    classe character varying(255) NOT NULL,
    tipus integer NOT NULL,
    propietats text,
    actiu boolean DEFAULT true NOT NULL
);


ALTER TABLE public.evi_plugin OWNER TO evidenciesib;

--
-- TOC entry 172 (class 1259 OID 114431)
-- Name: evi_traduccio_seq; Type: SEQUENCE; Schema: public; Owner: evidenciesib
--

CREATE SEQUENCE public.evi_traduccio_seq
    START WITH 1000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.evi_traduccio_seq OWNER TO evidenciesib;

--
-- TOC entry 175 (class 1259 OID 114446)
-- Name: evi_traduccio; Type: TABLE; Schema: public; Owner: evidenciesib; Tablespace: 
--

CREATE TABLE public.evi_traduccio (
    traduccioid bigint DEFAULT nextval('public.evi_traduccio_seq'::regclass) NOT NULL
);


ALTER TABLE public.evi_traduccio OWNER TO evidenciesib;

--
-- TOC entry 176 (class 1259 OID 114450)
-- Name: evi_traducciomap; Type: TABLE; Schema: public; Owner: evidenciesib; Tablespace: 
--

CREATE TABLE public.evi_traducciomap (
    traducciomapid bigint NOT NULL,
    idiomaid character varying(10) NOT NULL,
    valor character varying(4000)
);


ALTER TABLE public.evi_traducciomap OWNER TO evidenciesib;

--
-- TOC entry 1882 (class 2606 OID 114500)
-- Name: evi_evidencia_pk; Type: CONSTRAINT; Schema: public; Owner: evidenciesib; Tablespace: 
--

ALTER TABLE ONLY public.evi_evidencia
    ADD CONSTRAINT evi_evidencia_pk PRIMARY KEY (evidenciaid);


--
-- TOC entry 1866 (class 2606 OID 114457)
-- Name: evi_fitxer_pk; Type: CONSTRAINT; Schema: public; Owner: evidenciesib; Tablespace: 
--

ALTER TABLE ONLY public.evi_fitxer
    ADD CONSTRAINT evi_fitxer_pk PRIMARY KEY (fitxerid);


--
-- TOC entry 1869 (class 2606 OID 114459)
-- Name: evi_idioma_pk; Type: CONSTRAINT; Schema: public; Owner: evidenciesib; Tablespace: 
--

ALTER TABLE ONLY public.evi_idioma
    ADD CONSTRAINT evi_idioma_pk PRIMARY KEY (idiomaid);


--
-- TOC entry 1885 (class 2606 OID 114498)
-- Name: evi_plugin_pk; Type: CONSTRAINT; Schema: public; Owner: evidenciesib; Tablespace: 
--

ALTER TABLE ONLY public.evi_plugin
    ADD CONSTRAINT evi_plugin_pk PRIMARY KEY (pluginid);


--
-- TOC entry 1872 (class 2606 OID 114461)
-- Name: evi_traduccio_pk; Type: CONSTRAINT; Schema: public; Owner: evidenciesib; Tablespace: 
--

ALTER TABLE ONLY public.evi_traduccio
    ADD CONSTRAINT evi_traduccio_pk PRIMARY KEY (traduccioid);


--
-- TOC entry 1877 (class 2606 OID 114463)
-- Name: evi_traducmap_pk; Type: CONSTRAINT; Schema: public; Owner: evidenciesib; Tablespace: 
--

ALTER TABLE ONLY public.evi_traducciomap
    ADD CONSTRAINT evi_traducmap_pk PRIMARY KEY (traducciomapid, idiomaid);


--
-- TOC entry 1878 (class 1259 OID 114553)
-- Name: evi_evidencia_fitxeradap_fk_i; Type: INDEX; Schema: public; Owner: evidenciesib; Tablespace: 
--

CREATE INDEX evi_evidencia_fitxeradap_fk_i ON public.evi_evidencia USING btree (fitxeradaptatid);


--
-- TOC entry 1879 (class 1259 OID 114552)
-- Name: evi_evidencia_fitxerorig_fk_i; Type: INDEX; Schema: public; Owner: evidenciesib; Tablespace: 
--

CREATE INDEX evi_evidencia_fitxerorig_fk_i ON public.evi_evidencia USING btree (fitxeroriginalid);


--
-- TOC entry 1880 (class 1259 OID 114555)
-- Name: evi_evidencia_fitxersign_fk_i; Type: INDEX; Schema: public; Owner: evidenciesib; Tablespace: 
--

CREATE INDEX evi_evidencia_fitxersign_fk_i ON public.evi_evidencia USING btree (fitxersignatid);


--
-- TOC entry 1883 (class 1259 OID 114501)
-- Name: evi_evidencia_pk_i; Type: INDEX; Schema: public; Owner: evidenciesib; Tablespace: 
--

CREATE INDEX evi_evidencia_pk_i ON public.evi_evidencia USING btree (evidenciaid);


--
-- TOC entry 1867 (class 1259 OID 114464)
-- Name: evi_fitxer_pk_i; Type: INDEX; Schema: public; Owner: evidenciesib; Tablespace: 
--

CREATE INDEX evi_fitxer_pk_i ON public.evi_fitxer USING btree (fitxerid);


--
-- TOC entry 1870 (class 1259 OID 114465)
-- Name: evi_idioma_pk_i; Type: INDEX; Schema: public; Owner: evidenciesib; Tablespace: 
--

CREATE INDEX evi_idioma_pk_i ON public.evi_idioma USING btree (idiomaid);


--
-- TOC entry 1886 (class 1259 OID 114502)
-- Name: evi_plugin_pk_i; Type: INDEX; Schema: public; Owner: evidenciesib; Tablespace: 
--

CREATE INDEX evi_plugin_pk_i ON public.evi_plugin USING btree (pluginid);


--
-- TOC entry 1873 (class 1259 OID 114466)
-- Name: evi_traduccio_pk_i; Type: INDEX; Schema: public; Owner: evidenciesib; Tablespace: 
--

CREATE INDEX evi_traduccio_pk_i ON public.evi_traduccio USING btree (traduccioid);


--
-- TOC entry 1874 (class 1259 OID 114467)
-- Name: evi_traducciomap_idiomaid_fk_i; Type: INDEX; Schema: public; Owner: evidenciesib; Tablespace: 
--

CREATE INDEX evi_traducciomap_idiomaid_fk_i ON public.evi_traducciomap USING btree (idiomaid);


--
-- TOC entry 1875 (class 1259 OID 114468)
-- Name: evi_traducciomap_pk_i; Type: INDEX; Schema: public; Owner: evidenciesib; Tablespace: 
--

CREATE INDEX evi_traducciomap_pk_i ON public.evi_traducciomap USING btree (traducciomapid);


--
-- TOC entry 1889 (class 2606 OID 114535)
-- Name: evi_evidencia_fitxer_fitada_fk; Type: FK CONSTRAINT; Schema: public; Owner: evidenciesib
--

ALTER TABLE ONLY public.evi_evidencia
    ADD CONSTRAINT evi_evidencia_fitxer_fitada_fk FOREIGN KEY (fitxeradaptatid) REFERENCES public.evi_fitxer(fitxerid);


--
-- TOC entry 1888 (class 2606 OID 114508)
-- Name: evi_evidencia_fitxer_fitdoc_fk; Type: FK CONSTRAINT; Schema: public; Owner: evidenciesib
--

ALTER TABLE ONLY public.evi_evidencia
    ADD CONSTRAINT evi_evidencia_fitxer_fitdoc_fk FOREIGN KEY (fitxeroriginalid) REFERENCES public.evi_fitxer(fitxerid);


--
-- TOC entry 1890 (class 2606 OID 114545)
-- Name: evi_evidencia_fitxer_fitsig_fk; Type: FK CONSTRAINT; Schema: public; Owner: evidenciesib
--

ALTER TABLE ONLY public.evi_evidencia
    ADD CONSTRAINT evi_evidencia_fitxer_fitsig_fk FOREIGN KEY (fitxersignatid) REFERENCES public.evi_fitxer(fitxerid);


--
-- TOC entry 1887 (class 2606 OID 114469)
-- Name: evi_traducmap_traduccio_fk; Type: FK CONSTRAINT; Schema: public; Owner: evidenciesib
--

ALTER TABLE ONLY public.evi_traducciomap
    ADD CONSTRAINT evi_traducmap_traduccio_fk FOREIGN KEY (traducciomapid) REFERENCES public.evi_traduccio(traduccioid);


--
-- TOC entry 2005 (class 0 OID 0)
-- Dependencies: 7
-- Name: SCHEMA public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2023-09-01 13:41:23

--
-- PostgreSQL database dump complete
--

