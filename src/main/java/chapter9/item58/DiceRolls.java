package chapter9.item58;

import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;

// Same bug as NestIteration.java (but different symptom)!!
public class DiceRolls {
  public static void main(String[] args) {
    // Same bug, different symptom!
    Collection<Face> faces = EnumSet.allOf(Face.class);

    for (Iterator<Face> i = faces.iterator(); i.hasNext(); ) {
      for (Iterator<Face> j = faces.iterator(); j.hasNext(); ) {
        System.out.println(i.next() + " " + j.next());
      }
    }

    System.out.println("***************************");

    for (Face face1 : faces) {
      for (Face face2 : faces) {
        System.out.println(face1 + " " + face2);
      }
    }
  }

  enum Face {
    ONE,
    TWO,
    THREE,
    FOUR,
    FIVE,
    SIX
  }
}
