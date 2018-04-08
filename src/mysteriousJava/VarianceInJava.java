package mysteriousJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by krishan on 07/04/18.
 */
public class VarianceInJava {

    public static void main(String[] args) {
        // General rule of thumb, mostly things are covariant except in the case of generics.
        //given the subtyping rules of Java, an array of type T[] may contain elements of type T or any subtype of T.
        //Case 1:
        Number arr[] = new Number[4];  //Covariant, Initally created as a Number type
        arr[0] = 1;
        arr[1] = 1.5;
        System.out.println(Arrays.toString(arr));
        //Case 2:
        //reifable example
        //arraysAreReifable();

        // Generics
        // the problem with generic types in Java is that the type information for type parameters is discarded by the compiler
        // after the compilation of code is done;
        // therefore this type information is not available at run time. This process is called type erasure.
        List<Number> numberList = new ArrayList<>();
        numberList.add(1);
        numberList.add(1.2);
        System.out.println(Arrays.toString(numberList.toArray()));

        // case 2
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
//        List<Number> numberList1 = integerList; //gives compile time error as generics are non reifable so at runtime we wont know the type and thus to avoid that the compile throws the error
//        numberList1.add(1.5);

        // Evidently, this is affecting the power of polymorphism and it needs to be fixed.
        // The solution consists in learning how to use two powerful features of Java generics known as covariance and contravariance.

        // Covariant declarations
        List<? extends Number> myNums = new ArrayList<Integer>();
        List<? extends Number> myNums1 = new ArrayList<Float>();
        List<? extends Number> myNums2 = new ArrayList<Double>();
        //myNums.add(new Integer(1));// not allowed to put things in it, we can only read from it

        // Contravariance For contravariance we use a different wildcard called ? super T, where T is our base type. With contravariance we can do the opposite.
        // We can put things into a generic structure, but we cannot read anything out of it.
        List<? super Number> myNums3 = new ArrayList<>();
        myNums3.add(2);
        Object num = myNums3.get(0);


    }

    private static void arraysAreReifable() {
        Integer arr1[] = new Integer[4]; // initially created as Integer array on heap and this type will be present at runtime which means reifable.
        arr1[0] = 1;
        Number[] number = arr1; // as it is reifable we are not getting compile time error as this can be caught at runtime.
        number[1] = 1.5; // will throw arrayStoreException at runtime
        System.out.println(Arrays.toString(number));
    }

}
