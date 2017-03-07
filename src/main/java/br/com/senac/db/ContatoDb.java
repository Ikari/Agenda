/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.db;

import br.com.senac.model.Contato;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author roger.roliveira
 */
public class ContatoDb extends BaseDb {
    
    public ContatoDb(ConnectionUtils connection) 
    {
        super(connection);
    }
    
    public void adicionarContato(Contato contato){
        
        PreparedStatement stt = null;
        
        try 
        {        
            String command = "insert into t_contato (nome, data_nascimento, numero_telefone, email) values(?,?,?,?)";

            stt = obterStatementRetornaId(command);
            
            stt.setString(1, contato.getNome());
            stt.setString(2, contato.getDataNascimento());
            stt.setString(3, contato.getNumeroTelefone());
            stt.setString(4, contato.getEmail());
            
            stt.execute();            
        }
        catch(java.sql.SQLException sqle)
        {
            sqle.printStackTrace();
        }        
        catch(Exception e)
        {
            e.printStackTrace();
        }        
        finally
        {
            try
            {
                if (stt != null && !stt.isClosed())
                    stt.close();
                
                fecharConexao();
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }        
    }
    
        public void atualizarContato(Contato contato){
        
        PreparedStatement stt = null;
            
        try 
        {        
            String command = "update t_contato set nome=?, data_nascimento=?, telefone=?, email=? where id=?";
            
            stt = obterStatementRetornaId(command);
            
            stt.setString(1, contato.getNome());
            stt.setString(2, contato.getDataNascimento());
            stt.setString(3, contato.getNumeroTelefone());
            stt.setString(4, contato.getEmail());
            stt.setInt(5, contato.getId());
            
            stt.execute();            
        }
        catch(java.sql.SQLException sqle)
        {
            sqle.printStackTrace();
        }        
        catch(Exception e)
        {
            e.printStackTrace();
        }                
        finally
        {
            try
            {
                if (stt != null && !stt.isClosed())
                    stt.close();
                
                fecharConexao();
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }        
    }
        
    public void excluirContato(Contato contato){
        
        PreparedStatement stt = null;
            
        try 
        {        
            String command = "delete from t_contato where id=?";
            
            stt = obterStatementRetornaId(command);
            
            stt.setInt(1, contato.getId());
            
            stt.execute();            
        }
        catch(java.sql.SQLException sqle)
        {
            sqle.printStackTrace();
        }        
        catch(Exception e)
        {
            e.printStackTrace();
        }              
        finally
        {
            try
            {
                if (stt != null && !stt.isClosed())
                    stt.close();
                
                fecharConexao();
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }          
    }        
    
    public List<Contato> obterContatos(){
        
        PreparedStatement stt = null;
        ResultSet result = null;
        
        try
        {                   
            String command = "select c.id, c.data_cadastro, c.nome, c.data_nascimento, c.numero_telefone, c.email from t_contato c order by c.nome";
                        
            result  = getList(command);
            
            ArrayList lista = new ArrayList<>();
            
            while(result.next()){                
                Contato c = new Contato(result.getInt("id"), new SimpleDateFormat("dd/MM/yyyy").format(result.getDate("data_cadastro")), result.getString("nome"), result.getString("data_nascimento"), result.getString("numero_telefone"), result.getString("email"));
                lista.add(c);
            }
            
            return lista;
        }
        catch(java.sql.SQLException sqlex)
        {
            sqlex.printStackTrace();
            
            System.out.println(sqlex.getMessage());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if (stt != null && !stt.isClosed())
                    stt.close();
                
                fecharConexao();
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
        
        return null;
    }
}
