package com.tustar.pattern.structural.flyweight;

public class Client {

    public static void main(String[] args) {
        IgoChessman black1, black2, black3;
        IgoChessman white1, white2;
        IgoChessmanFactory factory = IgoChessmanFactory.getIntance();

        black1 = factory.getIgoChessman("b");
        black2 = factory.getIgoChessman("b");
        black3 = factory.getIgoChessman("b");
        System.out.println("判断两颗黑子是否相同:" + (black1 == black2));
        //
        white1 = factory.getIgoChessman("w");
        white2 = factory.getIgoChessman("w");
        System.out.println("判断两颗白子是否相同:" + (white1 == white2));

        //
        black1.display(1, 2);
        black2.display(3, 4);
        black3.display(1, 3);
        white1.display(2, 5);
        white2.display(2, 4);
    }
}
