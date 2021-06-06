/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Ryan Harding
 */

package base;

import java.util.Scanner;

public class RoomArea {
  Scanner input = new Scanner(System.in);
  final double conversionFactor = 0.09290304;

  public static void main(String[] args) {
    RoomArea findArea = new RoomArea();
    String unitString = findArea.getUnits();
    double length = findArea.getLength();
    double width = findArea.getWidth();
    double area = findArea.getArea(length, width);
    System.out.println(findArea.printArea(length, width, area, unitString) + findArea.convertArea(area, unitString));
  }

  public String getUnits(){
    System.out.print("What units are your input values? Feet or Meters? ");
    String unitString = input.next();
    if (unitString.equalsIgnoreCase("feet")){
      return unitString;
    }
    else if(unitString.equalsIgnoreCase("meters")){
      return unitString;
    }
    else {
      System.out.println("ERROR: You did not answer Feet or Meters. Try again.");
      return getUnits();
    }
  }

  public double getLength(){
    System.out.print("What is the length of the room? ");
    String n = input.next();
    try {
      Double.parseDouble(n);
    }
    catch (NumberFormatException e) {
      System.out.println("ERROR: Invalid Value. Try Again.");
      return getLength();
    }
    return Double.parseDouble(n);
  }

  public double getWidth(){
    System.out.print("What is the width of the room? ");
    String n = input.next();
    try {
      Double.parseDouble(n);
    }
    catch (NumberFormatException e) {
      System.out.println("ERROR: Invalid Value. Try Again.");
      return getWidth();
    }
    return Double.parseDouble(n);
  }

  public String printArea(double length, double width, double area, String unitString){
    return String.format("The room is %.2f %s by %.2f %s.%nThe area is%n%.2f square %s.%n", length, unitString, width, unitString, area, unitString);
  }

  public double getArea(double length, double width){
    return length * width;
  }

  public String convertArea(double area, String unitString){
    double newArea = area;
    if (unitString.equalsIgnoreCase("feet")){
      newArea *= conversionFactor;
      return String.format("%.2f square meters.", newArea);
    }
    else if (unitString.equalsIgnoreCase("meters")){
      newArea /= conversionFactor;
      return String.format("%.2f square feet.", newArea);
    }
    else {
      return "ERROR: Invalid Unit String!";
    }
  }
}
