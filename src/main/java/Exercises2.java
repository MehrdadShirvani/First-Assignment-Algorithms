import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;
public class Exercises2
{

    /*
    Given an array of integers nums and an integer target, return indices of the two numbers
    such that they add up to target.

    You may assume that each input would have exactly one solution, and you may not use the same element twice.
    You can return the answer in any order.
    */

    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length - 1; i++)
        {
            for (int j = i + 1; j < numbers.length; j++)
            {
                if(numbers[i] + numbers[j] == target)
                {
                    return new int[] {i,j};
                }
            }
        }
        return null;
    }

    /*
    Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

    Symbol       Value
    I             1
    V             5
    X             10
    L             50
    C             100
    D             500
    M             1000

    For example, 2 is written as II in Roman numeral, just two ones added together.
    12 is written as XII, which is simply X + II.
    The number 27 is written as XXVII, which is XX + V + II.

    Roman numerals are usually written largest to smallest from left to right.
    However, the numeral for four is not IIII.
    Instead, the number four is written as IV.
    Because the one is before the five we subtract it making four.
    The same principle applies to the number nine, which is written as IX.
    There are six instances where subtraction is used:

    I can be placed before V (5) and X (10) to make 4 and 9.
    X can be placed before L (50) and C (100) to make 40 and 90.
    C can be placed before D (500) and M (1000) to make 400 and 900.

    Given a roman numeral, convert it to an integer.
    */

    public int calculatePatternValue(String text, String pattern, int value)
    {
        int result = 0;
        while(text.contains(pattern))
        {
            result += value;
            text = text.replaceFirst(pattern, "");
        }

        return result;
    }

    public int romanToInt(String text)
    {
        int number = 0;
        Map<String, Integer> letterValues = new LinkedHashMap<>();
        letterValues.put("IV",4);
        letterValues.put("IX",9);
        letterValues.put("XL",40);
        letterValues.put("XC",90);
        letterValues.put("CD",400);
        letterValues.put("CM",900);
        letterValues.put("I",1);
        letterValues.put("V",5);
        letterValues.put("X",10);
        letterValues.put("L",50);
        letterValues.put("C",100);
        letterValues.put("D",500);
        letterValues.put("M",1000);

        for(String key : letterValues.keySet())
        {
            number += calculatePatternValue(text, key, letterValues.get(key));
            text = text.replace(key, "");
        }

        return number;
    }

    /*
    Given an array nums of distinct integers, return all the possible permutations.
    You can return the answer in any order.
    */



    List<List<Integer>> result = new ArrayList<>();
    public void GetOne(List<Integer> numberPools, List<Integer> theCurrentList)
    {
        if(numberPools.isEmpty())
        {
            result.add(theCurrentList);
        }
        for (int i = 0; i < numberPools.size(); i++)
        {
            //It's important not to change numberPools (because we're in the loop and that we don't want it to change for each iteration) or theCurrentList.
            ArrayList<Integer> newCurrentList = new ArrayList<>(theCurrentList);
            newCurrentList.add(numberPools.get(i));
            ArrayList<Integer> newNumberPool = new ArrayList<>(numberPools);
            newNumberPool.remove(i);
            GetOne(newNumberPool, newCurrentList);
        }
    }

    public List<List<Integer>> permute(int[] nums)
    {
        result = new ArrayList<>(); // Very Important, since it's global, it will have the ones from prior tests
        List<Integer> baseList = new ArrayList<>();
        for (int num : nums)
        {
            baseList.add(num);
        }
        GetOne(baseList, new ArrayList<>());
        return result;
    }

    public static void main(String[] args)
    {
        // test your code here!
    }
}