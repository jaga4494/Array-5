// "static void main" must be defined in a public class.
/**
 * You are given a 0-indexed 2D integer array brackets where brackets[i] = [upperi, percenti] means that the ith tax bracket has an upper bound of upperi and is taxed at a rate of percenti. The brackets are sorted by upper bound (i.e. upperi-1 < upperi for 0 < i < brackets.length).
 * Tax is calculated as follows:
 * The first upper0 dollars earned are taxed at a rate of percent0.
 * The next upper1 - upper0 dollars earned are taxed at a rate of percent1.
 * The next upper2 - upper1 dollars earned are taxed at a rate of percent2.
 * And so on.
 * You are given an integer income representing the amount of money you earned. Return the amount of money that you have to pay in taxes. Answers within 10-5 of the actual answer will be accepted.

[10000, .10]
[10000, .10]
[10000, .10]
Eg with 25000
10000 * .10 = 1000
10000 * .20 = 2000
5000 * .30 = 1500
total = 4500

Eg with 35000
10000 * .10 = 1000
10000 * .20 = 2000
10000 * .30 = 3000
15000 * .40 = 6000
total = 12000
*/

// TC: O(1) - any country - constant number of slabs. 
public class Main {
    private static double calculateTax(List<List<Double>> slabs, double salary) {
        int index = 0;
        Double prevLimit = 0.0;
        double tax = 0;
        while (salary > 0) {
            Double currentLimit = slabs.get(index).get(0);
            double percent = slabs.get(index).get(1);
            
            if (currentLimit == null) {
                tax+= salary * percent;
                return tax;
            }
            
            double taxableAmount = Math.min(salary, currentLimit - prevLimit);
            tax += (taxableAmount * percent);
            
            salary -= taxableAmount;
            prevLimit = currentLimit;
            index++;
        }
        
        return tax;
    }
    
    public static void main(String[] args) {
        List<List<Double>> slabs = new ArrayList<>();
        // salary can be double
        slabs.add(Arrays.asList(10000.0, 0.10));
        slabs.add(Arrays.asList(20000.0, 0.20));
        slabs.add(Arrays.asList(30000.0, 0.30));
        slabs.add(Arrays.asList(null, 0.40));
        
        double salary = 50000.0;
        System.out.println(calculateTax(slabs, salary));
        
        
    }
}