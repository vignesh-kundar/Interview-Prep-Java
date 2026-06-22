class SingleResponsiblityPrinciple {

    // exapmple for S in SOLID Principles
    public static void main (String args[]) {

    }
    // problem all Logic in the single class file!
    static class BadEmployee {
        /*
        * In this example the one single class handles all the operation,
        * where in every time the system has new changes in the logical behaviours -the logic in the class has to be changed!
        * Which is not the good practise!
        * */
        private String name;
        private Long salary;

        private String saveToDB( Object obj ) {
            // perform Database operation
            return "";
        }

        private Long calculatePay( Object obj ) {
            // perform salary pay Calculation
            return 0L;
        }

        private Object generateReport() {
            return new Object();
        }
    }

    // Solution to the problem - spint accroding to the responsibility
    // 1. Employee Object which contains all the attribute
    static class Employee {
        private Long salary;
        private String name;
        // other fileds
    }
    // 2. Remove / Seggegrate the tasks!
    static class PayCalculator {
        // will have methods that would calculate the pays
    }

    static class ReportGenerator {
        // this class will have methods that has to be generated for all the Employee Object
    }

    static class SaveToRepository {
        // performs database Saving operation!
    }

}