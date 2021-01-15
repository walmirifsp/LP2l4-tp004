/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 walmir santos feitoza junior 
 aramis nogueira
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.lang.Object;
import java.util.List;

public class Form implements ActionListener {
        Conexao c = new Conexao();
        List<Funcionario> func;
        int maximo = 0;
        int atual = 0;
        private JFrame frame = new JFrame();
	private JLabel l1 = new JLabel("Nome:");
	private JTextField t1 = new JTextField(12);
        private JLabel l2 = new JLabel("Nome:");
	private JTextField t2 = new JTextField(12);
        private JLabel l3 = new JLabel("Salario:");
	private JTextField t3 = new JTextField(12);
        private JLabel l4 = new JLabel("Cargo:");
	private JTextField t4 = new JTextField(12);
	private JButton b1 = new JButton();
        private JButton b2 = new JButton();
        private JButton b3 = new JButton();
        private JPanel p = new JPanel();
	private JPanel p1 = new JPanel();
        private JPanel p2 = new JPanel();
        private JPanel p3 = new JPanel();
        
        Form(){
            b1.setText("Pesquisar");
            b2.setText("Anterior");
            b3.setText("Proximo");
	    b1.addActionListener(this);
            b2.addActionListener(this);
            b3.addActionListener(this);
	    //t1.setEditable(false);
            
	    frame.setSize(300,260);
	    frame.setLocation(200,200);
	    frame.setTitle("TP 04");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
	    p1.add(l1);
            p1.add(t1);
            
            p2.add(l2);
            p2.add(t2);
            p2.add(l3);
            p2.add(t3);
            p2.add(l4);
            p2.add(t4);
            p3.add(b2);
            p3.add(b3);
            p2.setLayout(new GridLayout(3,2,10,10));  
            p.add(p1);
            p.add(b1);
            p.add(p2);
            p.add(p3);
            frame.add(p);
            
	    frame.setVisible(true);
        }
        public void actionPerformed(ActionEvent e){
            String command = e.getActionCommand();
            if("Pesquisar".equals(command)){
                //c.insert(1, "", 1.1, 1);
                func = c.select(t1.getText());
                maximo = func.size();
                atual = 0;
                t2.setText(func.get(atual).getNome());
                t3.setText(String.valueOf(func.get(atual).getSal()));
                t4.setText(func.get(atual).getCargo());
            }
            if("Anterior".equals(command)){
                if(atual > 0){
                atual--;
                t2.setText(func.get(atual).getNome());
                t3.setText(String.valueOf(func.get(atual).getSal()));
                t4.setText(func.get(atual).getCargo());
                }
                else{
                    JOptionPane.showMessageDialog(null, "esta no minimo");
                }
                
            }
            if("Próximo".equals(command)){
                if(atual < maximo){
                atual++;
                t2.setText(func.get(atual).getNome());
                t3.setText(String.valueOf(func.get(atual).getSal()));
                t4.setText(func.get(atual).getCargo());
                }
                else{
                    JOptionPane.showMessageDialog(null, "esta no maximo");
                }
            }
            
        }
        
        public static void main(String[] args) {
	    
            
	    Form f = new Form();
	    
	    
	}
        
}



