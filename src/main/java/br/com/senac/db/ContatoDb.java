/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.db;

import br.com.senac.model.Contato;
import java.util.ArrayList;

/**
 *
 * @author roger.roliveira
 */
public class ContatoDb {
    public void AdicionarContato(Contato contato){
        String query = "insert into t_contato (id, nome, data_nascimento, telefone, email, data_cadastro) values(?,?,?,?,?)";
    }
    
    public ArrayList<Contato> obterContatos(){
        return new ArrayList<>();
    }
}
