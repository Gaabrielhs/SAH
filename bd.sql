CREATE TABLE cliente(
	idCliente SERIAL NOT NULL,
	idQuarto INTEGER,
	Nome VARCHAR(45) NOT NULL,
	RG VARCHAR(13) NOT NULL,
	CPF VARCHAR(14) NOT NULL,
	Endereco VARCHAR(60) NOT NULL,
	Telefone VARCHAR(14) NOT NULL,
	Email VARCHAR(60) NOT NULL,
	dataNasc TIMESTAMP NOT NULL,
	PRIMARY KEY(idCliente)
);

CREATE TABLE TIPO(
	idTipo SERIAL NOT NULL,
	camas INTEGER NOT NULL,
	nome VARCHAR(30) NOT NULL,
	r INTEGER NOT NULL,
	g INTEGER NOT NULL,
	b INTEGER NOT NULL,
	qntquartos INTEGER NOT NULL,
	preco DECIMAL(10,2) NOT NULL,
	arcondicionado BOOLEAN NOT NULL,
	tv BOOLEAN NOT NULL,
	telefone BOOLEAN NOT NULL,
	frigobar BOOLEAN NOT NULL,
	banheiro BOOLEAN NOT NULL,
	PRIMARY KEY(idTipo)
);

CREATE TABLE QUARTO(
	idQuarto SERIAL NOT NULL,
	idTipo INTEGER NOT NULL,
	situacao INTEGER NOT NULL,
	PRIMARY KEY(idQuarto)
);

CREATE TABLE PEDIDO(
	idPedido SERIAL NOT NULL,
	idQuarto INTEGER NOT NULL,
	data TIMESTAMP NOT NULL,
	valor DECIMAL(10,2) NOT NULL,
	PRIMARY KEY(idPedido)
);

CREATE TABLE PRODUTO(
	idProduto SERIAL NOT NULL,
	descricao VARCHAR(30) NOT NULL,
	quantidade INTEGER NOT NULL,
	preco DECIMAL(10,2),
	PRIMARY KEY(idProduto)
);

insert into produto(descricao, quantidade, preco)
values('Coca-cola 2l', 15, 5.50),
	('Batata-Frita', 20, 2);

CREATE TABLE ITEMPEDIDO(
	idItemPedido SERIAL NOT NULL,
	quantidade INTEGER NOT NULL,
	idPedido INTEGER NOT NULL,
	idProduto INTEGER NOT NULL,
	PRIMARY KEY(idItemPedido)
);

CREATE TABLE FUNCIONARIO(
	idFuncionario SERIAL NOT NULL,
	gerente BOOLEAN NOT NULL,
	nome VARCHAR(60) NOT NULL,
	login VARCHAR(30) NOT NULL UNIQUE,
	senha VARCHAR(30) NOT NULL,
	PRIMARY KEY(idFuncionario)
);

CREATE TABLE RESERVA(
	idReserva SERIAL,
	idQuarto INTEGER NOT NULL,
	dataEntrada TIMESTAMP NOT NULL,
	dataSaida TIMESTAMP NOT NULL,
	PRIMARY KEY(idReserva)
);

INSERT INTO FUNCIONARIO(gerente, nome, login , senha)
VALUES('true', 'administrador', 'adm', 'adm');

ALTER TABLE RESERVA
ADD CONSTRAINT fk_quarto_reserva
FOREIGN KEY(idQuarto)
REFERENCES Quarto(idQuarto);

ALTER TABLE QUARTO
	ADD CONSTRAINT fk_tipo_quarto
	FOREIGN KEY(idTipo)
	REFERENCES Tipo(idTipo);

ALTER TABLE CLIENTE
	ADD CONSTRAINT fk_quarto_cliente
	FOREIGN KEY(idQuarto)
	REFERENCES Quarto(idQuarto);

ALTER TABLE PEDIDO
	ADD CONSTRAINT fk_quarto_pedido
	FOREIGN KEY(idQuarto)
	REFERENCES Quarto(idQuarto);

ALTER TABLE ITEMPEDIDO
	ADD CONSTRAINT fk_produto_itempedido
	FOREIGN KEY(idProduto)
	REFERENCES Produto(idProduto);

ALTER TABLE ITEMPEDIDO
	ADD CONSTRAINT fk_pedido_itempedido
	FOREIGN KEY(idPedido)
	REFERENCES Pedido(idPedido);
