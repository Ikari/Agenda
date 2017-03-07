/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  roger
 * Created: 07/03/2017
 */

--DROP TABLE T_CONTATO;

CREATE TABLE T_CONTATO
(
    ID INTEGER PRIMARY KEY AUTO_INCREMENT,
    DATA_CADASTRO TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    NOME VARCHAR(60) NOT NULL,
    DATA_NASCIMENTO VARCHAR(10) NOT NULL,
    NUMERO_TELEFONE VARCHAR(9) NOT NULL,
    EMAIL VARCHAR(60) NOT NULL
);