import javax.swing.*;
import java.awt.*;

public class Day6 extends JFrame {
    private DefaultListModel<String> taskListModel;
    private JList<String> taskList;
    private JTextField taskInput;

    public Day6() {
        setTitle("To-Do List App");
        setSize(400, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // center screen
        setLayout(new BorderLayout());

                          
        JPanel topPanel = new JPanel(new BorderLayout());    // TOP PANEL (Title + Buttons)

        JLabel titleLabel = new JLabel("To-Do List", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        topPanel.add(titleLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton addButton = new JButton("Add Task");
        JButton deleteButton = new JButton("Delete Task");
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        topPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(topPanel, BorderLayout.NORTH);

        taskListModel = new DefaultListModel<>();

        // Add some dummy tasks (plain text only)
        taskListModel.addElement("Complete Day 6 To-Do App");
        taskListModel.addElement("Study Java Swing");
        taskListModel.addElement("Write README.md file");

        taskList = new JList<>(taskListModel);
        taskList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        taskList.setFont(new Font("Arial", Font.PLAIN, 16));
        JScrollPane scrollPane = new JScrollPane(taskList);
        add(scrollPane, BorderLayout.CENTER);

        taskInput = new JTextField();
        taskInput.setFont(new Font("Arial", Font.PLAIN, 16));
        add(taskInput, BorderLayout.SOUTH);

        addButton.addActionListener(e -> addTask());
        deleteButton.addActionListener(e -> deleteTask());
        taskInput.addActionListener(e -> addTask()); // Enter key also adds task
    }

    // Add a new task
    private void addTask() {
        String task = taskInput.getText().trim(); // String type task
        if (!task.isEmpty()) {
            taskListModel.addElement(task);
            JOptionPane.showMessageDialog(this, "Task added successfully!");
            taskInput.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "⚠ Task cannot be empty!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void deleteTask() {
        int selectedIndex = taskList.getSelectedIndex();
        if (selectedIndex != -1) {
            taskListModel.remove(selectedIndex);
        } else {
            JOptionPane.showMessageDialog(this, "⚠ Please select a task to delete!", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Day6 app = new Day6();
            app.setVisible(true);
        });
    }
}
