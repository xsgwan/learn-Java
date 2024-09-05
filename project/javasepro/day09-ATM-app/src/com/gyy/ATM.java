package com.gyy;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class ATM {
    private ArrayList<Acount> acounts = new ArrayList<>(); // []
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
                    createAcount();
                    break;
                default:
                    System.out.println("您输入的命令不存在!!");
            }
        }
    }

    /**
     * 完成用户开户操作
     */
    private void createAcount() {
        System.out.println("==系统开户操作==");
        // 1、创建一个账户对象，用于封装用户的开户信息
        Acount acount = new Acount();

        // 2、需要用户输入自己的开户信息，赋值给账户对象
        // 输入名称
        System.out.println("请输入您的账户名称:");
        String name = sc.next();
        acount.setUserName(name);

        // 输入性别
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

        // 输入密码
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

        // 输入限额
        System.out.println("请输入您的每次提现额度:");
        double limit = sc.nextDouble();
        acount.setLimit(limit);

        // 重点:我们需要为这个账户生成一个卡号(由系统自动生成。8位数字表示，不能与其他账户的卡号重复)
//        createCardId(acount);
        String newCardId = createCardId();
        acount.setCardId(newCardId);

        // 3、把这个账户对象，存入到账户集合中去
        acounts.add(acount);
        System.out.println("恭喜您," + acount.getUserName() + "开户成功,您的卡号是:" + acount.getCardId());
    }

    /**
     * 返回一个8位  数字的卡号，而且这个卡号不能与其他账户的卡号重复
     */
    private void createCardId(Acount acount) {
        Random r = new Random();
        StringBuilder cardId = new StringBuilder();
        int num = 0;
        for (int i = 1; i <= 8; i++) {
            if (i == 1) {
                num = r.nextInt(9) + 1;
            } else {
                num = r.nextInt(10);
            }
            cardId.append(num);
        }

        if (acounts.isEmpty()) {
            acount.setCardId(cardId.toString());
        }

        for (int i = 0; i < acounts.size(); i++) {
            if (cardId.toString().equals(acounts.get(i).getCardId())) {
                break;
            }
            if (i == acounts.size() - 1) {
                acount.setCardId(cardId.toString());
            }
        }
    }

    private String createCardId() {
        String cardId = "";
        Random r = new Random();
        while (true) {
            for (int i = 1; i <= 8; i++) {
                int data = r.nextInt(10); // 0 - 9
                cardId += data;
            }
            Acount acount = getAcountByCardId(cardId);
            if (acount == null) {
                // 说明cardId没有找到账户对象，因此cardId没有与其他账户的卡号重复，可以返回它做为一个新卡号
                return cardId;
            }
        }
    }

    private Acount getAcountByCardId(String cardId) {
        for (int i = 0; i < acounts.size(); i++) {
            Acount acount = acounts.get(i);
            if (acount.getCardId().equals(cardId)) {
                return acount;
            }
        }
        return null;
    }

    private void login() {

    }
}
