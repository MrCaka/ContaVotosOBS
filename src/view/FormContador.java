
package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FormContador {
    private JFrame form;
    private JLabel lblCand1, lblCand2, lblCand3, lblCand4, lblTotalVotos, lblTotalCand1, lblTotalCand2;
    private JButton btnAumentCand1, btnDiminCand1, btnAumentCand2, btnDiminCand2, btnReset;
    
    int candidato1 = 0, candidato2 = 0, total = 0;
    String nome1, nome2, nome3, nome4;
    
    public FormContador() {
        
        nome1 = JOptionPane.showInputDialog("Identifique o primeiro candidato.");
        nome2 = JOptionPane.showInputDialog("Identifique o segundo candidato.");
        
        inicializarComponentes() ;
    }
    
     private void inicializarComponentes() {
         
         //inicia os txts
         FileWriter arquivo;
         
         try{
                        arquivo = new FileWriter(new File("candidato1.txt"));
                        arquivo.write(String.valueOf(candidato1));
                        arquivo.close();
                        
                        arquivo = new FileWriter(new File("candidato2.txt"));
                        arquivo.write(String.valueOf(candidato2));
                        arquivo.close();
                        
                        arquivo = new FileWriter(new File("Total.txt"));
                        arquivo.write(String.valueOf(total));
                        arquivo.close();
                } 
                catch (IOException j){
                System.out.println("An error occurred.");
                j.printStackTrace();
                }
         
         
        // instancia objeto JFrame
        form = new JFrame("Contador de Votos para OBS");
        // configura posição (x, y) e tamanho (width, height)
        form.setBounds(500, 250, 500, 300);
        // configura operação padrão ao fechar o formulário
        form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // elimina pré-configurações de layout
        form.setLayout(null);
        // obtém objeto do painel (área) de conteúdo do form
        Container painelDeConteudo = form.getContentPane();
        
        
        
                // CANDIDATOS
        lblCand1 = new JLabel(nome1 + ":");
        lblCand1.setBounds(50, 30, 150, 30);
        painelDeConteudo.add(lblCand1);
        
        lblCand2 = new JLabel(nome2 + ":");
        lblCand2.setBounds(50, 80, 150 , 30);
        painelDeConteudo.add(lblCand2);
        
        /*if(nome3 != null || nome3.isEmpty() )
        {
            lblCand3 = new JLabel(nome3 + ":");
            lblCand3.setBounds(50, 130, 90, 30);
            painelDeConteudo.add(lblCand3);
        }
        
        if(nome4 != null || nome4 != "" )
        {
            lblCand4 = new JLabel(nome4 + ":");
            lblCand4.setBounds(50, 180, 90, 30);
            painelDeConteudo.add(lblCand4);
        }*/
        
                // BOTÕES
        btnAumentCand1 = new JButton("+1 Voto");
        btnAumentCand1.setBounds(230, 30, 90, 30);
        btnAumentCand1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                candidato1 = candidato1 + 1;
                total++;
                
                FileWriter arquivo;
	
                try{
                        arquivo = new FileWriter(new File("candidato1.txt"));
                        arquivo.write(String.valueOf(candidato1));
                        arquivo.close();
                } 
                catch (IOException j){
                System.out.println("An error occurred.");
                j.printStackTrace();
                }
                
                try{
                        arquivo = new FileWriter(new File("Total.txt"));
                        arquivo.write(String.valueOf(total));
                        arquivo.close();
                } 
                catch (IOException j){
                System.out.println("An error occurred.");
                j.printStackTrace();
                }
                
                lblTotalCand1.setText(String.format("%s: %s", nome1,String.valueOf(candidato1)));
                lblTotalVotos.setText(String.format("Total de Votos: %s", String.valueOf(total)));
            } 
        });
        painelDeConteudo.add(btnAumentCand1);
        
        btnDiminCand1 = new JButton("-1 Voto");
        btnDiminCand1.setBounds(340, 30, 90, 30);
        btnDiminCand1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                candidato1 = candidato1 - 1;
                total--;
                
                FileWriter arquivo;
	
                try{
                        arquivo = new FileWriter(new File("candidato1.txt"));
                        arquivo.write(String.valueOf(candidato1));
                        arquivo.close();
                } 
                catch (IOException j){
                System.out.println("An error occurred.");
                j.printStackTrace();
                }
                
                try{
                        arquivo = new FileWriter(new File("Total.txt"));
                        arquivo.write(String.valueOf(total));
                        arquivo.close();
                } 
                catch (IOException j){
                System.out.println("An error occurred.");
                j.printStackTrace();
                }
                
                lblTotalCand1.setText(String.format("%s: %s", nome1,String.valueOf(candidato1)));
                lblTotalVotos.setText(String.format("Total de Votos: %s", String.valueOf(total)));
            } 
        });
        painelDeConteudo.add(btnDiminCand1);
        
        btnAumentCand2 = new JButton("+1 Voto");
        btnAumentCand2.setBounds(230, 80, 90, 30);
        btnAumentCand2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                candidato2 = candidato2 + 1;
                total++;
                
                FileWriter arquivo;
	
                try{
                        arquivo = new FileWriter(new File("candidato2.txt"));
                        arquivo.write(String.valueOf(candidato2));
                        arquivo.close();
                } 
                catch (IOException j){
                System.out.println("An error occurred.");
                j.printStackTrace();
                }
                
                try{
                        arquivo = new FileWriter(new File("Total.txt"));
                        arquivo.write(String.valueOf(total));
                        arquivo.close();
                } 
                catch (IOException j){
                System.out.println("An error occurred.");
                j.printStackTrace();
                }
                
                lblTotalCand2.setText(String.format("%s: %s", nome2,String.valueOf(candidato2)));
                lblTotalVotos.setText(String.format("Total de Votos: %s", String.valueOf(total)));
            } 
        });
        painelDeConteudo.add(btnAumentCand2);
        
        btnDiminCand2 = new JButton("-1 Voto");
        btnDiminCand2.setBounds(340, 80, 90, 30);
        btnDiminCand2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                candidato2 = candidato2 - 1;
                total--;
                
                FileWriter arquivo;
	
                try{
                        arquivo = new FileWriter(new File("candidato2.txt"));
                        arquivo.write(String.valueOf(candidato2));
                        arquivo.close();
                } 
                catch (IOException j){
                System.out.println("An error occurred.");
                j.printStackTrace();
                }
                
                FileWriter arquiv2;
	
                try{
                        arquivo = new FileWriter(new File("Total.txt"));
                        arquivo.write(String.valueOf(total));
                        arquivo.close();
                } 
                catch (IOException j){
                System.out.println("An error occurred.");
                j.printStackTrace();
                }
                
                lblTotalCand2.setText(String.format("%s: %s", nome2 ,String.valueOf(candidato2)));
                lblTotalVotos.setText(String.format("Total de Votos: %s", String.valueOf(total)));
            } 
        });
        painelDeConteudo.add(btnDiminCand2);
        
                // TOTAL DE VOTOS
        lblTotalCand1 = new JLabelVotos("Votos Candidato 1: 0");
        lblTotalCand1.setBounds(90, 130, 150, 30);
        painelDeConteudo.add(lblTotalCand1);
        
        lblTotalCand2 = new JLabelVotos("Votos Candidato 2: 0");
        lblTotalCand2.setBounds(260, 130, 150, 30);
        painelDeConteudo.add(lblTotalCand2);
        
        lblTotalVotos = new JLabelVotos("Total de Votos: 0");
        lblTotalVotos.setBounds(100, 170, 200, 30);
        painelDeConteudo.add(lblTotalVotos);
        
                // BOTÃO RESET
        btnReset = new JButton("RESETAR VOTOS");
        btnReset.setBounds(300, 220, 160, 30);
        btnReset.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                int certeza = JOptionPane.showConfirmDialog(null,"Tem certeza? essa ação é irreversivel.");
                
                if(certeza == 0){
                    candidato1 = 0;
                    candidato2 = 0;
                    total = 0;

                    FileWriter arquivo;

                    try{
                            arquivo = new FileWriter(new File("candidato1.txt"));
                            arquivo.write(String.valueOf(candidato1));
                            arquivo.close();

                            arquivo = new FileWriter(new File("candidato2.txt"));
                            arquivo.write(String.valueOf(candidato2));
                            arquivo.close();

                            arquivo = new FileWriter(new File("Total.txt"));
                            arquivo.write(String.valueOf(total));
                            arquivo.close();
                    } 
                    catch (IOException j){
                    System.out.println("An error occurred.");
                    j.printStackTrace();
                    }

                    lblTotalCand1.setText(String.format("%s: %s", nome1,String.valueOf(candidato1)));
                    lblTotalCand2.setText(String.format("%s: %s", nome2,String.valueOf(candidato2)));
                    lblTotalVotos.setText(String.format("Total de Votos: %s", String.valueOf(total)));
            }
            }
        });
        painelDeConteudo.add(btnReset);
        
        
                //TORNA O FORMULARIO VISIVEL
        form.setVisible(true);
    }
}
