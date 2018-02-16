package intro_to_file_io;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoListTracker implements ActionListener {

	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton addTask = new JButton();
	JButton removeTask = new JButton();
	JButton save = new JButton();
	JButton load = new JButton();

	public static void main(String[] args) {
		ToDoListTracker ToDoListTracker = new ToDoListTracker();
	}

	ToDoListTracker() {

		frame.setVisible(true);
		panel.setVisible(true);
		addTask.setVisible(true);
		removeTask.setVisible(true);
		load.setVisible(true);
		save.setVisible(true);

		frame.add(panel);
		panel.add(addTask);
		panel.add(removeTask);
		panel.add(load);
		panel.add(save);

		addTask.setText("addTask");
		removeTask.setText("removeTask");
		load.setText("load");
		save.setText("save");

		addTask.addActionListener(this);
		removeTask.addActionListener(this);
		load.addActionListener(this);
		save.addActionListener(this);

		frame.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		
		
		//look at the whiteboard picture from the white board
		
		if (e.getSource().equals(save)) {

			String taskAdded = JOptionPane.showInputDialog("Task");

			try {
				FileWriter fw = new FileWriter("src/intro_to_file_io/test4.txt", true);

				fw.write(taskAdded + "\n");

				fw.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		}

		if (e.getSource().equals(removeTask)) {

		}

	}
}