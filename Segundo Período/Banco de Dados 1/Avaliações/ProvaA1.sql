-- Prova A1 (PRÁTICA)
use filmes;

-- Questão 1
select filme.titulo as Filme, categoria.nome as Categoria from filme, categoria where
filme.categoria_id = categoria.id;

-- Questão 2
select usuario.nome as Usuario, filme.titulo as Filmes from usuario, filme, visualizacao where
usuario.id = visualizacao.usuario_id and
visualizacao.filme_id = filme.id and filme.titulo = 'Superbad';

-- Questão 3
select distinct usuario.nome as Usuario, filme.titulo as Filmes, filme.ano_lancamento as Ano from usuario, filme, avaliacao where
usuario.id = avaliacao.usuario_id and
filme.id = avaliacao.filme_id and
usuario.nome = 'Alice';

-- Questão 4
select filme.titulo as Filme, categoria.nome as Categoria, filme.duracao as Duração from filme, categoria where
filme.categoria_id = categoria.id and
filme.duracao between 90 and 120;

-- Questão 5
select distinct usuario.nome as Usuario, categoria.nome as Categoria from filme, categoria, visualizacao, usuario where
filme.id = visualizacao.filme_id and
usuario.id = visualizacao.usuario_id and
categoria.id = filme.categoria_id
and categoria.nome = 'Comédia';

-- Questão 6
select filme.titulo as Filme, avaliacao.classificacao as Avaliação, filme.duracao as 'Duração' from filme, avaliacao where
filme.id = avaliacao.filme_id and
avaliacao.classificacao > 4 and
filme.duracao < 120;

-- Questão 7
select distinct categoria.nome as Categoria, avaliacao.classificacao as Classificação, filme.titulo as Filme from filme, categoria, avaliacao where
categoria.id = filme.categoria_id and
avaliacao.filme_id = filme.id and
categoria.nome = 'Ação';

-- Questão 8
select usuario.nome as Usuario, usuario.email as Email from usuario
where usuario.email like '%gmail.com';

-- Questão 9
select usuario.nome as Usuario, filme.titulo as Filmes from filme, usuario, visualizacao where
usuario.id = visualizacao.usuario_id and
filme.id = visualizacao.filme_id and
visualizacao.duracao_assistida < 30;

-- Questão 10
select usuario.nome as Usuario, filme.titulo as Filmes, format(((visualizacao.duracao_assistida / filme.duracao) * 100), 2) as 'Porcentagem Assistida' from filme, visualizacao, usuario where
usuario.id = visualizacao.usuario_id and
filme.id = visualizacao.filme_id;

-- Questão 11
insert into filme(titulo, sinopse, classificacao, ano_lancamento, diretor, elenco, categoria_id, duracao) values
('Os fanfarrões', 'Uma história totalmente interessante', 'PG-13', 2024, 'Junior Vargas', 'O melhor', 2, 90),
('Ben 10: Carnitrix (AU Story)', 'E se o Azmuth fosse uma pessoa ruim?', '18', 2023, 'Josh Cannibal', 'Ben Tennyson', 1, 120);

-- Questão 12
insert into visualizacao(usuario_id, filme_id, data_inicio, data_termino, duracao_assistida) values 
(1, 1, '2024-04-20', '2024-06-07', 90),
(2, 2, '2024-04-20', '2024-06-07', 25),
(2, 2, '2024-04-20', '2024-06-07', 120);

-- Questão 13
delete from visualizacao where visualizacao.id = 1;

-- Questão 14
update filme set filme.titulo = 'Hackeado pela ABIN' where filme.id = 1;

-- Questão 15
/*
Um filme pode ser deletado do banco de dados quando nenhum usuário o assistiu, ou quando a constrição da
FK sendo efeito cascata (se algo critico for modificado, o BD aplica um efeito borboleta para evitar erros),
além do mais importante, a regra de negócio deve permitir que essas alterações sejam feitas, tudo isso deve ser analisado 
pelo DBA para ver se a exclusão do filme nos registros é viavel sem afetar outras tabelas no banco de dados
*/


