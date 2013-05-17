package FoxehCutting2;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;



public class GUI {
	public static JFrame frame;
	public JButton start;
	public JComboBox <Trees>  treeSelection; 
	public DefaultComboBoxModel<Trees> model;
	public JCheckBox dropBox;
	public JCheckBox burnBox;
	public GUI () {
		frame = new JFrame ("Tree Annihilator");
		start = new JButton ("Start");
		model = new DefaultComboBoxModel <Trees> ();
		treeSelection = new JComboBox <Trees> (model);
		dropBox = new JCheckBox ("Dropping");
		burnBox = new JCheckBox ("Burn");

		for(Trees i: Trees.values() ) {
			model.addElement (i);
		}
		frame.setLayout (new GridBagLayout ());
		GridBagConstraints c = new GridBagConstraints();
		start.addActionListener(new ActionListener (){

			@Override
			public void actionPerformed(ActionEvent e) {
				Main.running = true;
				Main.mytree=(Trees) treeSelection.getSelectedItem();
				Main.burningLogs=burnBox.isSelected();
				Main.droppingLogs=dropBox.isSelected();
				frame.setVisible (false);
			}

		});
		c.gridx = 0;
		c.gridy = 0;
		frame.add(treeSelection, c);
		c.gridy = 1;
		frame.add(dropBox, c);
		c.gridx = 1;
		frame.add(burnBox, c);
		c.gridx = 1;
		c.gridy = 2;
		frame.add(start, c);
		frame.pack();
		frame.setVisible (true);
	}

}
