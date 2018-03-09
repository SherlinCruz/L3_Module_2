package intro_to_file_io;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ToDoListTracker implements ActionListener {

	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton addTask = new JButton();
	JButton removeTask = new JButton();
	JButton save = new JButton();
	JButton load = new JButton();
	JTextArea taskList = new JTextArea();

	ArrayList<String> list = new ArrayList<String>();

	public static void main(String[] args) {
		ToDoListTracker ToDoListTracker = new ToDoListTracker();

	}

	ToDoListTracker() {

		frame.setVisible(true);

		frame.add(panel);
		panel.add(addTask);
		panel.add(removeTask);
		panel.add(load);
		panel.add(save);
		panel.add(taskList);

		addTask.setText("addTask");
		removeTask.setText("removeTask");
		load.setText("load");
		save.setText("save");
		taskList.setText("List");

		addTask.addActionListener(this);
		removeTask.addActionListener(this);
		load.addActionListener(this);
		save.addActionListener(this);

		frame.pack();
	}

	void updateTaskList() {

		String allTask = "";

		for (String task : list) {

			allTask += task;

			allTask += "\n";

		}

		taskList.setText(allTask);

		frame.pack();
		frame.repaint();

	}

	/*
	 * void JFileChooser(){ JFileChooser jfc = new JFileChooser(); int returnVal =
	 * jfc.showOpenDialog(null); if (returnVal == JFileChooser.APPROVE_OPTION) {
	 * String fileName = jfc.getSelectedFile().getAbsolutePath();
	 * System.out.println(fileName); } }
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// look at the whiteboard picture in photos

		if (e.getSource().equals(addTask)) {

			String taskAdded = JOptionPane.showInputDialog(" Add a task: ");

			list.add(taskAdded);

			updateTaskList();

			// System.out.println(taskAdded);

		}

		if (e.getSource().equals(save)) {
			try {
				JFileChooser jfc = new JFileChooser();
				int returnVal = jfc.showOpenDialog(null);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					String fileName = jfc.getSelectedFile().getAbsolutePath();
					System.out.println(fileName);
				}

				FileWriter fw = new FileWriter(jfc.getSelectedFile(), true);

				for (String task : list) {

					fw.write(task + "\n");
				}

				fw.close();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}

		if (e.getSource().equals(removeTask)) {

			if (list.isEmpty()) {
				JOptionPane.showMessageDialog(null, "List is emtpty.");
			} else {

				String itemRemove = JOptionPane.showInputDialog("Which item from the list do you want to remove ?");

				// for (int i = 0; i < list.size(); i++) {
				// if(list.get(i).equalsIgnoreCase(itemRemove)) {

				list.remove(itemRemove);

				// }// }
				// We can use the for loop code or simply remove it like above

			}

			updateTaskList();
		}

		if (e.getSource().equals(load)) {

			list = new ArrayList<String>();
			String fileName = "";

			JFileChooser jfc = new JFileChooser();
			int returnVal = jfc.showOpenDialog(null);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				fileName = jfc.getSelectedFile().getAbsolutePath();
				System.out.println(fileName);
			}

			try {

				BufferedReader br = new BufferedReader(new FileReader(fileName));

				String line = br.readLine();
				while (line != null) {
					list.add(line);
					line = br.readLine();

				}

				updateTaskList();
				// br.close();
				// fw.close();

			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			updateTaskList();
		}

	}
}