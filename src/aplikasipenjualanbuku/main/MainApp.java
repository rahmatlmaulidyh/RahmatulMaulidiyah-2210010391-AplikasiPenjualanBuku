package aplikasipenjualanbuku.main;

import aplikasipenjualanbuku.ui.FormBuku;
import aplikasipenjualanbuku.ui.FormTransaksi;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

public class MainApp {
    // Define colors
    private static final Color PRIMARY_COLOR = new Color(51, 153, 255);    // Blue
    private static final Color SECONDARY_COLOR = new Color(245, 245, 245); // Light Gray
    private static final Color TEXT_COLOR = new Color(51, 51, 51);        // Dark Gray
    private static final Color HOVER_COLOR = new Color(41, 128, 185);     // Darker Blue

    public static void main(String[] args) {
        try {
            // Set system look and feel
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Aplikasi Penjualan Buku");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(500, 400);
            frame.setMinimumSize(new Dimension(400, 350));

            // Main panel with gradient background
            JPanel mainPanel = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    Graphics2D g2d = (Graphics2D) g;
                    g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                    int w = getWidth();
                    int h = getHeight();
                    GradientPaint gp = new GradientPaint(0, 0, Color.WHITE, 0, h, SECONDARY_COLOR);
                    g2d.setPaint(gp);
                    g2d.fillRect(0, 0, w, h);
                }
            };
            mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
            mainPanel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

            // Title Panel with modern design
            JPanel titlePanel = new JPanel();
            titlePanel.setOpaque(false);
            titlePanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
            JLabel titleLabel = new JLabel("APLIKASI PENJUALAN BUKU");
            titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
            titleLabel.setForeground(PRIMARY_COLOR);
            titlePanel.add(titleLabel);

            // Subtitle
            JPanel subtitlePanel = new JPanel();
            subtitlePanel.setOpaque(false);
            JLabel subtitleLabel = new JLabel("Sistem Manajemen Toko Buku");
            subtitleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
            subtitleLabel.setForeground(TEXT_COLOR);
            subtitlePanel.add(subtitleLabel);

            // Custom separator
            JSeparator separator = new JSeparator() {
                @Override
                protected void paintComponent(Graphics g) {
                    Graphics2D g2d = (Graphics2D) g;
                    g2d.setColor(PRIMARY_COLOR);
                    g2d.setStroke(new BasicStroke(2f));
                    g2d.drawLine(0, 0, getWidth(), 0);
                }
            };
            separator.setMaximumSize(new Dimension(300, 2));
            separator.setForeground(PRIMARY_COLOR);

            // Menu Panel
            JPanel menuPanel = new JPanel();
            menuPanel.setOpaque(false);
            menuPanel.setBorder(BorderFactory.createEmptyBorder(30, 0, 20, 0));
            menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));

            // Create buttons with modern design
            JButton bukuButton = createModernButton("Kelola Buku", "📚");
            JButton transaksiButton = createModernButton("Transaksi", "💰");
            JButton keluarButton = createModernButton("Keluar", "🚪");

            // Add components
            mainPanel.add(titlePanel);
            mainPanel.add(subtitlePanel);
            mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
            mainPanel.add(separator);
            mainPanel.add(menuPanel);

            menuPanel.add(bukuButton);
            menuPanel.add(Box.createRigidArea(new Dimension(0, 15)));
            menuPanel.add(transaksiButton);
            menuPanel.add(Box.createRigidArea(new Dimension(0, 15)));
            menuPanel.add(keluarButton);

            // Action Listeners
            bukuButton.addActionListener(e -> {
                SwingUtilities.invokeLater(() -> {
                    FormBuku formBuku = new FormBuku();
                    formBuku.setVisible(true);
                });
            });

            transaksiButton.addActionListener(e -> {
                SwingUtilities.invokeLater(() -> {
                    FormTransaksi formTransaksi = new FormTransaksi();
                    formTransaksi.setVisible(true);
                });
            });

            keluarButton.addActionListener(e -> {
                int confirm = JOptionPane.showConfirmDialog(frame,
                    "Apakah Anda yakin ingin keluar?",
                    "Konfirmasi Keluar",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
                if (confirm == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            });

            // Center alignment
            titlePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
            subtitlePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
            separator.setAlignmentX(Component.CENTER_ALIGNMENT);
            menuPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

            frame.add(mainPanel);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

    private static JButton createModernButton(String text, String icon) {
        JButton button = new JButton(icon + "  " + text);
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button.setForeground(Color.WHITE);
        button.setBackground(PRIMARY_COLOR);
        button.setMaximumSize(new Dimension(200, 40));
        button.setPreferredSize(new Dimension(200, 40));
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setOpaque(true);
        
        // Modern rounded corners with drop shadow
        button.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(0, 0, 0, 30), 1),
            BorderFactory.createEmptyBorder(5, 15, 5, 15)
        ));

        // Hover effect
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(HOVER_COLOR);
                button.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(PRIMARY_COLOR);
            }
        });

        return button;
    }
}