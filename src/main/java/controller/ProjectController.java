
package controller;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Project;
import util.ConnectionFactory;

public class ProjectController {
    
    public void save (Project project){
        String sql = "INSERT INTO projects (name, "
                + "description,"
                + "createdAt, "
                + "updatedAt) "
                + "VALUES (?, ?, ?, ?,)";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = ConnectionFactory.getConnection();
            //Cria um PreparedStatement, classe usada para executar a que 
            statement = connection.prepareStatement(sql);
            
            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setDate(3, new Date(project.getCreatedAt().getTime()));
            statement.setDate(4, new Date(project.getUpdatedAt().getTime()));
            
            //Executa SQL para inserção dos dados
            statement.execute();
            
        } catch (Exception ex){
            throw new RuntimeException("Erro ao salva a tarefa " 
                    + ex.getMessage(), ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
    }
    
        public void update (Project project){
        String sql = "UPDATE projects SET"                
                + "name = ?,"
                + "description = ?,"
                + "createdAt = ?,"
                + "updatedAt = ?,"
                + "WHERE id = ?";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            // Estabelecendo a conexão com o BD
            connection = ConnectionFactory.getConnection();
            //Cria um PreparedStatement, classe usada para preparar a query
            statement = connection.prepareStatement(sql);
            
            //Setando os valores do Statement
            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setDate(3, new Date(project.getCreatedAt().getTime()));
            statement.setDate(4, new Date(project.getUpdatedAt().getTime()));
            statement.setInt(5,project.getId());
            
            //Executando a query para inserção de dados
            statement.execute();
        } catch (SQLException ex){
            throw new RuntimeException("Erro ao atualizar a tarefa " 
                    + ex.getMessage(), ex);
        }
    }
            
    public List<Project> getAll(){
        String sql = "SELECT * FROM projects";
        
        //Lista de tarefas que será devolvida quando 
        // a chamada do método acontecer
        List <Project> projects = new ArrayList<>();
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        //Classe que vai recuperar os dados do BD
        ResultSet resultSet = null;
        
        try{
            //Criação de conexão
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
                  
            // Valor retornando pela eecução da query
            resultSet = statement.executeQuery();
            
            // Enquanto existir dados no BD, faça
            while(resultSet.next()){
                Project project = new Project();
                
                project.setId(resultSet.getInt("id"));
                project.setName(resultSet.getString("name"));
                project.setDescription(resultSet.getString("description"));
                project.setCreatedAt(resultSet.getDate("createdAt"));
                project.setUpdatedAt(resultSet.getDate("updatedAt"));
                
                projects.add(project);
            }
        } catch (SQLException ex){
            throw new RuntimeException("Erro ao buscar os projetos", ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement, resultSet);
        }
                
        // Lista de tarefas que foi criada e carregada do BD.      
        return projects;        
    }
    public void removeById(int idProject) {
        String sql = "DELETE FROM projects WHERE id = ?";
        
        Connection connection = null;
        
        PreparedStatement statement = null;
        
        try {
            // Criação da conexão com o BD
            connection = ConnectionFactory.getConnection();
            //Preparando a query
            statement = connection.prepareStatement(sql);
            
            //Setando os valores 
            statement.setInt(1, idProject);
            
            //Executando a query
            statement.execute();
        
        } catch (SQLException ex ) {
            throw new RuntimeException("Erro ao deletar o projeto", ex);        
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
    }    
}
    
