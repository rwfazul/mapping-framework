/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mongoDB;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import model.Evento;
import model.Palestra;
import model.Palestrante;
import model.Predio;
import model.Sala;
import model.dao.mongo.EventoDAOMongo;

/**
 *
 * @author rhau
 */
public class TesteEventoMongo {
    
    static EventoDAOMongo edao = new EventoDAOMongo();

    public static void main(String[] args) {        
        Sala s1 = new Sala();
        s1.setNome("354A");
        s1.setCapacidade(50);
        Predio p1 = new Predio("CT");
        s1.setPredio(p1);
 
        Sala s2 = new Sala();
        s2.setNome("361");
        s2.setCapacidade(30);
        Predio p2 = new Predio("CT - Anexo A");
        s2.setPredio(p2);
        
        Palestrante pal1 = new Palestrante("Paulo", 'M', "Mestrado", "Sistemas de Informação", "UFSM");
        Palestrante pal2 = new Palestrante("Joana", 'F', "Doutorado", "Ciência da Computação", "PUC");
        
        String data = "2016-09-21 13:43";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(data, formatter);
        
        Palestra pa1 = new Palestra();
        pa1.setTitulo("Surpresas do big data");
        pa1.setAssunto("big data");
        pa1.setDescricao("nessa palestra bla bla");
        pa1.setInicio(dateTime);
        pa1.setFim(dateTime);
        pa1.setPalestrante(pal1);
        pa1.setSala(s1);

        Palestra pa2 = new Palestra();
        pa2.setTitulo("Surpresas do machine learning");
        pa2.setAssunto("machine learning");
        pa2.setDescricao("esta atividade sera bla bla");
        pa2.setInicio(dateTime);
        pa2.setFim(dateTime);
        pa2.setPalestrante(pal2);
        pa2.setSala(s2);
        
        data = "25-01-2016";
        formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date = LocalDate.parse(data, formatter);
        
        Evento e1 = new Evento();
        e1.setNome("sainf");
        e1.setDescricao("inf");
        e1.setEndereco("rua bla bla");
        e1.setDataFim(date);
        e1.setDataInicio(date);
        e1.setPredio(p1);
        e1.getPalestras().add(pa1);
        
        Evento e2 = new Evento();
        e2.setNome("sact");
        e2.setDescricao("eng");
        e2.setEndereco("ufsm");
        e2.setDataFim(date);
        e2.setDataInicio(date);
        e2.setPredio(p2);
        e2.getPalestras().add(pa1);
        e2.getPalestras().add(pa2);
        
        testeInserir(e1);
        testeInserir(e2);
        System.out.println("*** OBJETOS QUE FORAM INSERIDOS ***");
        imprime_evento(e1);
        imprime_evento(e2);
        System.out.println("*** OBJETOS QUE FORAM RECUPERADOS ***");
        testeBuscarTodos();      
    }
    
    public static void testeInserir(Evento e) {
        System.out.println("Inserindo evento (" +  e + ")...");
        edao.inserir(e);
    }
    
    public static void testeAtualizar(Evento e) {
        System.out.println("Atualizando evento (" + e + ")...");
        edao.alterar(e);
    }
    
    public static void testeDeletar(Evento e) {
        System.out.println("Deletando evento (" + e + ")...");
        edao.excluir(e);
    }
    
    public static Evento testeBuscar(Evento e) {
        System.out.println("Buscando evento (" + e + ")...");
        Evento busca = null;
        for (Evento evento : edao.buscar(e)) {
            busca = evento;
            System.out.println("Encontrou! " + evento + "...");
            break;
        }
        return busca;
    }
    
    public static void testeBuscarTodos() {
        System.out.println("Buscando eventos...");
        for (Evento e : edao.buscarTodos())
            imprime_evento(e);
    }    

    private static void imprime_evento(Evento e) {
        System.out.println("_id: " + e.getIdString());
        System.out.println("nome: " + e.getNome());
        System.out.println("descricão: " + e.getDescricao());
        System.out.println("endereço: " + e.getEndereco());
        System.out.println("dataInicio: " + e.getDataInicio());
        System.out.println("dataFim: " + e.getDataFim());
        System.out.println("predio: { nome: " + e.getPredio().getNome() + " }");
        System.out.println("palestras: [");
        for (Palestra p : e.getPalestras()) {
            System.out.println("\t{ titulo: " + p.getTitulo());
            System.out.println("\t  assunto: " + p.getAssunto());
            System.out.println("\t  descricao: " + p.getDescricao());
            System.out.println("\t  inicio: " + p.getInicio());
            System.out.println("\t  fim: " + p.getFim());
            System.out.println("\t  palestrante: {");
            System.out.println("\t\tnome: " + p.getPalestrante().getNome());
            System.out.println("\t\tsexo: " + p.getPalestrante().getSexo());
            System.out.println("\t\tgrauAcadêmico: " + p.getPalestrante().getGrauAcademico());
            System.out.println("\t\tcursoFormação: " + p.getPalestrante().getCursoFormacao());
            System.out.println("\t\tinstituiçãoFormação: " + p.getPalestrante().getInstituicaoFormacao());
            System.out.println("\t\tsala: { nome: " + p.getSala().getNome());
            System.out.println("\t\tpredio: { nome: " + p.getSala().getPredio().getNome() + "} } } }");
        }
        System.out.println("]");
    }
    
}
