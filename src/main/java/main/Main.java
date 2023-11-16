/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import controller.ProjectController;
import controller.TaskController;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Project;
import model.Task;
import util.ConnectionFactory;

/**
 *
 * @author ASUS
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here        
        //Connection c = ConnectionFactory.getConnection();        
        //ConnectionFactory.closeConnection(c);
        
        ProjectController projectController = new ProjectController();
        
         Project project = new Project();
         project.setName("Projeto teste");
         project.setDescription("description");
         projectController.save(project);
         
         //Project project = new Project();
         //project.setId(1);
         //project.setName("Novo nome do Pojeto");
         //project.setDescription("description");
         //projectController.update(project);
         
         //List<Project> projects = projectController.getAll();
         //System.out.println("Total de projetos = " + projects.size());
         
         //projectController.removeById(1);
         
         //TaskController taskcontroller = new TaskController();
         
         //Task task = new Task();
         //task.setIdProject(1);
         //task.setName("Criar telas da aplicação");
         //task.setDescription("Devem ser criadas telas para os cadastros");
         //task.setNotes("Sem Notas");
         //task.setCompleted(false);
         //task.setDeadline(new Date());
         
         //taskController.save(task);
         
         //task.setName("Alterar telas da aplicação");
         //taskController.update(task);
         //List<Task> tasks = taskController.getAll(1);
         //System.out.println("Total de tarefas = " + tasks.size());
    }   
}
