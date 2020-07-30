package com.twu.Display;

public class Menu {
    public static void mainMenu() {
        System.out.println("欢迎来到热搜排行榜，您是？ 请输入相应数字进行操作： \n1. 用户 \n2. 管理员 \n3. 退出");
    }

    public static void adminMenu(String adminName) {
        System.out.println("您好，" + "亲爱的 " + adminName + "，您可以：");
        System.out.println("1.查看热搜排行榜");
        System.out.println("2.添加热搜");
        System.out.println("3.添加超级热搜");
        System.out.println("4.退出");
    }

    public static void commonUserMenu(String username) {
        System.out.println("您好，" + username + "，您可以：");
        System.out.println("1.查看热搜排行榜");
        System.out.println("2.给热搜事件投票");
        System.out.println("3.购买热搜");
        System.out.println("4.添加热搜");
        System.out.println("5.退出");
    }
}