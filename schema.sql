--
-- PostgreSQL database dump
--

-- Dumped from database version 13.5 (Ubuntu 13.5-0ubuntu0.21.10.1)
-- Dumped by pg_dump version 13.5 (Ubuntu 13.5-0ubuntu0.21.10.1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: animal; Type: TABLE; Schema: public; Owner: alan
--

CREATE TABLE public.animal (
    id integer NOT NULL,
    nombre text NOT NULL,
    especie text NOT NULL,
    familia text NOT NULL,
    orden text NOT NULL,
    clase text NOT NULL,
    habitat text NOT NULL,
    dieta text NOT NULL,
    gestacion text NOT NULL,
    crias text NOT NULL,
    vida text NOT NULL
);


ALTER TABLE public.animal OWNER TO alan;

--
-- Name: animal_id_seq; Type: SEQUENCE; Schema: public; Owner: alan
--

ALTER TABLE public.animal ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.animal_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: habitat; Type: TABLE; Schema: public; Owner: alan
--

CREATE TABLE public.habitat (
    id integer NOT NULL,
    habitat text NOT NULL,
    description text NOT NULL
);


ALTER TABLE public.habitat OWNER TO alan;

--
-- Name: habitat_id_seq; Type: SEQUENCE; Schema: public; Owner: alan
--

ALTER TABLE public.habitat ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.habitat_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Data for Name: animal; Type: TABLE DATA; Schema: public; Owner: alan
--

COPY public.animal (id, nombre, especie, familia, orden, clase, habitat, dieta, gestacion, crias, vida) FROM stdin;
\.


--
-- Data for Name: habitat; Type: TABLE DATA; Schema: public; Owner: alan
--

COPY public.habitat (id, habitat, description) FROM stdin;
\.


--
-- Name: animal_id_seq; Type: SEQUENCE SET; Schema: public; Owner: alan
--

SELECT pg_catalog.setval('public.animal_id_seq', 1, false);


--
-- Name: habitat_id_seq; Type: SEQUENCE SET; Schema: public; Owner: alan
--

SELECT pg_catalog.setval('public.habitat_id_seq', 1, false);


--
-- Name: animal animal_id; Type: CONSTRAINT; Schema: public; Owner: alan
--

ALTER TABLE ONLY public.animal
    ADD CONSTRAINT animal_id PRIMARY KEY (id);


--
-- Name: animal animal_name; Type: CONSTRAINT; Schema: public; Owner: alan
--

ALTER TABLE ONLY public.animal
    ADD CONSTRAINT animal_name UNIQUE (nombre);


--
-- Name: habitat habitat_habitat; Type: CONSTRAINT; Schema: public; Owner: alan
--

ALTER TABLE ONLY public.habitat
    ADD CONSTRAINT habitat_habitat UNIQUE (habitat);


--
-- Name: habitat habitat_id; Type: CONSTRAINT; Schema: public; Owner: alan
--

ALTER TABLE ONLY public.habitat
    ADD CONSTRAINT habitat_id PRIMARY KEY (id);


--
-- Name: animal animal_habitat_fkey; Type: FK CONSTRAINT; Schema: public; Owner: alan
--

ALTER TABLE ONLY public.animal
    ADD CONSTRAINT animal_habitat_fkey FOREIGN KEY (habitat) REFERENCES public.habitat(habitat);


--
-- PostgreSQL database dump complete
--