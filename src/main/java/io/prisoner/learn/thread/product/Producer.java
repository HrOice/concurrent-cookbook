//package io.prisoner.learn.thread.product;
//
///**
// * DATE: 2017/8/17 23:23 <br>
// * MAIL: lbw@terminus.io <br>
// * AUTHOR: macbook
// */
//public class Producer{
//    private Integer product;
//
//    public static final Integer MAX_PRODUCT = 20;
//
//    public Integer getProduct() {
//        return product;
//    }
//
//    public void produce() {
//        if (this.product >= MAX_PRODUCT) {
//            System.out.println("producer has produced full product");
//            try {
//                wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            return;
//        }
//        this.product ++;
//        System.out.println("producer is producing " + this.product + "product");
//        notifyAll();
//    }
//}
