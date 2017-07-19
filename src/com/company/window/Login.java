package com.company.window;

import com.company.Loger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Created by Administrator on 2017/7/19 0019.
 */
public class Login {
    JFrame frame;

    JPanel panel;

    JTextField text;

    int acc=0;
    static public void main(String[] Args) {
        Login login = new Login();
        login.frame.setVisible(true);
    }

    private Login() {
        this.initFrame();
        this.initPanel();
        this.initText();

        this.panel.add(this.text);
        this.frame.add(this.panel);
    }

    //输入框
    private void initText() {
        this.text = new JTextField(20);
        this.text.setBackground(new Color(199, 237, 204));
        this.text.setText("请输入内容");
//        this.text.setBounds(3, 3, 10, 30);
    }

    //布局容器
    private void initPanel() {
        this.panel = new JPanel();
        this.panel.setBounds(0, 0, 100, 30);
        this.panel.setBackground(new Color(129, 125, 198));

        JButton ok = new JButton();
        ok.setText("改变");
        ok.addActionListener((ActionEvent e) -> {
            Loger.debug("ok"+e.toString());
            this.acc++;
            this.text.setText("click_times:"+this.acc);
        });
        this.panel.add(ok);

    }

    //主窗体
    private void initFrame() {
        this.frame = new JFrame();

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension dimension = kit.getScreenSize();
        this.frame.setBounds(dimension.width / 2, 30, 300, 300);
        this.frame.setTitle("test");
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
