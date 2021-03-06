PGDMP         4                x            Ewig    13.1    13.1 5    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    16441    Ewig    DATABASE     f   CREATE DATABASE "Ewig" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Portuguese_Brazil.1252';
    DROP DATABASE "Ewig";
                postgres    false            �            1255    16553 +   diferença_de_lançamento(integer, integer)    FUNCTION     �   CREATE FUNCTION public."diferença_de_lançamento"(integer, integer) RETURNS integer
    LANGUAGE sql
    AS $_$SELECT case
	when $1 > $2 then cast($1 - $2 as integer) 
	when $1 < $2 then cast($2 - $1 as integer)
end;$_$;
 D   DROP FUNCTION public."diferença_de_lançamento"(integer, integer);
       public          postgres    false            �            1255    16584    func_op_ob()    FUNCTION     �   CREATE FUNCTION public.func_op_ob() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
BEGIN
INSERT INTO  Operacoes_Obra (data, usuario, modificacao)           
                        VALUES (now(), user, TG_OP);
RETURN NEW;
END;
$$;
 #   DROP FUNCTION public.func_op_ob();
       public          postgres    false            �            1259    16442    autor    TABLE     _  CREATE TABLE public.autor (
    id integer NOT NULL,
    nome character varying(50) NOT NULL,
    cpf character varying(11) NOT NULL,
    endereco character varying(100) NOT NULL,
    telefone character varying(11) NOT NULL,
    login character varying(20) NOT NULL,
    senha character varying(20) NOT NULL,
    permissaodeacesso boolean NOT NULL
);
    DROP TABLE public.autor;
       public         heap    postgres    false            �            1259    16445    autor_id_seq    SEQUENCE     �   CREATE SEQUENCE public.autor_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.autor_id_seq;
       public          postgres    false    200                        0    0    autor_id_seq    SEQUENCE OWNED BY     =   ALTER SEQUENCE public.autor_id_seq OWNED BY public.autor.id;
          public          postgres    false    201            �            1259    16447 	   avaliador    TABLE     c  CREATE TABLE public.avaliador (
    id integer NOT NULL,
    nome character varying(50) NOT NULL,
    cpf character varying(11) NOT NULL,
    endereco character varying(100) NOT NULL,
    telefone character varying(11) NOT NULL,
    login character varying(20) NOT NULL,
    senha character varying(20) NOT NULL,
    permissaodeacesso boolean NOT NULL
);
    DROP TABLE public.avaliador;
       public         heap    postgres    false            �            1259    16450    avaliador_id_seq    SEQUENCE     �   CREATE SEQUENCE public.avaliador_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.avaliador_id_seq;
       public          postgres    false    202                       0    0    avaliador_id_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public.avaliador_id_seq OWNED BY public.avaliador.id;
          public          postgres    false    203            �            1259    16534    buscar_autor    VIEW     ]   CREATE VIEW public.buscar_autor AS
 SELECT autor.nome,
    autor.login
   FROM public.autor;
    DROP VIEW public.buscar_autor;
       public          postgres    false    200    200            �            1259    16538    buscar_avaliador    VIEW     m   CREATE VIEW public.buscar_avaliador AS
 SELECT avaliador.nome,
    avaliador.login
   FROM public.avaliador;
 #   DROP VIEW public.buscar_avaliador;
       public          postgres    false    202    202            �            1259    16452    gerente    TABLE     a  CREATE TABLE public.gerente (
    id integer NOT NULL,
    nome character varying(50) NOT NULL,
    cpf character varying(11) NOT NULL,
    endereco character varying(100) NOT NULL,
    telefone character varying(11) NOT NULL,
    login character varying(20) NOT NULL,
    senha character varying(20) NOT NULL,
    permissaodeacesso boolean NOT NULL
);
    DROP TABLE public.gerente;
       public         heap    postgres    false            �            1259    16542    buscar_gerente    VIEW     e   CREATE VIEW public.buscar_gerente AS
 SELECT gerente.nome,
    gerente.login
   FROM public.gerente;
 !   DROP VIEW public.buscar_gerente;
       public          postgres    false    204    204            �            1259    16516    ex_autor    TABLE     :  CREATE TABLE public.ex_autor (
    id integer NOT NULL,
    nome character varying(50),
    cpf character varying(11),
    endereco character varying(100),
    telefone character varying(11),
    login character varying(20),
    senha character varying(20),
    permissaodeacesso boolean,
    datademissao date
);
    DROP TABLE public.ex_autor;
       public         heap    postgres    false            �            1259    16521    ex_avaliador    TABLE     >  CREATE TABLE public.ex_avaliador (
    id integer NOT NULL,
    nome character varying(50),
    cpf character varying(11),
    endereco character varying(100),
    telefone character varying(11),
    login character varying(20),
    senha character varying(20),
    permissaodeacesso boolean,
    datademissao date
);
     DROP TABLE public.ex_avaliador;
       public         heap    postgres    false            �            1259    16526 
   ex_gerente    TABLE     <  CREATE TABLE public.ex_gerente (
    id integer NOT NULL,
    nome character varying(50),
    cpf character varying(11),
    endereco character varying(100),
    telefone character varying(11),
    login character varying(20),
    senha character varying(20),
    permissaodeacesso boolean,
    datademissao date
);
    DROP TABLE public.ex_gerente;
       public         heap    postgres    false            �            1259    16455    gerente_id_seq    SEQUENCE     �   CREATE SEQUENCE public.gerente_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.gerente_id_seq;
       public          postgres    false    204                       0    0    gerente_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.gerente_id_seq OWNED BY public.gerente.id;
          public          postgres    false    205            �            1259    16505    obra    TABLE     �   CREATE TABLE public.obra (
    id bigint NOT NULL,
    titulo character varying(50),
    ano integer,
    genero character varying(40),
    status integer,
    dataavaliacao date,
    idautor bigint,
    idavaliador bigint
);
    DROP TABLE public.obra;
       public         heap    postgres    false            �            1259    16503    obra_id_seq    SEQUENCE     �   CREATE SEQUENCE public.obra_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 "   DROP SEQUENCE public.obra_id_seq;
       public          postgres    false    207                       0    0    obra_id_seq    SEQUENCE OWNED BY     ;   ALTER SEQUENCE public.obra_id_seq OWNED BY public.obra.id;
          public          postgres    false    206            �            1259    16581    operacoes_obra    TABLE        CREATE TABLE public.operacoes_obra (
    data date,
    usuario character varying(15),
    modificacao character varying(6)
);
 "   DROP TABLE public.operacoes_obra;
       public         heap    postgres    false            R           2604    16489    autor id    DEFAULT     d   ALTER TABLE ONLY public.autor ALTER COLUMN id SET DEFAULT nextval('public.autor_id_seq'::regclass);
 7   ALTER TABLE public.autor ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    201    200            S           2604    16490    avaliador id    DEFAULT     l   ALTER TABLE ONLY public.avaliador ALTER COLUMN id SET DEFAULT nextval('public.avaliador_id_seq'::regclass);
 ;   ALTER TABLE public.avaliador ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    203    202            T           2604    16491 
   gerente id    DEFAULT     h   ALTER TABLE ONLY public.gerente ALTER COLUMN id SET DEFAULT nextval('public.gerente_id_seq'::regclass);
 9   ALTER TABLE public.gerente ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    205    204            U           2604    16561    obra id    DEFAULT     b   ALTER TABLE ONLY public.obra ALTER COLUMN id SET DEFAULT nextval('public.obra_id_seq'::regclass);
 6   ALTER TABLE public.obra ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    207    206    207            �          0    16442    autor 
   TABLE DATA           c   COPY public.autor (id, nome, cpf, endereco, telefone, login, senha, permissaodeacesso) FROM stdin;
    public          postgres    false    200   �B       �          0    16447 	   avaliador 
   TABLE DATA           g   COPY public.avaliador (id, nome, cpf, endereco, telefone, login, senha, permissaodeacesso) FROM stdin;
    public          postgres    false    202   �C       �          0    16516    ex_autor 
   TABLE DATA           t   COPY public.ex_autor (id, nome, cpf, endereco, telefone, login, senha, permissaodeacesso, datademissao) FROM stdin;
    public          postgres    false    208   YD       �          0    16521    ex_avaliador 
   TABLE DATA           x   COPY public.ex_avaliador (id, nome, cpf, endereco, telefone, login, senha, permissaodeacesso, datademissao) FROM stdin;
    public          postgres    false    209   vD       �          0    16526 
   ex_gerente 
   TABLE DATA           v   COPY public.ex_gerente (id, nome, cpf, endereco, telefone, login, senha, permissaodeacesso, datademissao) FROM stdin;
    public          postgres    false    210   �D       �          0    16452    gerente 
   TABLE DATA           e   COPY public.gerente (id, nome, cpf, endereco, telefone, login, senha, permissaodeacesso) FROM stdin;
    public          postgres    false    204   �D       �          0    16505    obra 
   TABLE DATA           d   COPY public.obra (id, titulo, ano, genero, status, dataavaliacao, idautor, idavaliador) FROM stdin;
    public          postgres    false    207   /E       �          0    16581    operacoes_obra 
   TABLE DATA           D   COPY public.operacoes_obra (data, usuario, modificacao) FROM stdin;
    public          postgres    false    214   �E                  0    0    autor_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.autor_id_seq', 15, true);
          public          postgres    false    201                       0    0    avaliador_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.avaliador_id_seq', 14, true);
          public          postgres    false    203                       0    0    gerente_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.gerente_id_seq', 12, true);
          public          postgres    false    205                       0    0    obra_id_seq    SEQUENCE SET     9   SELECT pg_catalog.setval('public.obra_id_seq', 9, true);
          public          postgres    false    206            W           2606    16467    autor autor_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.autor
    ADD CONSTRAINT autor_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.autor DROP CONSTRAINT autor_pkey;
       public            postgres    false    200            Y           2606    16469    avaliador avaliador_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.avaliador
    ADD CONSTRAINT avaliador_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.avaliador DROP CONSTRAINT avaliador_pkey;
       public            postgres    false    202            _           2606    16520    ex_autor ex_autor_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.ex_autor
    ADD CONSTRAINT ex_autor_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.ex_autor DROP CONSTRAINT ex_autor_pkey;
       public            postgres    false    208            a           2606    16525    ex_avaliador ex_avaliador_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.ex_avaliador
    ADD CONSTRAINT ex_avaliador_pkey PRIMARY KEY (id);
 H   ALTER TABLE ONLY public.ex_avaliador DROP CONSTRAINT ex_avaliador_pkey;
       public            postgres    false    209            c           2606    16530    ex_gerente ex_gerente_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.ex_gerente
    ADD CONSTRAINT ex_gerente_pkey PRIMARY KEY (id);
 D   ALTER TABLE ONLY public.ex_gerente DROP CONSTRAINT ex_gerente_pkey;
       public            postgres    false    210            [           2606    16471    gerente gerente_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.gerente
    ADD CONSTRAINT gerente_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.gerente DROP CONSTRAINT gerente_pkey;
       public            postgres    false    204            ]           2606    16563    obra obra_pkey 
   CONSTRAINT     L   ALTER TABLE ONLY public.obra
    ADD CONSTRAINT obra_pkey PRIMARY KEY (id);
 8   ALTER TABLE ONLY public.obra DROP CONSTRAINT obra_pkey;
       public            postgres    false    207            �           2618    16531    autor regraexautor    RULE     #  CREATE RULE regraexautor AS
    ON DELETE TO public.autor DO  INSERT INTO public.ex_autor (id, nome, cpf, endereco, telefone, login, senha, permissaodeacesso, datademissao)
  VALUES (old.id, old.nome, old.cpf, old.endereco, old.telefone, old.login, old.senha, old.permissaodeacesso, now());
 (   DROP RULE regraexautor ON public.autor;
       public          postgres    false    200    200    200    200    200    200    200    200    200    208    208    208    208    208    208    208    208    208    200            �           2618    16532    avaliador regraexavaliador    RULE     /  CREATE RULE regraexavaliador AS
    ON DELETE TO public.avaliador DO  INSERT INTO public.ex_avaliador (id, nome, cpf, endereco, telefone, login, senha, permissaodeacesso, datademissao)
  VALUES (old.id, old.nome, old.cpf, old.endereco, old.telefone, old.login, old.senha, old.permissaodeacesso, now());
 0   DROP RULE regraexavaliador ON public.avaliador;
       public          postgres    false    202    202    202    202    202    202    202    202    202    209    209    209    209    209    209    209    209    209    202            �           2618    16533    gerente regraexgerente    RULE     )  CREATE RULE regraexgerente AS
    ON DELETE TO public.gerente DO  INSERT INTO public.ex_gerente (id, nome, cpf, endereco, telefone, login, senha, permissaodeacesso, datademissao)
  VALUES (old.id, old.nome, old.cpf, old.endereco, old.telefone, old.login, old.senha, old.permissaodeacesso, now());
 ,   DROP RULE regraexgerente ON public.gerente;
       public          postgres    false    204    210    204    204    204    204    204    204    204    204    204    210    210    210    210    210    210    210    210            e           2620    16585    obra operacoes_obra    TRIGGER     �   CREATE TRIGGER operacoes_obra AFTER INSERT OR DELETE OR UPDATE ON public.obra FOR EACH ROW EXECUTE FUNCTION public.func_op_ob();
 ,   DROP TRIGGER operacoes_obra ON public.obra;
       public          postgres    false    207    216            d           2606    16568    obra obra_idautor_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.obra
    ADD CONSTRAINT obra_idautor_fkey FOREIGN KEY (idautor) REFERENCES public.autor(id) ON DELETE CASCADE;
 @   ALTER TABLE ONLY public.obra DROP CONSTRAINT obra_idautor_fkey;
       public          postgres    false    207    2903    200            �   �   x�E��j!@ϳ_�(eF�Y=��BI��k/���(��B��u�M��E����ǖbV���F�{ms*�1x�X&8��X����K� �� !��Sm����M؍��0Lz�Q�@;���9��SS ��YG/z�hKǸ�~���z�m/��?V��rő����S���������i���.ǆ���vw�>`Y�Cֹ�g����-A�3Lݜ��`��{�0J�����
~]�S�����a~ ��\�      �   �   x�Mαn!�z�
>��X`٥�\��]$m�3��;���Q,��73�q,��0S��ñ/K}g�OИE5G�kYA>��a���]�\pJ�ǧ{�>��_����P�k����Q�G��|���]{m��s��>�
嬢QY.mzVDJ��yK�$�;��oo%k�K�;��b��]�:s      �      x������ � �      �      x������ � �      �      x������ � �      �   o   x�-��!��
*0|���,`�zA�	
!k����siu0	}
ɉ`�d;f}���kP*5�Y��[���̣c�)�\T\ʜ�>�}�.=
f���z2�|�"�      �   �   x�M�M
�0FדS���A�,����n�t(&Ѥ��q�Az1��r�o^�qr�e08�V(;��؉zy�����I�J���FC�0�&^p3�d�p��S��.�Ɇ4^�ޣ��ek�'�!k*�+k�������,�.V}���wlٸ"q�N��A6o      �   2   x�3202�54�54�,�/.I/J-���v
�2�"�������� ��1     