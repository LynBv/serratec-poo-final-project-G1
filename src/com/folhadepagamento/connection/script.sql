creata database;

create table Pessoa
(
    id   SERIAL PRIMARY KEY,
    nome VARCHAR(100) not null,
    cpf  VARCHAR(11)  not null,
    Data date         not null
);

Create table Funcionario
(
    id             SERIAL primary KEY,
    profissao      VARCHAR(50)  not null,
    nome           VARCHAR(100) not null,
    cpf            VARCHAR(11)  not null,
    dataNascimento Date,
    salarioBruto   VARCHAR(10),
    DescontoInss   VARCHAR(10),
    DescontoIR     VARCHAR(10),
    SalarioLiquido VARCHAR(10)  NOT null
);

INSERT INTO Funcionario (id, profissao, nome, cpf, dataNascimento, salarioBruto, DescontoInss, DescontoIR,
                         SalarioLiquido)
VALUES (1, 'Advogada', 'Ana Paula Ferreira', '13044678501', '1985-03-12', 8500.00, 0, 0, 0),
       (2, 'Engenheiro', 'Bruno Henrique Almeida', '29486719027', '1984-07-21', 6700.00, 0, 0, 0),
       (3, 'Zeladora', 'Camila Silva Oliveira', '34567890123', '1991-09-05', 4500.00, 0, 0, 0),
       (4, 'Faxineiro', 'Diego Martins Pereira', '45675817934', '1988-11-14', 1500.00, 0, 0, 0),
       (5, 'CEO', 'Eliane Souza Lima', '67810126532', '1981-04-30', 9000.00, 0, 0, 0),
       (6, 'CFO', 'Gabriela Costa Nunes', '78901234536', '1995-02-22', 3200.48, 0, 0, 0),
       (7, 'Analista de Banco de Dados', 'Felipe Gomes Rocha', '67890123456', '1987-04-28', 6000.23, 0, 0, 0),
       (8, 'Herdeiro', 'Henrique Barbosa Teixeira', '89010745677', '1983-12-17', 5600.56, 0, 0, 0),
       (9, 'Brilha Muito No Corinthians', 'Ronaldo Ribeiro Dominguez', '12234567890', '1991-06-09', 4500.00, 0, 0, 0),
       (10, 'Desenvolvedora Back End', 'Isabela Mendes Cardoso', '23133948299', '1993-08-19', 1412.00, 0, 0, 0);

CREATE TABLE dependente
(
    id              SERIAL PRIMARY KEY,
    funcionario_id  INT,
    nome            VARCHAR(100),
    cpf             VARCHAR(11),
    data_nascimento DATE,
    parentesco      VARCHAR(50),
    FOREIGN KEY (funcionario_id) REFERENCES funcionario (id)
);


INSERT INTO dependente (funcionario_id, nome, cpf, data_nascimento, parentesco)
VALUES (1, 'Luis Gustavo Ferreira', '54165428931', '2008-09-06', 'FILHO'),
       (1, 'Laura Ferreira dos Santos', '77500565715', '2007-07-11', 'OUTROS');


INSERT INTO dependente (funcionario_id, nome, cpf, data_nascimento, parentesco)
VALUES (2, 'Gerson Almeida da Silva', '44106865979', '2011-04-05', 'SOBRINHO');


INSERT INTO dependente (funcionario_id, nome, cpf, data_nascimento, parentesco)
VALUES (3, 'Oswaldo Silva Oliveira', '15748997800', '2013-12-31', 'OUTROS'),
       (3, 'Andrea Silva Oliveira dos Santos', '81886555224', '2011-08-13', 'FILHO'),
       (3, 'Marina Reis', '21665329826', '2009-09-29', 'OUTROS');


INSERT INTO dependente (funcionario_id, nome, cpf, data_nascimento, parentesco)
VALUES (7, 'Livia Coelho Pereira', '90126548862', '2010-03-02', 'OUTROS');


INSERT INTO dependente (funcionario_id, nome, cpf, data_nascimento, parentesco)
VALUES (9, 'Jeferson Fernandes Freitas', '17972856740', '2008-06-10', 'OUTROS'),
       (9, 'Calvin Sousa Freitas', '95489685967', '2011-10-22', 'FILHO');


INSERT INTO dependente (funcionario_id, nome, cpf, data_nascimento, parentesco)
VALUES (12, 'Giulia Costa Nunes', '14515749374', '2013-08-26', 'OUTROS'),
       (12, 'Rita Figueiredo Paquelet', '14429564102', '2010-07-07', 'OUTROS'),
       (12, 'Huna Leib Haratz', '44106865979', '1940-08-26', 'OUTROS');


INSERT INTO dependente (funcionario_id, nome, cpf, data_nascimento, parentesco)
VALUES (16, 'Suely De Farias Rocha', '66199574812', '2010-10-30', 'OUTROS');


INSERT INTO dependente (funcionario_id, nome, cpf, data_nascimento, parentesco)
VALUES (18, 'William Breves Teixeira', '14322634585', '2012-10-30', 'OUTROS'),
       (18, 'Odete Breves Teixeira Rezende', '63686847208', '2013-10-30', 'SOBRINHO');


INSERT INTO dependente (funcionario_id, nome, cpf, data_nascimento, parentesco)
VALUES (21, 'Pedro Ribeiro Dominguez', '42071964351', '2012-09-13', 'FILHO'),
       (21, 'Carolina Ribeiro Dominguez Ferreira', '19361152894', '2014-10-30', 'OUTROS'),
       (21, 'Reinaldo Ribeiro dos Santos', '34456284931', '2015-10-30', 'OUTROS');


INSERT INTO dependente (funcionario_id, nome, cpf, data_nascimento, parentesco)
VALUES (25, 'Mirian Medeiros Quadros', '11426649843', '1976-10-05', 'OUTROS'),
       (25, 'Mariana Mendes Cardoso', '98745927373', '1989-06-28', 'OUTROS');
