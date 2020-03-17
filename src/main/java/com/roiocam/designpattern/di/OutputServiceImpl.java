package com.roiocam.designpattern.di;

/**
 * @author Andy Chen
 * @date 2020/3/17 下午9:05
 */
public class OutputServiceImpl implements OutputService{
    @Override
    public void print() {
        this.printHelloWorldToConsole();
    }
    private void printHelloWorldToConsole(){
        System.out.println("Hello World");
    }

}
