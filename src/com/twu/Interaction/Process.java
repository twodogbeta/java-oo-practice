package com.twu.Interaction;
import com.twu.Entity.User;
import com.twu.Display.Menu;
import com.twu.Entity.TopTag;
import com.twu.Utils.TopSearch;
import java.util.Scanner;

public  class Process {
    static Scanner sc = null;

    public static String getInput() {
        sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public static void  topSearchProcess(){

        TopSearch topSearchList = new TopSearch();

        mark:
        while (true) {
            Menu.mainMenu();
            int c = Integer.parseInt(getInput());
            String commonUserName = getInput();
            try {
                switch (c) {
                    case 1:
                        System.out.println("请输入您的昵称");
                        String userName = getInput();
                        User user = new User(userName);
                        while (true) {
                            Menu.commonUserMenu(userName);
                            int userInput = Integer.parseInt(getInput());
                            switch (userInput) {
                                case 1:
                                    topSearchList.getTopSearchRank();
                                    break;
                                case 2:
                                    System.out.println("请输入您要投的热搜名称：");
                                    String topSearchName = getInput();
                                    System.out.println("请输入投票数量：  您现在还有："+user.getVotes()+"票");
                                    int topSearchCount = Integer.parseInt(getInput());
                                    if (!user.voteToTopSearch(topSearchCount)) {
                                        System.out.println("投票失败");
                                    } else {
                                        topSearchList.votedToTopSearch(topSearchName, topSearchCount);
                                        System.out.println("投票成功");
                                    }
                                    break;
                                case 3:
                                    System.out.println("请输入您要购买的热搜名称：");
                                    String buySearchName = getInput();
                                    System.out.println("请输入热搜排名：");
                                    int topSearchRank = Integer.parseInt(getInput());
                                    System.out.println("请输入您的竞价金额金额：");
                                    double paidPrice = Double.parseDouble(getInput());
                                    if (paidPrice <=    topSearchList.getTopSearchPrice(buySearchName)) {
                                        System.out.println("购买失败");
                                        break;
                                    }
                                    topSearchList.successPaidTopSearch(buySearchName, paidPrice, topSearchRank);
                                    System.out.println("购买成功");
                                    break;
                                case 4:
                                    System.out.println("请输入您要添加的热搜事件的名字：");
                                    String name = getInput();
                                    TopTag tag = new TopTag(name);
                                    topSearchList.addTopSearch(tag);
                                    System.out.println("添加成功");
                                    break;
                                case 5:
                                    continue mark;
                                default:
                                    System.out.println("输入有误,请重新输入");
                            }
                        }
                        // Administrator
                    case 2:
                        System.out.println("请输入您的昵称：");
                        String adminName = getInput();
                        if (!adminName.equals("admin")) {
                            System.out.println("昵称错误。");
                            break;
                        }
                        System.out.println("请输入您的密码：");
                        String password = getInput();
                        if (!password.equals("admin123")) {
                            System.out.println("密码错误。");
                            break;
                        }

                        while (true) {
                            Menu.adminMenu(adminName);
                            int adminInput = Integer.parseInt(getInput());
                            switch (adminInput) {
                                case 1:
                                    topSearchList.getTopSearchRank(); //热搜榜
                                    break;
                                case 2:
                                    System.out.println("请输入您要添加的超级热搜事件名称：");
                                    String name = getInput();
                                    TopTag tag = new TopTag(name);
                                    topSearchList.addTopSearch(tag);
                                    System.out.println("添加成功");
                                    break;
                                case 3:
                                    System.out.println("请输入您要添加的超级热搜事件的名字：");
                                    String superTopSearchName = getInput();
                                    TopTag superTopSearchTag = new TopTag(superTopSearchName);
                                    superTopSearchTag.setSuperTopSearch(true);
                                    topSearchList.addTopSearch(superTopSearchTag);
                                    break;
                                case 4:
                                    continue mark;
                                default:
                                    System.out.println("输入错误，请重新输入。");
                            }
                        }
                    case 3:
                        System.exit(0);
                    default:
                        System.out.println("输入有误");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    }


