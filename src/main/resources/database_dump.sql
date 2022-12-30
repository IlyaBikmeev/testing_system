--
-- PostgreSQL database dump
--

-- Dumped from database version 15.1
-- Dumped by pg_dump version 15.1

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
-- Name: answer; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.answer (
                               answer_id bigint NOT NULL,
                               name_answer text,
                               question_id bigint,
                               is_correct boolean
);


ALTER TABLE public.answer OWNER TO postgres;

--
-- Name: answer_answer_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.answer ALTER COLUMN answer_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.answer_answer_id_seq
START WITH 1
          INCREMENT BY 1
          NO MINVALUE
          NO MAXVALUE
          CACHE 1
          );


--
-- Name: attempt; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.attempt (
                                attempt_id bigint NOT NULL,
                                student_id bigint,
                                subject_id bigint,
                                date_attempt date,
                                result bigint
);


ALTER TABLE public.attempt OWNER TO postgres;

--
-- Name: attempt_attempt_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.attempt ALTER COLUMN attempt_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.attempt_attempt_id_seq
START WITH 1
          INCREMENT BY 1
          NO MINVALUE
          NO MAXVALUE
          CACHE 1
          );


--
-- Name: question; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.question (
                                 question_id bigint NOT NULL,
                                 name_question text,
                                 subject_id bigint
);


ALTER TABLE public.question OWNER TO postgres;

--
-- Name: question_question_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.question ALTER COLUMN question_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.question_question_id_seq
START WITH 1
          INCREMENT BY 1
          NO MINVALUE
          NO MAXVALUE
          CACHE 1
          );


--
-- Name: student; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.student (
                                student_id bigint NOT NULL,
                                name_student text
);


ALTER TABLE public.student OWNER TO postgres;

--
-- Name: student_student_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.student ALTER COLUMN student_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.student_student_id_seq
START WITH 1
          INCREMENT BY 1
          NO MINVALUE
          NO MAXVALUE
          CACHE 1
          );


--
-- Name: subject; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.subject (
                                subject_id bigint NOT NULL,
                                name_subject text
);


ALTER TABLE public.subject OWNER TO postgres;

--
-- Name: subject_subject_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.subject ALTER COLUMN subject_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.subject_subject_id_seq
START WITH 1
          INCREMENT BY 1
          NO MINVALUE
          NO MAXVALUE
          CACHE 1
          );


--
-- Name: testing; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.testing (
                                testing_id bigint NOT NULL,
                                attempt_id bigint,
                                question_id bigint,
                                answer_id bigint
);


ALTER TABLE public.testing OWNER TO postgres;

--
-- Name: testing_testing_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.testing ALTER COLUMN testing_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.testing_testing_id_seq
START WITH 1
          INCREMENT BY 1
          NO MINVALUE
          NO MAXVALUE
          CACHE 1
          );


--
-- Data for Name: answer; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.answer (answer_id, name_answer, question_id, is_correct) FROM stdin;
1	UPDATE	1	f
2	SELECT	1	t
3	INSERT	1	f
4	GROUP BY	2	f
5	FROM	2	f
6	WHERE	2	t
7	SELECT	2	f
8	SORT	3	f
9	ORDER BY	3	t
10	RANG BY	3	f
11	SELECT * FROM student	4	t
12	SELECT student	4	f
13	INNER JOIN	5	t
14	LEFT JOIN	5	f
15	RIGHT JOIN	5	f
16	CROSS JOIN	5	f
17	совокупность данных, организованных по определённым праилам	6	t
18	совокупность программ для хранения и обработки больших массивов информации	6	f
19	строка	7	f
20	столбец	7	f
21	таблица	7	t
22	обобщенное представление пользователей о данных	8	t
23	описание представления данных в памяти компьютера	8	f
24	база данных	8	f
25	file	9	t
26	INT	9	f
27	VARCHAR	9	f
28	DATE	9	f
\.


--
-- Data for Name: attempt; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.attempt (attempt_id, student_id, subject_id, date_attempt, result) FROM stdin;
1	1	2	2020-03-23	67
2	3	1	2020-03-23	100
3	4	2	2020-03-26	0
4	1	1	2020-04-15	33
5	3	1	2020-04-15	67
6	4	2	2020-04-21	100
7	3	1	2020-05-17	33
\.


--
-- Data for Name: question; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.question (question_id, name_question, subject_id) FROM stdin;
1	Запрос на выборку начинается с ключевого слова:	1
2	Условие, по которому отбираются записи, задаётся после ключевого слова:	1
3	Для сортировки используется:	1
4	Какой запрос выбирает все записи из таблицы student:	1
5	Для внутреннего соединения таблиц используется оператор:	1
6	База данных - это:	2
7	Отношение - это:	2
8	Концептуальная модель используется для	2
9	Какой тип данных не допустим в реляционной таблице?	2
\.


--
-- Data for Name: student; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.student (student_id, name_student) FROM stdin;
1	Баранов Павел
2	Абрамова Катя
3	Семенов Иван
4	Яковлева Галина
\.


--
-- Data for Name: subject; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.subject (subject_id, name_subject) FROM stdin;
1	Основы SQL
2	Основы баз данных
3	Физика
7	Математический анализ
\.


--
-- Data for Name: testing; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.testing (testing_id, attempt_id, question_id, answer_id) FROM stdin;
1	1	9	25
2	1	7	19
3	1	6	17
4	2	3	9
5	2	1	2
6	2	4	11
7	3	6	18
8	3	8	24
9	3	9	28
10	4	1	2
11	4	5	16
12	4	3	10
13	5	2	6
14	5	1	2
15	5	4	12
16	6	6	17
17	6	8	22
18	6	7	21
19	7	1	3
20	7	4	11
21	7	5	16
\.


--
-- Name: answer_answer_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.answer_answer_id_seq', 28, true);


--
-- Name: attempt_attempt_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.attempt_attempt_id_seq', 7, true);


--
-- Name: question_question_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.question_question_id_seq', 12, true);


--
-- Name: student_student_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.student_student_id_seq', 4, true);


--
-- Name: subject_subject_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.subject_subject_id_seq', 7, true);


--
-- Name: testing_testing_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.testing_testing_id_seq', 21, true);


--
-- Name: answer answer_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.answer
    ADD CONSTRAINT answer_pkey PRIMARY KEY (answer_id);


--
-- Name: attempt attempt_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.attempt
    ADD CONSTRAINT attempt_pkey PRIMARY KEY (attempt_id);


--
-- Name: question question_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.question
    ADD CONSTRAINT question_pkey PRIMARY KEY (question_id);


--
-- Name: student student_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.student
    ADD CONSTRAINT student_pkey PRIMARY KEY (student_id);


--
-- Name: subject subject_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.subject
    ADD CONSTRAINT subject_pkey PRIMARY KEY (subject_id);


--
-- Name: testing testing_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.testing
    ADD CONSTRAINT testing_pkey PRIMARY KEY (testing_id);


--
-- Name: answer FK_answer_question; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.answer
    ADD CONSTRAINT "FK_answer_question" FOREIGN KEY (question_id) REFERENCES public.question(question_id) ON DELETE CASCADE;


--
-- Name: attempt FK_attempt_student; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.attempt
    ADD CONSTRAINT "FK_attempt_student" FOREIGN KEY (student_id) REFERENCES public.student(student_id) ON DELETE CASCADE;


--
-- Name: attempt FK_attempt_subject; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.attempt
    ADD CONSTRAINT "FK_attempt_subject" FOREIGN KEY (subject_id) REFERENCES public.subject(subject_id) ON DELETE CASCADE;


--
-- Name: question FK_question_subject; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.question
    ADD CONSTRAINT "FK_question_subject" FOREIGN KEY (subject_id) REFERENCES public.subject(subject_id) ON DELETE CASCADE;


--
-- Name: testing FK_testing_answer; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.testing
    ADD CONSTRAINT "FK_testing_answer" FOREIGN KEY (answer_id) REFERENCES public.answer(answer_id) ON DELETE CASCADE;


--
-- Name: testing FK_testing_attempt; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.testing
    ADD CONSTRAINT "FK_testing_attempt" FOREIGN KEY (attempt_id) REFERENCES public.attempt(attempt_id) ON DELETE CASCADE;


--
-- Name: testing FK_testing_question; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.testing
    ADD CONSTRAINT "FK_testing_question" FOREIGN KEY (question_id) REFERENCES public.question(question_id) ON DELETE CASCADE;


--
-- PostgreSQL database dump complete
--

