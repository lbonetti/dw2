-- Banco de Dados: clientes
--
DROP DATABASE IF EXISTS clientes;
CREATE DATABASE IF NOT EXISTS clientes;
USE clientes;
-- ---------------------------------
-- Estrutura da tabela cliente
CREATE TABLE IF NOT EXISTS cliente (
	cpf varchar(11) NOT NULL,
	nome varchar(50) NOT NULL,
	PRIMARY KEY (cpf)
) DEFAULT CHARSET=latin1;

-- Extraindo dados da tabela cliente
INSERT INTO cliente (cpf, nome) VALUES
('12345678901', 'João'),
('23456789012', 'Maria');
