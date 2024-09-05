package com.gyy;

import java.util.ArrayList;
import java.util.Scanner;


public class ATM {
    private ArrayList<Acount> accounts = new ArrayList<>(); // []
    Scanner sc = new Scanner(System.in);

    /**
     * 启动ATM系统 展示欢迎界面
     */
    public void start() {
        while (true) {
            System.out.println("==欢迎您进入ATM系统==");
            System.out.println("1、用户登录");
            System.out.println("2、用户开户");
            System.out.println("请选择:");
            String command = sc.next();
            switch (command) {
                case "1":
                    // 用户登录
                    login();
                    break;
                case "2":
                    // 用户开户
                    createAccount();
                    break;
                default:
                    System.out.println("您输入的命令不存在!!");
            }
        }
    }

    /**
     * 完成用户开户操作
     */
    private void createAccount() {
        System.out.println("==系统开户操作==");
        // 1、创建一个账户对象，用于封装用户的开户信息
        Acount acount = new Acount();

        // 2、需要用户输入自己的开户信息，赋值给账户对象
        System.out.println("请输入您的账户名称:");
        String name = sc.next();
        acount.setUserName(name);

        while (true) {
            System.out.println("请输入您的性别:");
            char sex = sc.next().charAt(0);
            if (sex == '男' || sex == '女') {
                acount.setSex(sex);
                break;
            } else {
                System.out.println("您输入的性别有误,只能为男/女,请重新输入");
            }
        }

        while (true) {
            System.out.println("请输入您的账户密码:");
            String password = sc.next();
            System.out.println("请确认您的账户密码:");
            String confirmedPassword = sc.next(); // 确认密码
            if (confirmedPassword.equals(password)) {
                acount.setPassword(password);
                break;
            } else {
                System.out.println("您两次输入的密码不一致,请重新输入");
            }
        }

        System.out.println("请输入您的每次提现额度");
        double limit = sc.nextDouble();
        acount.setLimit(limit);

        // 重点:我们需要为这个账户生成一个卡号（由系统自动生成。8位数字表示，不能与其他账户的卡号重复：会在下节课详细讲解）

        // 3、把这个账户对象，存入到账户集合中去
        accounts.add(acount);
        System.out.println("恭喜您," + acount.getUserName() + "开户成功,您的卡号是:" + acount.getCardId());
    }

    private void login() {

    }
}
