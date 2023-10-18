create table tb_cidades(
    id_cidade bigint not null primary key,
    nome varchar(50) not null,
    qtd_habitantes bigint
);

insert into tb_cidades
        (id_cidade, nome, qtd_habitantes)
values
    (1, 'São Paulo', 11451245),
    (2, 'Campinas', 2292654),
    (3, 'Corinthians', 999999),
    (4, 'Palmeiras', 00001),
    (5, 'Santos', 2),
    (6, 'Santo André', 1651115),
    (7, 'Indaiatuba', 65468);