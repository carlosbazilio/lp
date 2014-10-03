package br.uff.puro.comp.lp.exemplos;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

public class Navegador extends MouseAdapter implements ActionListener, HyperlinkListener {
	private JEditorPane conteudo;
	private JTextField endereco;
	private JLabel url;
	private JLabel status;
	private JFrame janela;
	
	public Navegador() {
		janela = new JFrame();
		
		// Cabecalho
		JPanel pCabecalho = new JPanel(new BorderLayout());
		url = new JLabel("url:");
		pCabecalho.add("West", url);
		endereco = new JTextField();
		pCabecalho.add("Center", endereco);

		// Conteúdo do browser
		setConteudo(new JEditorPane());
		getConteudo().setEditable(false);
		JScrollPane pConteudo = new JScrollPane(getConteudo());
		
		// Barra de status
		JPanel pRodape = new JPanel(new BorderLayout());
		status = new JLabel(" ");
		pRodape.add("Center", status);
		
		Container cp = janela.getContentPane();
		cp.add("North", pCabecalho);
		cp.add("Center", pConteudo);
		cp.add("South", pRodape);
		
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		endereco.addActionListener(this);
		getConteudo().addHyperlinkListener(this);
		url.addMouseListener(this);
		
//		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
//		this.setSize(dim);
		
		int state = janela.getExtendedState();
	    
        // Set the maximized bits
        state |= Frame.MAXIMIZED_BOTH;
    
        // Maximize the frame
        janela.setExtendedState(state);
		
        janela.setVisible(true);
	}

	public void actionPerformed(ActionEvent arg0) {
		disparaEndereco(arg0.getActionCommand());
	}

	public void hyperlinkUpdate(HyperlinkEvent arg0) {
		if (arg0.getEventType() == HyperlinkEvent.EventType.ACTIVATED)
			disparaEndereco(arg0.getURL().toString());
		else
			status.setText(arg0.getURL().toString());
	}

	public void disparaEndereco(String url) {
		if (url.trim().equals("")) return;
		try {
			getConteudo().setPage(url);
			endereco.setText(url);
		} catch (IOException e) {
			System.out.println("Erro na exibição da página !!!");
		}
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		// Modal dialog with OK/cancel and a text field
	    String text = JOptionPane.showInputDialog(janela, "Forneça a url desejada: " );
	    if (text != null) {
	        this.disparaEndereco(text);
	    }
	}

	public void setConteudo(JEditorPane conteudo) {
		this.conteudo = conteudo;
	}

	public JEditorPane getConteudo() {
		return conteudo;
	}
}
