/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */

import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;


public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    public void cadastrarProduto (ProdutosDTO p){
        String sql ="INSERT INTO produtos (nome , valor, status ) VALUES (?, ?, ?)";
        try(Connection conn = conectaDAO.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)){
            
            stmt.setString(1, p.getNome());
            stmt.setDouble(2, p.getValor());
            stmt.setString(3, p.getStatus());
        
            stmt.execute();
        }catch (Exception e){
         e.printStackTrace();
        }
        
    }

 
    
    
    public ArrayList<ProdutosDTO> listarProdutos(){
        ArrayList<ProdutosDTO> lista = new ArrayList<>();    
        String sql = "SELECT * FROM produtos";
        
        try(Connection conn = conectaDAO.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()){
            
            while (rs.next()){
                ProdutosDTO p = new ProdutosDTO();
                
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setValor(rs.getInt("valor"));
                p.setStatus(rs.getString("status"));
                
                lista.add(p);
            }
                
        }catch(Exception e){
    e.printStackTrace();
    }
    return lista;}
  
    
    
    
        
}

