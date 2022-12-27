/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import compressordecompressor.compressor;
import compressordecompressor.decompressor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Abdul Mukheed
 */
public class Appframe extends JFrame implements ActionListener{
    
    JButton compressButton;
    JButton decompressButton;
    
    public Appframe(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        
        compressButton = new JButton("Select file for compression");
        compressButton.addActionListener(this);
        compressButton.setBounds(20,55,200,30);
        
        decompressButton = new JButton("select file for decompression");
        decompressButton.addActionListener(this);
        decompressButton.setBounds(250,55,200,30);
        
        this.setLocation(525,350);
        this.add(compressButton);
        this.add(decompressButton);
        this.setSize(500,200);
        this.getContentPane();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == compressButton){
            JFileChooser filechooser = new JFileChooser();
            int response = filechooser.showSaveDialog(null);
            
            if(response == JFileChooser.APPROVE_OPTION){
                File file = new File(filechooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
                try{
                    compressor.method(file);
                }
                catch(Exception excp){
                    JOptionPane.showMessageDialog(null,e.toString());
                }
            }
        }
        
        if(e.getSource() == decompressButton){
            JFileChooser filechooser = new JFileChooser();
            int response = filechooser.showSaveDialog(null);
            
            if(response == JFileChooser.APPROVE_OPTION){
                File file = new File(filechooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
                
                try{
                    decompressor.method(file);
                }
                catch(Exception excp){
                    JOptionPane.showMessageDialog(null,e.toString());
                }
            }
        }
    }
    
    
}
