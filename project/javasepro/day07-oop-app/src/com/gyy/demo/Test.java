package com.gyy.demo;

import java.util.Scanner;

/*
    目标: 完成电影信息展示功能；根据电影1d查询该电影详情。
    电影数据:
        1,"水门桥"，38.9, 9.8，"徐克"，"吴京"，"12万人想看”
        2,"出拳吧"，39, 7.8，"唐晓白"，"田雨"，"3.5万人想看"
        3,"月球陨落"，42, 7.9，"罗兰"，"贝瑞"，"17.9万人想看"
        4,”一点就到家"，35, 8.7，"许宏宇"，"刘昊然"，"10.8万人想看"
* */
public class Test {
    public static void main(String[] args) {
        // 1、设计一个电影类
        // 2、设计一个电影的操作类
        // 3、准备全部电影数据
        Movie[] movies = new Movie[4];

        String[] movie_titles = {"水门桥", "出拳吧", "月球陨落", "一点就到家"};
        double[] movie_prices = {38.9, 39, 42, 35};
        double[] movie_scores = {9.8, 7.8, 7.9, 8.7};
        String[] movie_directors = {"徐克", "唐晓白", "罗兰", "许宏宇"};
        String[] movie_actors = {"吴京", "田雨", "贝瑞", "刘昊然"};
        double[] movie_counts = {12, 3.5, 17.9, 10.8};

        for (int i = 0; i < movies.length; i++) {
            movies[i] = new Movie();
            movies[i].setTitle(movie_titles[i]);
            movies[i].setId(i + 1);
            movies[i].setPrice(movie_prices[i]);
            movies[i].setScore(movie_scores[i]);
            movies[i].setDirector(movie_directors[i]);
            movies[i].setActor(movie_actors[i]);
            movies[i].setCount(movie_counts[i]);
        }

        // 4、创建一个电影操作类的对象，接收电影数据，并对其进行业务处理
        MovieOperator movieOperator = new MovieOperator(movies);
        movieOperator.printAllMovies();
        movieOperator.searchMovieById(3);

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("==电影信息系统==");
            System.out.println("1、查询全部电影信息");
            System.out.println("2、根据id查询某个电影的详细信息展示");
            System.out.println("请您输入操作命令:");
            int command = sc.nextInt();
            switch (command) {
                case 1:
                    // 展示全部电影信息
                    movieOperator.printAllMovies();
                    break;
                case 2:
                    // 根据1d查询某个电影的详细信息展示
                    System.out.println("请您输入查询的电影id:");
                    int id = sc.nextInt();
                    movieOperator.searchMovieById(id);
                    break;
                default:
                    System.out.println("您输入的命令有问题");
            }
        }
    }
}
