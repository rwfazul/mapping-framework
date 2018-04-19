/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysql;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Evento;
import model.Palestra;
import model.Palestrante;
import model.Predio;
import model.Sala;
import model.dao.relacional.mysql.EventoDAOMySQL;
import util.DateUtils;

/**
 *
 * @author rhau
 */
public class TesteEventoMySQL {
 
    static EventoDAOMySQL edao = new EventoDAOMySQL();

    
    public static void main(String[] args) {
        Evento e = cria_evento();
        testeInserir(e);
        // System.out.println("*** OBJETOS QUE FORAM INSERIDOS ***");
        // imprime_evento(e);
        // System.out.println("*** OBJETOS QUE FORAM RECUPERADOS ***");
        testeBuscarTodos();    
        
        e.getPredio().setNome("NOVO PREDIO");
        Palestra p = e.getPalestras().iterator().next();
        p.setTitulo("NOVO TITULO");
        p.getSala().setNome("NOVA SALA");
        testeAtualizar(e);
        testeBuscarTodos();
        testeDeletar(e);
        testeBuscarTodos();
    }
    
    public static void testeInserir(Evento e) {
        System.out.println("Inserindo evento (" +  e + ")...");
        edao.inserir(e);
    }
    
    public static void testeAtualizar(Evento e) {
        System.out.println("Atualizando evento id=" + e.getId() + "...");
        edao.alterar(e);
    }
    
    public static void testeDeletar(Evento e) {
        System.out.println("Deletando evento id=" + e.getId() + "...");
        edao.excluir(e);
    }
    
    public static Evento testeBuscar(Evento e) {
        System.out.println("Buscando evento id=" + e.getId() + "...");
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
        System.out.println("\n{\n_id: " + e.getId());
        System.out.println("nome: " + e.getNome());
        System.out.println("descrição: " + e.getDescricao());
        System.out.println("endereço: " + e.getEndereco());
        System.out.println("dataInicio: " + DateUtils.toString(e.getDataInicio(), "dd-MM-yyyy"));
        System.out.println("dataFim: " + DateUtils.toString(e.getDataFim(), "dd-MM-yyyy"));
        System.out.println("predio: { nome: " + e.getPredio().getNome() + " }");
        System.out.println("palestras:\n  [");
        for (Palestra p : e.getPalestras()) {
            System.out.println("\t{\n\t  titulo: " + p.getTitulo());
            System.out.println("\t  assunto: " + p.getAssunto());
            System.out.println("\t  descrição: " + p.getDescricao());
            System.out.println("\t  data: " + DateUtils.toString(p.getData(), "dd-MM-yyyy"));
            System.out.println("\t  inicio: " + DateUtils.toString(p.getHoraInicio(), "HH:mm"));
            System.out.println("\t  fim: " + DateUtils.toString(p.getHoraFim(), "HH:mm"));
            System.out.println("\t  palestrante: {");
            System.out.println("\t\tnome: " + p.getPalestrante().getNome());
            System.out.println("\t\tsexo: " + p.getPalestrante().getSexo());
            System.out.println("\t\tgrauAcadêmico: " + p.getPalestrante().getGrauAcademico());
            System.out.println("\t\tcursoFormação: " + p.getPalestrante().getCursoFormacao());
            System.out.println("\t\tinstituiçãoFormação: " + p.getPalestrante().getInstituicaoFormacao() + "\n\t  }");
            System.out.println("\t  sala: {\n\t\tnome: " + p.getSala().getNome());
            System.out.println("\t\tpublicoPrevisto: " + p.getSala().getPublicoPrevisto() + "\n\t  }\n\t}");
        }
        System.out.println("  ]\n}");
    }
    
    private static Evento cria_evento() {
        Sala s1 = new Sala();
        s1.setNome("354A");
        s1.setPublicoPrevisto(50);
        Predio p1 = new Predio("CT - Anexo A");
 
        Sala s2 = new Sala();
        s2.setNome("361");
        s2.setPublicoPrevisto(30);
        
        Palestrante pal1 = new Palestrante("Paulo", 'M', "Mestrado", "Sistemas de Informação", "UFSM");
        Palestrante pal2 = new Palestrante("Joana", 'F', "Doutorado", "Ciência da Computação", "PUC");
        
        String data = "02-01-2017";
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        Date datePalestra = null;
        try {
            datePalestra = format.parse(data);
        } catch (ParseException ex) {
            Logger.getLogger(TesteEventoMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        String hora = "20:00";
        SimpleDateFormat formatHora = new SimpleDateFormat("HH:mm");
        Date horaPalestra = null;
        try {
            horaPalestra = format.parse(hora);
        } catch (ParseException ex) {
            Logger.getLogger(TesteEventoMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }  
        Palestra pa1 = new Palestra();
        pa1.setTitulo("Surpresas do big data");
        pa1.setAssunto("big data");
        pa1.setDescricao("nessa palestra bla bla");
        pa1.setData(datePalestra);
        pa1.setHoraInicio(horaPalestra);
        pa1.setHoraFim(horaPalestra);
        pa1.setPalestrante(pal1);
        pa1.setSala(s1);

        Palestra pa2 = new Palestra();
        pa2.setTitulo("Surpresas do machine learning");
        pa2.setAssunto("machine learning");
        pa2.setDescricao("esta atividade sera bla bla");
        pa1.setData(datePalestra);
        pa1.setHoraInicio(horaPalestra);
        pa1.setHoraFim(horaPalestra);
        pa2.setPalestrante(pal2);
        pa2.setSala(s2);
        
        data = "25-01-2016";
        format = new SimpleDateFormat("dd-MM-yyyy");
        Date date = null;
        try {
            date = format.parse(data);
        } catch (ParseException ex) {
            Logger.getLogger(TesteEventoMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
        Evento e = new Evento();
        e.setNome("sact");
        e.setDescricao("eng");
        e.setEndereco("ufsm");
        e.setDataFim(date);
        e.setDataInicio(date);
        e.setPredio(p1);
        e.getPalestras().add(pa1);
        e.getPalestras().add(pa2);
        return e;
    }
    
}
