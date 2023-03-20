package ywrhee.project;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class StatisticDialog extends JDialog {
    private Container dialog = this.getContentPane();
    private StartFrame parent;

    private JTable statisticTable;
    private String columns[] = {"결과", "빙고판 크기", "AI 수준", "게임 시간"};

    private ArrayList<Game> statisticList;
    private String statisticInfo;

    public StatisticDialog(StartFrame owner, String title, ArrayList<Game> statisticList, String statisticInfo) {
        super(owner, title, true);
        parent = owner;
        this.statisticList = statisticList;
        this.statisticInfo = statisticInfo;

        this.setSize(450, 600);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocation(parent.getLocation().x + parent.getWidth(), parent.getLocation().y);

        initUI();

        this.setVisible(true);
    }

    private void initUI() {
        JPanel upperPanel = new JPanel();
        upperPanel.setLayout(new BorderLayout());
        upperPanel.setBorder(BorderFactory.createEmptyBorder(60, 0, 0, 0));

        JLabel title = new JLabel("통계", SwingConstants.CENTER);
        title.setFont(new Font("GangwonEduPower", Font.BOLD, 38));

        upperPanel.add(title, BorderLayout.NORTH);

        JLabel winningInfo = new JLabel(statisticInfo, SwingConstants.CENTER);
        winningInfo.setBorder(BorderFactory.createEmptyBorder(5, 0, 30, 0));
        upperPanel.add(winningInfo, BorderLayout.SOUTH);

        dialog.add(upperPanel, BorderLayout.NORTH);


        DefaultTableModel tableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        statisticTable = new JTable(tableModel);

        DefaultTableCellRenderer tableCellRenderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                final Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                switch (statisticList.get(row).getWinLoseInfo()) {
                    case Game.VICTORY -> c.setBackground(Color.decode("#3a4d43"));
                    case Game.DRAW -> c.setBackground(Color.decode("#4e4e3c"));
                    case Game.DEFEAT -> c.setBackground(Color.decode("#4e4040"));
                }

                return c;
            }
        };
        tableCellRenderer.setHorizontalAlignment(JLabel.CENTER);

        statisticTable.setDefaultRenderer(Object.class, tableCellRenderer);
        statisticTable.setEnabled(false);

        for (int i = 0; i < 3; i++)
            statisticTable.getColumnModel().getColumn(i).setPreferredWidth(1);
        statisticTable.setRowHeight(50);
        statisticList.forEach(it -> tableModel.addRow(it.getTableRow()));

        JScrollPane scrollPane = new JScrollPane(statisticTable);
        dialog.add(scrollPane, BorderLayout.CENTER);
    }

}
