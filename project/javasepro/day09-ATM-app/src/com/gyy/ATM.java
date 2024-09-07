package com.gyy;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class ATM {
    private ArrayList<Acount> acounts = new ArrayList<>(); // []
    private Acount loginAcount;
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
        if (acounts.isEmpty()) {
            System.out.println("您好,当前系统无账户,请先开户再来登录");
            return;
        }
        while (true) {
            System.out.println("请输入您的卡号:");
            String cardId = sc.next();
            Acount acount = getAcountByCardId(cardId);
            if (acount == null) {
                System.out.println("系统中不存在该账户卡号,请重新输入");
            } else {
                while (true) {
                    System.out.println("请输入您的密码:");
                    String password = sc.next();
                    if (password.equals(acount.getPassword())) {
                        loginAcount = acount;
                        System.out.println("恭喜您," + acount.getUserName() + ",您已进入系统,您的卡号是:" + acount.getCardId());
                        showUserCommand();
                        return;
                    } else {
                        System.out.println("您的密码有误,请重新输入");
                    }
                }
            }
        }
    }

    /**
     * 展示用户操作界面
     */
    private void showUserCommand() {
        while (true) {
            System.out.println(loginAcount.getUserName() + "您可以选择如下功能进行账户的处理==");
            System.out.println("1、查询账户");
            System.out.println("2、存款");
            System.out.println("3、取款");
            System.out.println("4、转账");
            System.out.println("5、密码修改");
            System.out.println("6、退出");
            System.out.println("7、注销当前账户");
            System.out.println("请选择:");
            String command = sc.next();
            switch (command) {
                case "1":
                    showLoginAcount();
                    break;
                case "2":
                    // deposit();
                    break;
                case "3":
                    // withdrawal();
                    break;
                case "4":
                    // transfer();
                    break;
                case "5":
                    // passwordChange();
                    break;
                case "6":
                    // System.out.println(loginAcount.getUserName() + "您退出系统成功!");
                    break;
                case "7":
                    // cancellation();
                    break;
                default:
                    System.out.println("操作命令不存在,请重新输入");
            }
        }
    }

    /*private void cancellation() {
     *//*for (int i = 0; i < acounts.size(); i++) {
            System.out.println(acounts.get(i).getUserName());
        }
        System.out.println("-------------------------");*//*
        if (loginAcount.getMoney() > 0) {
            System.out.println("您的账户还有余额,请将余额取出,再进行注销");
        } else {
            Acount cancellationAcount = loginAcount;
            acounts.remove(loginAcount);
            System.out.println(cancellationAcount.getUserName() + ",您已成功注销");
        }
        *//*for (int i = 0; i < acounts.size(); i++) {
            System.out.println(acounts.get(i).getUserName());
        }*//*
    }*/

    /*private void passwordChange() {
        while (true) {
            System.out.println("请输入原密码:");
            String oldPassword = sc.next();
            if (!oldPassword.equals(loginAcount.getPassword())) {
                System.out.println("您输入的密码有误,请重新给输入");
            } else {
                while (true) {
                    String newPassword = null;
                    while (true) {
                        System.out.println("请输入新密码:");
                        newPassword = sc.next();
                        if (newPassword.equals(oldPassword)) {
                            System.out.println("新密码不能与原密码一致");
                        } else {
                            break;
                        }
                    }
                    System.out.println("确认新密码:");
                    String okNewPassword = sc.next();
                    if (!okNewPassword.equals(newPassword)) {
                        System.out.println("你两次输入的密码不一致,请重新输入");
                    } else {
                        loginAcount.setPassword(newPassword);
                        System.out.println("密码修改成功,重新登录");
                        return;
                    }
                }
            }
        }
    }*/

    /*private void transfer() {
        if (acounts.size() < 2) {
            System.out.println("系统中无其他账户,请再去开户");
            return;
        }
        while (true) {
            System.out.println("请输入您转账账户的卡号:");
            String cardId = sc.next();
            Acount transferAcount = getAcountByCardId(cardId);
            if (transferAcount == null) {
                System.out.println("您输入的卡号有误,请重新输入");
            } else {
                while (true) {
                    System.out.println("请输入转账金额:");
                    double transferMoney = sc.nextDouble();
                    if (transferMoney > loginAcount.getMoney()) {
                        System.out.println("您当前余额不足,请重新输入");
                    } else if (transferMoney > loginAcount.getLimit()) {
                        System.out.println("当前转账金额大于您的每次提现额度,请重新输入");
                    } else {
                        double money = loginAcount.getMoney() - transferMoney;
                        loginAcount.setMoney(money);
                        double transferAcountMoney = transferAcount.getMoney() + transferMoney;
                        transferAcount.setMoney(transferAcountMoney);
                        System.out.println("转账成功," + loginAcount.getUserName() + ",您当前账户余额为" + loginAcount.getMoney());
                        return;
                    }
                }
            }
        }
    }*/

    /**
     * 取钱
     */
    /*private void withdrawal() {
        System.out.println("==取钱操作==");
        // 1、判断账户余额是否达到100元，如果不够100元，就不让用户取钱了
        if (loginAcount.getMoney() < 100) {
            System.out.println("您的账户余额不足100元,不允许取钱");
            return;
        }

        while (true) {
            System.out.println("请输入您的取款金额:");
            double money = sc.nextDouble();
            // 3、判断账户余额是否足够
            if (money > loginAcount.getMoney()) {
                System.out.println("您当前余额不足, 账户余额为" + loginAcount.getMoney());
            } else if (money > loginAcount.getLimit()) {
                // 账户中的余额是足够的
                // 4、判断当前取款金额是否超过了每次限额
                System.out.println("当前取款金额大于您的每次提现额度,每次最多可取" + loginAcount.getLimit());
            } else {
                // 代表可以开始取钱，更新当前账户余额即可
                loginAcount.setMoney(loginAcount.getMoney() - money);
                System.out.println("取款" + money + "成功,当前您的账户余额为" + loginAcount.getMoney());
                break;
            }
        }
    }*/

    /**
     * 存钱
     */
    /*private void deposit() {
        System.out.println("==存钱操作==");
        System.out.println("请输入您的存款金额");
        double money = sc.nextDouble();
        loginAcount.setMoney(loginAcount.getMoney() + money);
        System.out.println("存款" + money + "成功！" + loginAcount.getUserName() + ",您当前余额为" + loginAcount.getMoney());
    }*/

    /**
     * 展示当前登录的账户信息
     */
    private void showLoginAcount() {
        System.out.println("==当前您的帐户信息如下:==");
        System.out.println("卡号:" + loginAcount.getCardId());
        System.out.println("户主:" + loginAcount.getUserName());
        System.out.println("性别:" + loginAcount.getSex());
        System.out.println("余额:" + loginAcount.getMoney());
        System.out.println("每次取现额度:" + loginAcount.getLimit());
    }
}
